import { QTableColumn, QTableProps } from "quasar";
import { EValueType } from "src/types/enums/table";

export interface ITableColumn extends QTableColumn {
  valueType?: EValueType;
  ignored?: boolean;
}

export type ITablePagination = NonNullable<Required<QTableProps>["pagination"]>;

export type ITableOnRequestParameters = Parameters<Required<QTableProps>["onRequest"]>[0];
