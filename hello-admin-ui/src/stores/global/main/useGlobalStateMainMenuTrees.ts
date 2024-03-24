import { IMenuTree } from "src/types/interfaces/api/system/perm";
import { EPermType } from "src/types/enums/api/system";
import { RouteMeta } from "vue-router";

export default createGlobalState(() => {
  const menuTreeComputedRef = computed(
    () =>
      ROUTE_RECORDS.find((i) => i.name === ROUTE_RECORD_MAIN.name)?.children?.map(({ name, meta }) => {
        const { icon, label, caption } = <RouteMeta>meta;
        return <IMenuTree>{
          name,
          icon,
          label,
          caption,
          permType: EPermType.VIEW,
          permSign: "",
        };
      }),
  );

  return {
    menuTreeComputedRef,
  };
});
