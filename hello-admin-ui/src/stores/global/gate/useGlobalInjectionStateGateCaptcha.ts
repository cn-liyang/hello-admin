import { InjectionError } from "src/types/classes/error/injection";
import { ICaptchaResponse, ILoginCode } from "src/types/interfaces/api/entry/login";

const LOGIN_CODE: ILoginCode = {
  id: "",
  code: "",
};
const API_RESPONSE_CAPTCHA: ICaptchaResponse = {
  id: "",
  dataUrl: "",
};

const [useProvidingStateGateCaptcha, _useInjectedStateGateCaptcha] = createInjectionState(() => {
  const loginCodeRef = ref(LOGIN_CODE);

  const {
    state: captchaResponseRef,
    isReady: captchaIsReadyRef,
    isLoading: captchaIsLoadingRef,
    execute: captchaExecute,
  } = useAsyncState<ICaptchaResponse>(() => doRequest(API_REST_CAPTCHA), API_RESPONSE_CAPTCHA, {
    immediate: false,
    onSuccess: ({ id }) => {
      setRef(getRef(loginCodeRef), "id", id);
      setRef(getRef(loginCodeRef), "code", "");
    },
  });

  return {
    loginCodeRef,
    captchaResponseRef,
    captchaIsReadyRef,
    captchaIsLoadingRef,
    captchaExecute,
  };
});

function useInjectedStateGateCaptcha() {
  const injectedState = _useInjectedStateGateCaptcha();
  if (!injectedState) {
    const injectionError = new InjectionError("useProvidingStateGateCaptcha");
    qNotifyWarning(injectionError.message);
    throw injectionError;
  }
  return injectedState;
}

export { useProvidingStateGateCaptcha, useInjectedStateGateCaptcha };
