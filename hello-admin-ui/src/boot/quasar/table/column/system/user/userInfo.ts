import { ITableColumn } from "src/types/interfaces/quasar/table";
import { EValueType } from "src/types/enums/table";

export const TABLE_COLUMNS_USER_INFO: ITableColumn[] = [
  {
    name: "nickname",
    field: "nickname",
    valueType: EValueType.TEXT,
    label: "昵称",
    align: "left",
    required: true,
  },
  {
    name: "avatar",
    field: "avatar",
    valueType: EValueType.TEXT,
    label: "头像",
    align: "left",
  },
];

export const TABLE_COLUMNS_USER_INFO_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  TABLE_COLUMN_USER_ID,
  ...TABLE_COLUMNS_USER_INFO,
  ...TABLE_COLUMNS_BASE,
];
