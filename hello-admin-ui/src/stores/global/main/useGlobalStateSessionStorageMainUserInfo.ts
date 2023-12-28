import { IUserInfo } from "src/types/interfaces/main";

export const USER_INFO: IUserInfo = {
  userId: 0,
  nickname: "A",
  avatar: "",
};

export default createGlobalState(() => {
  const userInfoRemovableRef = useSessionStorage(SESSION_STORAGE_KEY_MAIN_USER_INFO, USER_INFO);

  return {
    userInfoRemovableRef,
  };
});
