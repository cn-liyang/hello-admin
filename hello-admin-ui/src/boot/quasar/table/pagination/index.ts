import { ITablePagination } from "src/types/interfaces/quasar/table";

export const TABLE_PAGINATION_TEN: ITablePagination = {
  page: 1,
  rowsPerPage: 10,
  rowsNumber: -1,
} as const;

export const TABLE_PAGINATION_INFINITE: ITablePagination = {
  page: 1,
  rowsPerPage: 0,
} as const;
