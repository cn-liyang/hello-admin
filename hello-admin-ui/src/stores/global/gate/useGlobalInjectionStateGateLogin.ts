import { InjectionError } from "src/types/classes/error/injection";
import { ILoginAccount, ILoginRequest } from "src/types/interfaces/api/entry/login";

const LOGIN_ACCOUNT: ILoginAccount = {
  username: "Admin",
  password: "Admin123",
};

const [useProvidingStateGateLogin, _useInjectedStateGateLogin] = createInjectionState(() => {
  const { loginCodeRef, captchaExecute } = useProvidingStateGateCaptcha();
  const { routeToMain } = useRouteNavigation();

  const loginAccountRef = ref(LOGIN_ACCOUNT);

  const {
    state: loginResponseRef,
    isReady: loginIsReadyRef,
    isLoading: loginIsLoadingRef,
    execute: loginExecute,
  } = useAsyncState<undefined, ILoginRequest[]>((args) => doRequest(API_REST_LOGIN, args), undefined, {
    immediate: false,
    onSuccess: async () => {
      await routeToMain();
    },
    onError: () => captchaExecute(),
  });

  async function doLogin() {
    await loginExecute(0, { ...getRef(loginCodeRef), ...getRef(loginAccountRef) });
  }

  return {
    loginAccountRef,
    loginResponseRef,
    loginIsReadyRef,
    loginIsLoadingRef,
    doLogin,
  };
});

function useInjectedStateGateLogin() {
  const injectedState = _useInjectedStateGateLogin();
  if (!injectedState) {
    const injectionError = new InjectionError("useProvidingStateGateLogin");
    qNotifyWarning(injectionError.message);
    throw injectionError;
  }
  return injectedState;
}

export { useProvidingStateGateLogin, useInjectedStateGateLogin };
