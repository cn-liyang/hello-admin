import { ERestMethod } from "src/types/enums/api";

export const API_REST_LOGOUT = {
  method: ERestMethod.DELETE,
  url: "/logout",
} as const;

export default function () {
  const $q = useQuasar();
  const { asyncRouteToGate } = useRouteNavigation();

  const { execute: executeLogout } = useAsyncState<undefined>(() => asyncRequest(API_REST_LOGOUT), undefined, {
    ...USE_ASYNC_STATE_OPTIONS,
    onSuccess: () => $q.sessionStorage.clear(),
    onError: () => $q.sessionStorage.clear(),
  });

  async function asyncLogout() {
    await Promise.allSettled([executeLogout(), asyncRouteToGate()]);
  }

  return {
    asyncLogout,
  };
}
