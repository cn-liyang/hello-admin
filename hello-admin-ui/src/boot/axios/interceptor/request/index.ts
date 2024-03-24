import { AxiosError, InternalAxiosRequestConfig } from "axios";
import { SessionStorage } from "quasar";

export function interceptRequestOnFulfilled(c: InternalAxiosRequestConfig) {
  qLoadingShow();
  // console.info("interceptors.request.onFulfilled", c);
  const { url, headers } = c;
  if (!API_PATHS_WHITELIST.includes(url?.split("?")[0] || "")) {
    headers["Authorization"] = <string>SessionStorage.getItem(SESSION_STORAGE_KEY_AUTHORIZATION);
  }
  return c;
}

export function interceptRequestOnRejected(e: AxiosError) {
  qLoadingHide();
  console.error("interceptors.request.onRejected", e);
  const { name, message } = e;
  qNotifyNegative(`${name}: ${message}`);
  return Promise.reject(e);
}
