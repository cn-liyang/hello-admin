import { ICaptchaResponse, ILoginRequest } from "src/types/interfaces/api/login";

const API_RESPONSE_CAPTCHA: ICaptchaResponse = {
  id: "",
  dataUrl: "",
};
const API_REQUEST_LOGIN: ILoginRequest = {
  id: "",
  code: "",
  username: "Admin",
  password: "Admin123",
};

const [useProvidingStateLogin, _useInjectedStateLogin] = createInjectionState(() => {
  const { asyncRouteToMain } = useRouteNavigation();
  const { settingRemovableRef } = useGlobalStateLocalStorageSetting();

  const loginRequestRef = ref(API_REQUEST_LOGIN);

  const {
    state: captchaResponseRef,
    isReady: captchaIsReadyRef,
    isLoading: captchaIsLoadingRef,
    execute: captchaExecute,
  } = useAsyncState<ICaptchaResponse>(() => asyncRequest(API_REST_CAPTCHA), API_RESPONSE_CAPTCHA, {
    ...USE_ASYNC_STATE_OPTIONS,
    onSuccess: (r) => {
      setRef(getRef(loginRequestRef), "id", r.id);
      setRef(getRef(loginRequestRef), "code", "");
    },
  });

  const {
    // state: loginResponseRef,
    isReady: loginIsReadyRef,
    isLoading: loginIsLoadingRef,
    execute: loginExecute,
  } = useAsyncState<undefined, ILoginRequest[]>((args) => asyncRequest(API_REST_LOGIN, args), undefined, {
    ...USE_ASYNC_STATE_OPTIONS,
    onSuccess: () => asyncRouteToMain(),
    onError: () => captchaExecute(),
  });

  async function asyncLoginAccount() {
    setRef(getRef(settingRemovableRef), "username", getRef(loginRequestRef, "username"));
    await loginExecute(0, getRef(loginRequestRef));
  }

  return {
    captchaResponseRef,
    captchaIsReadyRef,
    captchaIsLoadingRef,
    captchaExecute,
    loginRequestRef: loginRequestRef,
    loginIsReadyRef,
    loginIsLoadingRef,
    asyncLoginAccount,
  };
});

function useInjectedStateLogin() {
  return (
    _useInjectedStateLogin() ?? {
      captchaResponseRef: ref(API_RESPONSE_CAPTCHA),
      captchaIsReadyRef: ref(false),
      captchaIsLoadingRef: ref(false),
      captchaExecute: () => undefined,
      loginRequestRef: ref(API_REQUEST_LOGIN),
      loginIsReadyRef: ref(false),
      loginIsLoadingRef: ref(false),
      asyncLoginAccount: () => undefined,
    }
  );
}

export { useProvidingStateLogin, useInjectedStateLogin };
