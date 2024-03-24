import { InjectionError } from "src/types/classes/error/injection";
import { ILoginAccount, ILoginRequest, ILoginResponse } from "src/types/interfaces/api/entry/login";

const LOGIN_ACCOUNT: ILoginAccount = {
  username: "Admin",
  password: "Admin123",
};
const API_RESPONSE_LOGIN: ILoginResponse = {
  aesPair: API_RESPONSE_AES_PAIR,
};

const [useProvidingStateGateLogin, _useInjectedStateGateLogin] = createInjectionState(() => {
  const { loginCodeRef, captchaExecute } = useProvidingStateGateCaptcha();
  const { userInfoExecute } = useGlobalSessionStorageMainUserInfo();

  const { setAesPair } = useGlobalStateMainAesPair();
  const { routeToMain } = useRouteNavigation();

  const loginAccountRef = ref(LOGIN_ACCOUNT);

  const {
    state: loginResponseRef,
    isReady: loginIsReadyRef,
    isLoading: loginIsLoadingRef,
    execute: loginExecute,
  } = useAsyncState<ILoginResponse, ILoginRequest[]>(
    (args) => /*doRequest(API_REST_LOGIN, args)*/ doRequestWithRsa(API_REST_LOGIN, args),
    API_RESPONSE_LOGIN,
    {
      immediate: false,
      onSuccess: async ({ aesPair }) => {
        setAesPair(aesPair);
        await userInfoExecute();
        await routeToMain();
      },
      onError: () => captchaExecute(),
    },
  );

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
