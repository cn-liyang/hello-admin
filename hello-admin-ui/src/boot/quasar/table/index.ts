const IS_ = "is_";

export function getCamelName(columnName: string) {
  const lowerCaseName = columnName.toLowerCase();
  const snakeCaseName = lowerCaseName.startsWith(IS_) ? lowerCaseName.substring(IS_.length) : lowerCaseName;
  return camelCase(snakeCaseName);
}
