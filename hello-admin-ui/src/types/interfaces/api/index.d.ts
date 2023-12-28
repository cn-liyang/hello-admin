import { ERestMethod } from "src/types/enums/api";

export interface IRestApi {
  method: ERestMethod;
  url: string;
}
