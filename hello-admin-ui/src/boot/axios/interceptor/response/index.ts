import { AxiosError, AxiosResponse, HttpStatusCode } from "axios";
import { SessionStorage } from "quasar";
import { IBaseResponse } from "src/types/interfaces/api/base";

export function interceptResponseOnFulfilled(r: AxiosResponse) {
  qLoadingHide();
  // console.info("interceptors.response.onFulfilled", r);
  const {
    data,
    headers,
    config: { url },
  } = r;
  if (API_PATHS_WHITELIST.includes(url?.split("?")[0] || "")) {
    headers["authorization"] && SessionStorage.set(SESSION_STORAGE_KEY_TOKEN, headers["authorization"]);
  }
  return Promise.resolve(data);
}

export function interceptResponseOnRejected(e: AxiosError) {
  qLoadingHide();
  console.error("interceptors.response.onRejected", e);
  const { name, message, response } = e;
  if (response) {
    const {
      status,
      data: { code, message },
    } = <AxiosResponse<IBaseResponse<unknown>>>response;
    if (status === HttpStatusCode.BadRequest) {
      notifyException(code, message);
    }
    if (status === HttpStatusCode.Unauthorized) {
      qNotifyWarning(message);
    }
    if (status === HttpStatusCode.Forbidden) {
      SessionStorage.remove(SESSION_STORAGE_KEY_TOKEN);
      qNotifyNegative(message);
    }
  } else {
    qNotifyNegative(`${name}: ${message}`);
  }
  return Promise.reject(e);
}
