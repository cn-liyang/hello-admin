import { ITableColumn } from "src/types/interfaces/quasar/table";

export const TABLE_COLUMNS_ROLE_MTM_PERM: ITableColumn[] = [TABLE_COLUMN_ROLE_ID, TABLE_COLUMN_PERM_ID];

export const TABLE_COLUMNS_ROLE_MTM_PERM_ENTITY: ITableColumn[] = [
  TABLE_COLUMN_ID,
  ...TABLE_COLUMNS_ROLE_MTM_PERM,
  ...TABLE_COLUMNS_BASE,
];
