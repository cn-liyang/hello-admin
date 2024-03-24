import { boot } from "quasar/wrappers";
import axios, { AxiosInstance } from "axios";

declare module "@vue/runtime-core" {
  interface ComponentCustomProperties {
    $AXIOS: AxiosInstance;
    $API: AxiosInstance;
  }
}

// Be careful when using SSR for cross-request state pollution
// due to creating a Singleton instance here;
// If any client changes this (global) instance, it might be a
// good idea to move this instance creation inside of the
// "export default () => {}" function below (which runs individually
// for each client)
const api = axios.create({
  baseURL: process.env.API_BASE_PATH,
  timeout: Number(process.env.API_BASE_TIMEOUT),
});
export default boot(({ app }) => {
  api.interceptors.request.use(interceptRequestOnFulfilled, interceptRequestOnRejected);
  api.interceptors.response.use(interceptResponseOnFulfilled, interceptResponseOnRejected);
  // for use inside Vue files (Options API) through this.$AXIOS and this.$API
  app.config.globalProperties.$AXIOS = axios;
  // ^ ^ ^ this will allow you to use this.$AXIOS (for Vue Options API form)
  //       so you won't necessarily have to import axios in each vue file
  app.config.globalProperties.$API = api;
  // ^ ^ ^ this will allow you to use this.$API (for Vue Options API form)
  //       so you can easily perform requests against your app's API
});

export { api };
