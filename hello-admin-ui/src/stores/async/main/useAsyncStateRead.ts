import { ITableColumn } from "src/types/interfaces/quasar/table";
import { IFormSearch } from "src/types/interfaces/quasar/form";
import { EValueType } from "src/types/enums/table";
import { EQueryOperator } from "src/types/enums/api/sql";
import { ISearchCondition } from "src/types/interfaces/api/page";
import { QSelectOption } from "quasar";

export default function (columns: ITableColumn[]) {
  const inputColumns = columns.filter(({ ignored }) => !ignored);
  const inputsRef = ref<IFormSearch[]>(
    inputColumns.map(
      ({ field, label, valueType }) =>
        <IFormSearch>{
          field,
          label,
          value: "",
          valueType,
          operator: EValueType.TIME === valueType ? EQueryOperator.BETWEEN : EQueryOperator.EQUALS,
        },
    ),
  );
  const filterSelectOptions = inputColumns
    .filter(({ required }) => !required)
    .map(
      ({ field, label }) =>
        <QSelectOption>{
          label,
          value: <string>field,
        },
    );
  const filterVisibleFieldsRef = ref<string[]>(
    inputColumns.filter(({ required }) => !!required).map(({ field }) => <string>field),
  );
  const filterComputedRef = computed(() =>
    getRef(inputsRef)
      .filter(({ value }) => !!value)
      .map(
        ({ field, value, valueType, operator }) =>
          <ISearchCondition>{
            field,
            value,
            valueType,
            operator,
          },
      ),
  );

  return {
    inputsRef,
    filterSelectOptions,
    filterVisibleFieldsRef,
    filterComputedRef,
  };
}
