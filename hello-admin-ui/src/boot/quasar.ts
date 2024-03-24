import { boot } from "quasar/wrappers";
import { ValidationRule } from "quasar";

const DATE_FORMAT = "YYYY-MM-DD";
const DATETIME_FORMAT = "YYYY-MM-DD HH:mm:ss";
const VALIDATION_RULE_STRING_TRUTHY: ValidationRule = (v: string) => !!v || "文本输入不能为空，请检查！";

declare module "@vue/runtime-core" {
  interface ComponentCustomProperties {
    $DATE_FORMAT: typeof DATE_FORMAT;
    $DATETIME_FORMAT: typeof DATETIME_FORMAT;
    $VALIDATION_RULE_STRING_TRUTHY: typeof VALIDATION_RULE_STRING_TRUTHY;
    $SELECT_OPTIONS_PERM_TYPE: typeof SELECT_OPTIONS_PERM_TYPE;
  }
}
export default boot(({ app }) => {
  app.config.globalProperties.$DATE_FORMAT = DATE_FORMAT;
  app.config.globalProperties.$DATETIME_FORMAT = DATETIME_FORMAT;
  app.config.globalProperties.$VALIDATION_RULE_STRING_TRUTHY = VALIDATION_RULE_STRING_TRUTHY;
  app.config.globalProperties.$SELECT_OPTIONS_PERM_TYPE = SELECT_OPTIONS_PERM_TYPE;
});

export { DATE_FORMAT, DATETIME_FORMAT };
