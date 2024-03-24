import { IRestApi } from "src/types/interfaces/api";
import { EHttpMethod } from "src/types/enums";
import { IUserInfo } from "src/types/interfaces/api/system/user/userInfo";

export const API_REST_USER_INFO: IRestApi = {
  method: EHttpMethod.GET,
  url: "/user-info",
} as const;

export default createGlobalState(() => {
  const { doRequestWithAes } = useGlobalStateMainAesPair();

  const {
    state: userInfoResponseRef,
    isReady: userInfoIsReadyRef,
    isLoading: userInfoIsLoadingRef,
    execute: userInfoExecute,
  } = useAsyncState<IUserInfo>(
    () => /*doRequest(API_REST_USER_INFO)*/ doRequestWithAes(API_REST_USER_INFO),
    {
      nickname: "",
      avatar: "",
    },
    {
      immediate: false,
    },
  );
  const userInfoRemovableRef = useSessionStorage(SESSION_STORAGE_KEY_START_USER_INFO, userInfoResponseRef);

  return {
    userInfoResponseRef,
    userInfoIsReadyRef,
    userInfoIsLoadingRef,
    userInfoExecute,
    userInfoRemovableRef,
  };
});
