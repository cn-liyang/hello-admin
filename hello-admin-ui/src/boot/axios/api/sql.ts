import { EValueType } from "src/types/enums/table";
import { EQueryOperator } from "src/types/enums/api/sql";

export function getQueryOperators(valueType: EValueType) {
  if (EValueType.NUMB === valueType) {
    return [
      EQueryOperator.EQUALS,
      EQueryOperator.NOT_EQUALS,
      EQueryOperator.IN,
      EQueryOperator.NOT_IN,
      EQueryOperator.GT,
      EQueryOperator.GE,
      EQueryOperator.LT,
      EQueryOperator.LE,
      EQueryOperator.BETWEEN,
      EQueryOperator.NOT_BETWEEN,
    ];
  }
  if (EValueType.TEXT === valueType) {
    return [
      EQueryOperator.EQUALS,
      EQueryOperator.NOT_EQUALS,
      EQueryOperator.LIKE,
      EQueryOperator.NOT_LIKE,
      EQueryOperator.IN,
      EQueryOperator.NOT_IN,
    ];
  }
  if (EValueType.TIME === valueType) {
    return [
      EQueryOperator.GT,
      EQueryOperator.GE,
      EQueryOperator.LT,
      EQueryOperator.LE,
      EQueryOperator.BETWEEN,
      EQueryOperator.NOT_BETWEEN,
    ];
  }
  return [];
}

export function getQueryOperatorPlaceholder(operator: EQueryOperator) {
  if ([EQueryOperator.LIKE, EQueryOperator.NOT_LIKE].includes(operator)) {
    return "[%]value%";
  }
  if ([EQueryOperator.IN, EQueryOperator.NOT_IN].includes(operator)) {
    return "value1, value2, ...";
  }
  if ([EQueryOperator.BETWEEN, EQueryOperator.NOT_BETWEEN].includes(operator)) {
    return "value1 ~ value2";
  }
  return "";
}

export function getQueryOperatorHint(operator: EQueryOperator, field: string, value: string) {
  const prefix = field + " " + operator + " ";
  if ([EQueryOperator.LIKE, EQueryOperator.NOT_LIKE].includes(operator)) {
    if (value) {
      return prefix + `${value}`;
    } else {
      return prefix + "[%]value%";
    }
  }
  if ([EQueryOperator.IN, EQueryOperator.NOT_IN].includes(operator)) {
    if (value) {
      return prefix + `(${value})`;
    } else {
      return prefix + "(value1, value2, ...)";
    }
  }
  if ([EQueryOperator.BETWEEN, EQueryOperator.NOT_BETWEEN].includes(operator)) {
    if (value?.includes("~")) {
      const splitTrims = (<string>value).split("~").map((i) => i.trim());
      return prefix + `${splitTrims[0]} AND ${splitTrims[1]}`;
    } else {
      return prefix + "value1 AND value2";
    }
  }
  if (value) {
    return prefix + value;
  } else {
    return prefix + "value";
  }
}
