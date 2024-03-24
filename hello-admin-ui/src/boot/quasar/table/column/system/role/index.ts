import { ITableColumn } from "src/types/interfaces/quasar/table";
import { EValueType } from "src/types/enums/table";

export const TABLE_COLUMNS_ROLE_NAME: ITableColumn = {
  name: "name",
  field: "name",
  valueType: EValueType.TEXT,
  label: "名称",
  align: "left",
  required: true,
};
export const TABLE_COLUMNS_ROLE_LABEL: ITableColumn = {
  name: "label",
  field: "label",
  valueType: EValueType.TEXT,
  label: "标签",
  align: "left",
};
export const TABLE_COLUMNS_ROLE: ITableColumn[] = [TABLE_COLUMNS_ROLE_NAME, TABLE_COLUMNS_ROLE_LABEL];

export const TABLE_COLUMNS_ROLE_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  ...TABLE_COLUMNS_ROLE,
  ...TABLE_COLUMNS_BASE,
];

export const TABLE_COLUMN_ROLE_ID: ITableColumn = {
  name: "roleId",
  field: "roleId",
  valueType: EValueType.NUMB,
  label: "角色主键",
  align: "left",
} as const;
