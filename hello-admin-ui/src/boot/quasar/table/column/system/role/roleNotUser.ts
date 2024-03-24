import { ITableColumn } from "src/types/interfaces/quasar/table";

export const TABLE_COLUMNS_ROLE_NOT_USER_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  TABLE_COLUMN_USER_USERNAME,
  ...TABLE_COLUMNS_BASE,
];
