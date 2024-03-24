import { ITableColumn } from "src/types/interfaces/quasar/table";
import { EValueType } from "src/types/enums/table";

export const TABLE_COLUMN_ID: ITableColumn = {
  name: "id",
  field: "id",
  valueType: EValueType.NUMB,
  label: "主键",
  align: "left",
} as const;

export const TABLE_COLUMNS_BASE: ITableColumn[] = [
  {
    name: "createBy",
    field: "createBy",
    valueType: EValueType.TEXT,
    label: "创建人员",
    align: "left",
  },
  {
    name: "createAt",
    field: "createAt",
    valueType: EValueType.TIME,
    label: "创建时间",
    align: "left",
  },
  {
    name: "updateBy",
    field: "updateBy",
    valueType: EValueType.TEXT,
    label: "更新人员",
    align: "left",
  },
  {
    name: "updateAt",
    field: "updateAt",
    valueType: EValueType.TIME,
    label: "更新时间",
    align: "left",
  },
  {
    name: "remark",
    field: "remark",
    valueType: EValueType.TEXT,
    label: "备注",
    align: "left",
  },
];

export const API_NAME_SEARCH = "search";
export const API_NAME_SEARCH_RIGHT = "searchRight";
export const API_NAME_SEARCH_LEFT = "searchLeft";
export const API_NAME_CREATE = "create";
export const API_NAME_CREATE_BATCH = "createBatch";
export const API_NAME_UPDATE = "update";
export const API_NAME_UPDATE_BATCH = "updateBatch";
export const API_NAME_DELETE = "delete";
export const API_NAME_DELETE_BATCH = "deleteBatch";
