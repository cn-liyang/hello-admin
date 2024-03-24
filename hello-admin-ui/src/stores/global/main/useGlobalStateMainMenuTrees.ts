import { IRestApi } from "src/types/interfaces/api";
import { EHttpMethod } from "src/types/enums";
import { IMenuTree } from "src/types/interfaces/api/system/perm";
import { EPermType } from "src/types/enums/api/system";
import { RouteMeta } from "vue-router";

export const API_REST_MENU_TREES: IRestApi = {
  method: EHttpMethod.GET,
  url: "/menu-trees",
} as const;

export default createGlobalState(() => {
  const { recurMenuTrees } = useRouteRecord();

  const {
    state: menuTreesResponseRef,
    isReady: menuTreesIsReadyRef,
    isLoading: menuTreesIsLoadingRef,
    execute: menuTreesExecute,
  } = useAsyncState<IMenuTree[]>(() => doRequest(API_REST_MENU_TREES), [], {
    immediate: false,
    onSuccess: (r) => recurMenuTrees(r, []),
  });

  const menuTreeComputedRef = computed(
    () =>
      ROUTE_RECORDS.find((i) => i.name === ROUTE_RECORD_MAIN.name)
        ?.children?.map(({ name, meta }) => {
          const { icon, label, caption } = <RouteMeta>meta;
          return <IMenuTree>{
            name,
            icon,
            label,
            caption,
            permType: EPermType.VIEW,
            permSign: "",
          };
        })
        .concat(getRef(menuTreesResponseRef)),
  );

  return {
    menuTreesResponseRef,
    menuTreesIsReadyRef,
    menuTreesIsLoadingRef,
    menuTreesExecute,
    menuTreeComputedRef,
  };
});
