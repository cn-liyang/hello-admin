import { IRestApi } from "src/types/interfaces/api";
import { IBaseResponse } from "src/types/interfaces/api/base";
import { EResponseCode } from "src/types/enums/api";

export async function asyncRequest<O, I = undefined>(config: IRestApi, input?: I) {
  const { code, message, data } = <IBaseResponse<O>>await api.request({ ...config, data: input });
  if (code === EResponseCode.SUCCESS) {
    return Promise.resolve(<O>data);
  } else {
    qNotifyWarning(`${code}: ${message}`);
    return Promise.reject();
  }
}
