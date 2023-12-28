export const REGEXP_LOGIN_USERNAME = {
  pattern: /^[A-Za-z]\w{4,19}$/,
  message: "字母（大小写）、数字、下划线，要求字母（大小写）开头，长度 5-20 位",
} as const;
export const REGEXP_LOGIN_PASSWORD = {
  pattern: /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)\w{8,20}$/,
  message: "字母（大小写）、数字、下划线，要求每种字符至少有一个，长度 8-20 位",
} as const;
