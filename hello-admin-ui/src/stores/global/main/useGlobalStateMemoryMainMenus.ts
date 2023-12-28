import { RouteMeta } from "vue-router";
import { IOption } from "src/types/interfaces/main";

export default createGlobalState(() => {
  const mainMenusComputedRef = computed(
    () =>
      ROUTE_RECORDS.find(({ name }) => name === ROUTE_RECORD_MAIN.name)?.children?.map(({ name, meta }) => {
        const { icon, label, caption } = <RouteMeta>meta;
        return <IOption>{ name, icon, label, caption };
      }),
  );

  return {
    mainMenusComputedRef,
  };
});
