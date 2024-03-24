import { IRestApi } from "src/types/interfaces/api";
import { IBaseResponse } from "src/types/interfaces/api/system/base";

export async function doRequest<O, I = undefined>(restApi: IRestApi, input?: I): Promise<O> {
  const output = <IBaseResponse<O>>await api.request({ ...restApi, data: input });
  return getResponseBodyData(output);
}
