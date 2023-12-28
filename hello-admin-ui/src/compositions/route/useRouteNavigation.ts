export default function () {
  const router = useRouter();
  const redirectRef = useRouteQuery(ROUTE_QUERY_KEY_REDIRECT, ROUTE_RECORD_MAIN.path);

  async function asyncRouteToGate() {
    await router.replace(ROUTE_RECORD_GATE.path);
  }

  async function asyncRouteToMain() {
    await router.replace(<string>getRef(redirectRef));
  }

  return {
    asyncRouteToGate,
    asyncRouteToMain,
  };
}
