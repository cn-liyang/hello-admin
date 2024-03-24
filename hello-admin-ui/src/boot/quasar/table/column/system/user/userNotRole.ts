import { ITableColumn } from "src/types/interfaces/quasar/table";

export const TABLE_COLUMNS_USER_NOT_ROLE_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  TABLE_COLUMNS_ROLE_NAME,
  TABLE_COLUMNS_ROLE_LABEL,
  ...TABLE_COLUMNS_BASE,
];
