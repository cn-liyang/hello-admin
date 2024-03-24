import { IRestApi } from "src/types/interfaces/api";
import { EHttpMethod } from "src/types/enums";

export const API_PATH_PATTERN_BATCH = "/batch";
export const API_PATH_PATTERN_CHILDREN = "/children";
export const API_PATH_PATTERN_LEAFS = "/leafs";
// entry
export const API_PATH_CAPTCHA = "/captcha";
export const API_PATH_LOGIN = "/login";
export const API_PATHS_WHITELIST = [API_PATH_CAPTCHA, API_PATH_LOGIN];

export const API_REST_CAPTCHA: IRestApi = {
  method: EHttpMethod.GET,
  url: API_PATH_CAPTCHA,
} as const;
export const API_REST_LOGIN: IRestApi = {
  method: EHttpMethod.POST,
  url: API_PATH_LOGIN,
} as const;
