import { ITableColumn } from "src/types/interfaces/quasar/table";

export const TABLE_COLUMNS_ROLE_OTM_USER_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  ...TABLE_COLUMNS_USER_MTM_ROLE,
  TABLE_COLUMN_USER_USERNAME,
  ...TABLE_COLUMNS_BASE,
];
