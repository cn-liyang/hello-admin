import { ITableColumn } from "src/types/interfaces/quasar/table";
import { EValueType } from "src/types/enums/table";

export const TABLE_COLUMN_USER_USERNAME: ITableColumn = {
  name: "username",
  field: "username",
  valueType: EValueType.TEXT,
  label: "账号",
  align: "left",
  required: true,
};
export const TABLE_COLUMNS_USER: ITableColumn[] = [
  TABLE_COLUMN_USER_USERNAME,
  {
    name: "password",
    field: "password",
    valueType: EValueType.TEXT,
    label: "密码",
    align: "left",
  },
  {
    name: "expiredAccount",
    field: "expiredAccount",
    valueType: EValueType.BOOL,
    label: "是否过期账户",
    align: "left",
  },
  {
    name: "expiredPassword",
    field: "expiredPassword",
    valueType: EValueType.BOOL,
    label: "是否过期密码",
    align: "left",
  },
  {
    name: "locked",
    field: "locked",
    label: "是否锁定",
    valueType: EValueType.BOOL,
    align: "left",
  },
  {
    name: "enabled",
    label: "是否启用",
    valueType: EValueType.BOOL,
    field: "enabled",
    align: "left",
  },
];

export const TABLE_COLUMNS_USER_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  ...TABLE_COLUMNS_USER,
  ...TABLE_COLUMNS_BASE,
];

export const TABLE_COLUMN_USER_ID: ITableColumn = {
  name: "userId",
  field: "userId",
  valueType: EValueType.NUMB,
  label: "用户主键",
  align: "left",
} as const;
