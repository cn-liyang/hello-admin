import { IRestApi } from "src/types/interfaces/api";

export default function <T extends object>(restApi: IRestApi, request: T) {
  const requestRef = ref<T>(request);

  const {
    state: responseRef,
    isReady: isReadyRef,
    isLoading: isLoadingRef,
    execute,
  } = useAsyncState<boolean, T[]>((args) => doRequest(restApi, args), false, {
    immediate: false,
  });

  async function doExecute() {
    return execute(0, <T>getRef(requestRef)).then((r) => (r ? Promise.resolve() : Promise.reject(r)));
  }

  return {
    requestRef,
    responseRef,
    isReadyRef,
    isLoadingRef,
    execute,
    doExecute,
  };
}
