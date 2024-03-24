import { EPermType } from "src/types/enums/api/system";
import { IMenuCata, IMenuRapi, IMenuTree, IMenuView } from "src/types/interfaces/api/system/perm";

export default function () {
  const { notifyWarning } = useQNotify();
  const router = useRouter();

  function routePathIsReady(path: string) {
    return router.getRoutes().some((i) => i.path === path);
  }

  function addViewToMainRoute(menuView: IMenuView, menuCatas: IMenuCata[]) {
    const { permSign, name, icon, label, caption } = menuView;
    const catas = [...menuCatas, { name, icon, label, caption }];
    const path = catas.map((i) => i.name).join("/");
    router.addRoute(ROUTE_RECORD_MAIN.name, {
      name,
      path,
      component: importMainPage(permSign),
      meta: { icon, label, caption, catas },
    });
  }

  /* function addViewToParentRoute(parentName: string, menuView: IMenuView) {
    const { permSign, name, icon, label, caption } = menuView;
    const parentRoute = router.getRoutes().find(({ name }) => parentName === <string>name);
    if (parentRoute) {
      const catas = [...(parentRoute.meta?.catas || []), { name, icon, label, caption }];
      router.addRoute(parentName, {
        name,
        path: name,
        component: importMainPage(permSign),
        props: (route) => ({ id: Number(route.query.id) }),
        meta: { icon, label, caption, catas },
      });
    }
  } */

  function addRapiToParentRoute(parentName: string, menuRapi: IMenuRapi) {
    const parentRoute = router.getRoutes().find(({ name }) => parentName === <string>name);
    if (parentRoute) {
      const menuRapis = parentRoute.meta?.rapis || [];
      parentRoute.meta.rapis = [...menuRapis, menuRapi];
    }
  }

  function recurMenuViews(parentName: string, menus: IMenuTree[]) {
    menus.forEach(({ permType, permSign, name, icon, label, caption, children }) => {
      if (EPermType.VIEW === permType) {
        const message = `Please check child node(${name}) of ${parentName} in the menu-trees`;
        notifyWarning(message);
        if (children?.length) {
          recurMenuViews(name, children);
        }
      }
      if (EPermType.RAPI === permType) {
        addRapiToParentRoute(parentName, { permSign, name, icon, label, caption });
        if (children?.length) {
          recurMenuViews(name, children);
        }
      }
    });
  }

  function recurMenuTrees(menus: IMenuTree[], catas: IMenuCata[]) {
    menus.forEach(({ permType, permSign, name, icon, label, caption, children }) => {
      if (EPermType.CATA === permType && children?.length) {
        recurMenuTrees(children, [...catas, { name, icon, label, caption }]);
      }
      if (EPermType.VIEW === permType) {
        addViewToMainRoute({ permSign, name, icon, label, caption }, catas);
        if (children?.length) {
          recurMenuViews(name, children);
        }
      }
    });
  }

  return {
    routePathIsReady,
    recurMenuTrees,
  };
}
