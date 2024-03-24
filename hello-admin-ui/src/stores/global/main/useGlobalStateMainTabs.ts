import { IPathLabel } from "src/types/interfaces/quasar";
import { RouteLocationNormalized } from "vue-router";

export default createGlobalState(() => {
  const router = useRouter();
  const tabRef = ref(ROUTE_RECORD_MAIN_HOME.path);
  const tabsRef = ref<IPathLabel[]>([{ path: ROUTE_RECORD_MAIN_HOME.path, label: "主页" }]);

  function addTab({ name, path, meta: { label } }: RouteLocationNormalized) {
    if (ROUTE_RECORD_NONE_404.name === name) {
      return;
    }
    if (getRef(tabsRef).some((i) => i.path === path)) {
      return;
    }
    getRef(tabsRef).push({ path, label });
  }

  function setTab({ name, path }: RouteLocationNormalized) {
    if (ROUTE_RECORD_NONE_404.name === name) {
      return;
    }
    if (getRef(tabRef) === path) {
      return;
    }
    setRef(tabRef, path);
  }

  function removeTab(path: string) {
    const tabs = getRef(tabsRef);
    if (!tabs.some((i) => i.path === path)) {
      return;
    }
    const targetIndex = tabs.findIndex((i) => i.path === path);
    const spliceArray = tabs.splice(targetIndex, 1);
    if (spliceArray.length) {
      const leftPath = tabs[targetIndex - 1 > 0 ? targetIndex - 1 : 0].path;
      router.replace(leftPath).then(() => setRef(tabRef, leftPath));
    }
  }

  return {
    tabRef,
    tabsRef,
    addTab,
    setTab,
    removeTab,
  };
});
