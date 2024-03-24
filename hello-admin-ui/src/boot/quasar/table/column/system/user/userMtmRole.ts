import { ITableColumn } from "src/types/interfaces/quasar/table";

export const TABLE_COLUMNS_USER_MTM_ROLE: ITableColumn[] = [TABLE_COLUMN_USER_ID, TABLE_COLUMN_ROLE_ID];

export const TABLE_COLUMNS_USER_MTM_ROLE_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  ...TABLE_COLUMNS_USER_MTM_ROLE,
  ...TABLE_COLUMNS_BASE,
];
