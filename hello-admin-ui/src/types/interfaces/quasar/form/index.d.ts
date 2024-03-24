import { EValueType } from "src/types/enums/table";
import { EQueryOperator } from "src/types/enums/api/sql";

export interface IFormSearch {
  field: string;
  label: string;
  value: string;
  valueType: EValueType;
  operator: EQueryOperator;
}
