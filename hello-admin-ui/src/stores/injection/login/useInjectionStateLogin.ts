import { ICaptchaResponse, ILoginRequest, ILoginResponse } from "src/types/interfaces/api/login";

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
const API_RESPONSE_LOGIN: ILoginResponse = {
  userInfo: USER_INFO,
};

const [useProvidingStateLogin, _useInjectedStateLogin] = createInjectionState(() => {
  const { asyncRouteToMain } = useRouteNavigation();
  const { userInfoRemovableRef } = useGlobalStateSessionStorageMainUserInfo();

  const loginRequestRef = ref(API_REQUEST_LOGIN);

  const {
    state: captchaResponseRef,
    isReady: captchaIsReadyRef,
    isLoading: captchaIsLoadingRef,
    execute: captchaExecute,
  } = useAsyncState<ICaptchaResponse>(() => asyncRequest(API_REST_CAPTCHA), API_RESPONSE_CAPTCHA, {
    ...USE_ASYNC_STATE_OPTIONS,
    onSuccess: ({ id }) => {
      setRef(getRef(loginRequestRef), "id", id);
      setRef(getRef(loginRequestRef), "code", "");
    },
  });

  const {
    state: loginResponseRef,
    isReady: loginIsReadyRef,
    isLoading: loginIsLoadingRef,
    execute: loginExecute,
  } = useAsyncState<ILoginResponse, ILoginRequest[]>((args) => asyncRequest(API_REST_LOGIN, args), API_RESPONSE_LOGIN, {
    ...USE_ASYNC_STATE_OPTIONS,
    onSuccess: async ({ userInfo }) => {
      setRef(userInfoRemovableRef, userInfo);
      await asyncRouteToMain();
    },
    onError: () => captchaExecute(),
  });

  async function asyncLogin() {
    await loginExecute(0, getRef(loginRequestRef));
  }

  return {
    captchaResponseRef,
    captchaIsReadyRef,
    captchaIsLoadingRef,
    captchaExecute,
    loginRequestRef,
    loginResponseRef,
    loginIsReadyRef,
    loginIsLoadingRef,
    asyncLogin,
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
      loginResponseRef: ref(API_RESPONSE_LOGIN),
      loginIsReadyRef: ref(false),
      loginIsLoadingRef: ref(false),
      asyncLogin: () => undefined,
    }
  );
}

export { useProvidingStateLogin, useInjectedStateLogin };
