import { IRestApi } from "src/types/interfaces/api";
import { ERestMethod } from "src/types/enums/api";

export const API_REST_CAPTCHA: IRestApi = {
  method: ERestMethod.GET,
  url: API_PATH_CAPTCHA,
} as const;
export const API_REST_LOGIN: IRestApi = {
  method: ERestMethod.POST,
  url: API_PATH_LOGIN,
} as const;
