import { ITableColumn } from "src/types/interfaces/quasar/table";

export const TABLE_COLUMN_OPERATION: ITableColumn = {
  name: "operation",
  field: "operation",
  label: "操作",
  required: true,
  align: "center",
} as const;
