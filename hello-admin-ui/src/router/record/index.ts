import { RouteRecordRaw } from "vue-router";

export const ROUTE_RECORD_GATE = {
  name: uid(),
  path: "/gate",
  component: () => import("layouts/gate/GateLayout.vue"),
} as const;
export const ROUTE_RECORD_GATE_LOGIN = {
  name: uid(),
  path: "/login",
  component: () => import("pages/gate/login/LoginPage.vue"),
} as const;

export const ROUTE_RECORD_MAIN = {
  name: uid(),
  path: "/",
  component: () => import("layouts/main/MainLayout.vue"),
} as const;
export const ROUTE_RECORD_MAIN_HOME = {
  name: uid(),
  path: "/home",
  component: () => import("pages/main/HomePage.vue"),
} as const;

export const ROUTE_RECORD_NONE = {
  name: uid(),
  path: "/none",
  component: () => import("layouts/none/NoneLayout.vue"),
} as const;
export const ROUTE_RECORD_NONE_404 = {
  name: uid(),
  path: "/:pathMatch(.*)*",
  component: () => import("pages/none/n404/N404Page.vue"),
} as const;

export const ROUTE_RECORDS: RouteRecordRaw[] = [
  {
    ...ROUTE_RECORD_GATE,
    redirect: ROUTE_RECORD_GATE_LOGIN.path,
    children: [
      {
        ...ROUTE_RECORD_GATE_LOGIN,
        meta: { icon: "mdi-login", label: "登录", caption: "" },
      },
    ],
  },
  {
    ...ROUTE_RECORD_MAIN,
    redirect: ROUTE_RECORD_MAIN_HOME.path,
    children: [
      {
        ...ROUTE_RECORD_MAIN_HOME,
        meta: { icon: "mdi-home", label: "主页", caption: "" },
      },
    ],
  },
  {
    ...ROUTE_RECORD_NONE,
    redirect: ROUTE_RECORD_NONE_404.path,
    children: [
      {
        ...ROUTE_RECORD_NONE_404,
        meta: { icon: "mdi-hamburger-remove", label: "404", caption: "" },
      },
    ],
  },
];

export const ROUTE_PATHS_WHITELIST: string[] = [ROUTE_RECORD_GATE_LOGIN.path];
