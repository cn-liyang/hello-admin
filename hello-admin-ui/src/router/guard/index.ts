import { NavigationGuardNext, RouteLocationNormalized } from "vue-router";
import { SessionStorage } from "quasar";

export function guardBeforeEach(
  to: RouteLocationNormalized,
  _from: RouteLocationNormalized,
  next: NavigationGuardNext,
) {
  if (SessionStorage.getItem(SESSION_STORAGE_KEY_AUTHORIZATION)) {
    if (ROUTE_PATHS_WHITELIST.includes(to.path)) {
      next();
    } else {
      if (to.path === ROUTE_RECORD_GATE_LOGIN.path) {
        next({ path: ROUTE_RECORD_MAIN.path });
      } else {
        const { addTab } = useGlobalStateMainTabs();
        addTab(to);
        next();
      }
    }
  } else {
    if (ROUTE_PATHS_WHITELIST.includes(to.path)) {
      next();
    } else {
      next({ path: ROUTE_RECORD_GATE_LOGIN.path, query: { [ROUTE_QUERY_KEY_REDIRECT]: to.fullPath } });
    }
  }
}

export function guardBeforeResolve(to: RouteLocationNormalized) {
  const { setTab } = useGlobalStateMainTabs();
  setTab(to);
}

/* export function guardAfterEach(to: RouteLocationNormalized) {
  // TODO
} */
