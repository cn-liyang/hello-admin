import { ITablePagination } from "src/types/interfaces/quasar/table";
import { IPageResponse } from "src/types/interfaces/api/page";

export default function () {
  const paginationRef = ref<ITablePagination>(TABLE_PAGINATION_TEN);

  function setPaginationGetRecords(pageResponse: IPageResponse<Record<string, never>>) {
    const { pageNumber, pageSize, totalRow, records } = pageResponse;
    if (getRef(paginationRef).page !== pageNumber) {
      setRef(getRef(paginationRef), "page", pageNumber);
    }
    if (getRef(paginationRef).rowsPerPage !== pageSize) {
      setRef(getRef(paginationRef), "rowsPerPage", pageSize);
    }
    if (getRef(paginationRef).rowsNumber !== totalRow) {
      setRef(getRef(paginationRef), "rowsNumber", totalRow);
    }
    return records;
  }

  return {
    paginationRef,
    setPaginationGetRecords,
  };
}
