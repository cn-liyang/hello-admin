import { IPageResponse } from "src/types/interfaces/api/page";

export const API_RESPONSE_PAGE: IPageResponse<never> = {
  pageNumber: 0,
  pageSize: 0,
  totalPage: -1,
  totalRow: -1,
  records: [],
};
