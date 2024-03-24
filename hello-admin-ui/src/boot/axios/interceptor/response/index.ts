import { AxiosError, AxiosResponse } from "axios";
import { SessionStorage } from "quasar";
import { IBaseResponse } from "src/types/interfaces/api/system/base";

export function interceptResponseOnFulfilled(r: AxiosResponse) {
  qLoadingHide();
  // console.info("interceptors.response.onFulfilled", r);
  const {
    data,
    headers,
    config: { url },
  } = r;
  if (API_PATHS_WHITELIST.includes(url?.split("?")[0] || "")) {
    headers["authorization"] && SessionStorage.set(SESSION_STORAGE_KEY_AUTHORIZATION, headers["authorization"]);
  }
  return Promise.resolve(data);
}

export function interceptResponseOnRejected(e: AxiosError) {
  qLoadingHide();
  console.error("interceptors.response.onRejected", e);
  const { name, message, response } = e;
  if (response) {
    notifyResponseException(<AxiosResponse<IBaseResponse<unknown>>>response);
  } else {
    qNotifyNegative(`${name}: ${message}`);
  }
  return Promise.reject(e);
}
