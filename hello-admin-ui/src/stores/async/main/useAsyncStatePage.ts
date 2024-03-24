import { IRestApi } from "src/types/interfaces/api";
import { IPageRequest, IPageResponse } from "src/types/interfaces/api/page";

export default function (restApi: IRestApi) {
  const { paginationRef, setPaginationGetRecords } = useQTablePagination();

  const {
    state: pageResponseRef,
    isReady: pageIsReadyRef,
    isLoading: pageIsLoadingRef,
    execute: pageExecute,
  } = useAsyncState<IPageResponse<Record<string, never>>, IPageRequest[]>(
    (args) => doRequest(restApi, args),
    API_RESPONSE_PAGE,
    {
      immediate: false,
    },
  );

  async function executePage(pageRequest: IPageRequest) {
    return pageExecute(0, pageRequest).then((i) => Promise.resolve(setPaginationGetRecords(i)));
  }

  return {
    paginationRef,
    pageResponseRef,
    pageIsReadyRef,
    pageIsLoadingRef,
    pageExecute,
    executePage,
  };
}
