import { EHttpMethod } from "src/types/enums";
import { IIdRequest } from "src/types/interfaces/api/system/base";

export default function <T extends object>(apiPath: string, searchId: number) {
  const {
    state: searchResponseRef,
    isReady: searchIsReadyRef,
    isLoading: searchIsLoadingRef,
    execute: searchExecute,
  } = useAsyncState<T[], IIdRequest[]>(
    (args) =>
      doRequest(
        {
          method: EHttpMethod.POST,
          url: apiPath + API_PATH_PATTERN_LEAFS,
        },
        args,
      ),
    [],
    {
      immediate: false,
    },
  );

  function executeSearch() {
    return searchExecute(0, { id: searchId });
  }

  return {
    searchResponseRef,
    searchIsReadyRef,
    searchIsLoadingRef,
    searchExecute,
    executeSearch,
  };
}
