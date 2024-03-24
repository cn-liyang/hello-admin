import { route } from "quasar/wrappers";
import { createMemoryHistory, createRouter, createWebHashHistory, createWebHistory } from "vue-router";
import { IMenuCata, IMenuRapi } from "src/types/interfaces/api/system/perm";

declare module "vue-router" {
  export interface RouteMeta {
    icon: string;
    label: string;
    caption: string;
    cached?: boolean;
    catas?: IMenuCata[];
    rapis?: IMenuRapi[];
  }
}

/*
 * If not building with SSR mode, you can
 * directly export the Router instantiation;
 *
 * The function below can be async too; either use
 * async/await or return a Promise which resolves
 * with the Router instance.
 */

export default route(function (/* { store, ssrContext } */) {
  const createHistory = process.env.SERVER
    ? createMemoryHistory
    : process.env.VUE_ROUTER_MODE === "history"
    ? createWebHistory
    : createWebHashHistory;

  const router = createRouter({
    scrollBehavior: () => ({ left: 0, top: 0 }),
    routes: ROUTE_RECORDS,

    // Leave this as is and make changes in quasar.conf.js instead!
    // quasar.conf.js -> build -> vueRouterMode
    // quasar.conf.js -> build -> publicPath
    history: createHistory(process.env.VUE_ROUTER_BASE),
  });
  router.beforeEach(guardBeforeEach);
  router.beforeResolve(guardBeforeResolve);
  // router.afterEach(guardAfterEach);
  return router;
});
