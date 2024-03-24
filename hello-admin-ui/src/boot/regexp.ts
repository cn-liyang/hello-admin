import { boot } from "quasar/wrappers";

const REGEXP_NUMBER = {
  pattern: /^\d+$/,
  message: "数字",
} as const;
const REGEXP_LOGIN_USERNAME = {
  pattern: /^[A-Za-z]\w{4,19}$/,
  message: "字母（大小写）、数字、下划线，要求字母（大小写）开头，长度 5-20 位",
} as const;
const REGEXP_LOGIN_PASSWORD = {
  pattern: /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)\w{8,20}$/,
  message: "字母（大小写）、数字、下划线，要求每种字符至少有一个，长度 8-20 位",
} as const;

declare module "@vue/runtime-core" {
  interface ComponentCustomProperties {
    $REGEXP_NUMBER: typeof REGEXP_NUMBER;
    $REGEXP_LOGIN_USERNAME: typeof REGEXP_LOGIN_USERNAME;
    $REGEXP_LOGIN_PASSWORD: typeof REGEXP_LOGIN_PASSWORD;
  }
}
export default boot(({ app }) => {
  app.config.globalProperties.$REGEXP_NUMBER = REGEXP_NUMBER;
  app.config.globalProperties.$REGEXP_LOGIN_USERNAME = REGEXP_LOGIN_USERNAME;
  app.config.globalProperties.$REGEXP_LOGIN_PASSWORD = REGEXP_LOGIN_PASSWORD;
});

export { REGEXP_NUMBER, REGEXP_LOGIN_PASSWORD, VALIDATION_RULE_STRING_TRUTHY };
