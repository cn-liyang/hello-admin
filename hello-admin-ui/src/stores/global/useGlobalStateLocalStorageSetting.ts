import { ISetting } from "src/types/interfaces";

const SETTING: ISetting = {
  username: "",
  mainLayout: {
    drawerLeftIsShow: true,
    drawerRightIsShow: false,
  },
};

export default createGlobalState(() => {
  const settingRemovableRef = useStorageAsync(LOCAL_STORAGE_KEY_SETTING, SETTING);

  return {
    settingRemovableRef,
  };
});
