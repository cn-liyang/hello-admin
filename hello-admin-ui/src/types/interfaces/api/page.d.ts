import { ITablePagination } from "src/types/interfaces/quasar/table";
import { EQueryOperator } from "src/types/enums/api/sql";
import { EValueType } from "src/types/enums/table";
import { IId } from "src/types/interfaces/api/system";

export interface ISearchCondition {
  field: string;
  value: string;
  valueType: EValueType;
  operator: EQueryOperator;
}

export interface IPaginationRequest extends IId {
  pagination: ITablePagination;
}

export interface IPageRequest extends IPaginationRequest {
  conditions?: ISearchCondition[];
}

export interface IPage {
  pageNumber: number;
  pageSize: number;
  totalPage: number;
  totalRow: number;
}

export interface IPageResponse<T> extends IPage {
  records: T[];
}
