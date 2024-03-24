import { EHttpMethod } from "src/types/enums";
import { IPageRequest } from "src/types/interfaces/api/page";
import { ITableOnRequestParameters } from "src/types/interfaces/quasar/table";

export default function (apiPath: string, searchId: number) {
  const { paginationRef, executePage } = useAsyncStatePage({
    method: EHttpMethod.POST,
    url: apiPath,
  });

  const {
    state: searchResponseRef,
    isReady: searchIsReadyRef,
    isLoading: searchIsLoadingRef,
    execute: searchExecute,
  } = useAsyncState<Record<string, never>[], IPageRequest[]>((args) => executePage(args), [], {
    immediate: false,
    resetOnExecute: false,
  });

  async function doRequest(props: ITableOnRequestParameters) {
    // FIXME: console.log("descending", props?.pagination?.descending);
    await searchExecute(0, { id: searchId, pagination: props.pagination, conditions: props.filter });
  }

  return {
    paginationRef,
    searchResponseRef,
    searchIsReadyRef,
    searchIsLoadingRef,
    searchExecute,
    doRequest,
  };
}
