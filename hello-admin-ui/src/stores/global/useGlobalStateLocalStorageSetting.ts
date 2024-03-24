import { ISetting } from "src/types/interfaces";

export const SETTING: ISetting = {
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
