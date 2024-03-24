import { ITableColumn } from "src/types/interfaces/quasar/table";

export const TABLE_COLUMNS_USER_OTM_ROLE_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  ...TABLE_COLUMNS_USER_MTM_ROLE,
  TABLE_COLUMNS_ROLE_NAME,
  TABLE_COLUMNS_ROLE_LABEL,
  ...TABLE_COLUMNS_BASE,
];
