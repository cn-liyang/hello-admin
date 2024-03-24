import { EHttpMethod } from "src/types/enums";

export const API_REST_LOGOUT = {
  method: EHttpMethod.DELETE,
  url: "/logout",
} as const;

export default function () {
  const $q = useQuasar();
  const { routeToGate } = useRouteNavigation();

  const { execute: executeLogout } = useAsyncState<undefined>(() => doRequest(API_REST_LOGOUT), undefined, {
    immediate: false,
  });

  async function doLogout() {
    if ($q.sessionStorage.getLength()) {
      await executeLogout();
      $q.sessionStorage.clear();
    }
    await routeToGate();
  }

  return {
    doLogout,
  };
}
