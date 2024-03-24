import { ITableColumn } from "src/types/interfaces/quasar/table";
import { EValueType } from "src/types/enums/table";

export const TABLE_COLUMNS_PERM: ITableColumn[] = [
  {
    name: "parentId",
    field: "parentId",
    valueType: EValueType.NUMB,
    label: "父级主键",
    align: "left",
    required: true,
  },
  {
    name: "permType",
    field: "permType",
    valueType: EValueType.NUMB,
    label: "权限类型",
    align: "left",
    format: (val) => SELECT_OPTIONS_PERM_TYPE.find(({ value }) => val === value)?.label || "",
  },
  {
    name: "permSign",
    field: "permSign",
    valueType: EValueType.TEXT,
    label: "权限标志",
    align: "left",
  },
  {
    name: "name",
    field: "name",
    valueType: EValueType.TEXT,
    label: "名称",
    align: "left",
  },
  {
    name: "icon",
    field: "icon",
    valueType: EValueType.TEXT,
    label: "图标",
    align: "left",
  },
  {
    name: "label",
    field: "label",
    valueType: EValueType.TEXT,
    label: "标签",
    align: "left",
  },
  {
    name: "caption",
    field: "caption",
    valueType: EValueType.TEXT,
    label: "说明",
    align: "left",
  },
  {
    name: "sortBy",
    field: "sortBy",
    valueType: EValueType.NUMB,
    label: "序号",
    align: "left",
  },
];

export const TABLE_COLUMNS_PERM_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  ...TABLE_COLUMNS_PERM,
  ...TABLE_COLUMNS_BASE,
];

export const TABLE_COLUMN_PERM_ID: ITableColumn = {
  name: "permId",
  field: "permId",
  valueType: EValueType.NUMB,
  label: "权限主键",
  align: "left",
} as const;
