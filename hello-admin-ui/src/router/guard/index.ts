import { NavigationGuardNext, RouteLocationNormalized } from "vue-router";
import { SessionStorage } from "quasar";

export function guardBeforeEach(
  to: RouteLocationNormalized,
  _from: RouteLocationNormalized,
  next: NavigationGuardNext,
) {
  if (ROUTE_PATHS_WHITELIST.includes(to.path)) {
    next();
  } else {
    if (SessionStorage.getItem(SESSION_STORAGE_KEY_TOKEN)) {
      next();
    } else {
      next({ path: ROUTE_RECORD_GATE_LOGIN.path, query: { [ROUTE_QUERY_KEY_REDIRECT]: to.fullPath } });
    }
  }
}

export function guardBeforeResolve() {
  // TODO
}

export function guardAfterEach() {
  // TODO
}
