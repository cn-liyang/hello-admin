import { AxiosResponse, HttpStatusCode } from "axios";
import { IBaseResponse } from "src/types/interfaces/api/system/base";
import { SessionStorage } from "quasar";
import { EExceptionCode } from "src/types/enums/api";

export function notifyResponseException({ status, data: { code, message } }: AxiosResponse<IBaseResponse<unknown>>) {
  if (HttpStatusCode.BadRequest === status) {
    if (code.startsWith(EExceptionCode.ALERT)) {
      qNotifyWarning(message);
    }
    if (code.startsWith(EExceptionCode.ERROR)) {
      qNotifyNegative(message);
    }
  }
  if (HttpStatusCode.Unauthorized === status) {
    qNotifyWarning(message);
  }
  if (HttpStatusCode.Forbidden === status) {
    SessionStorage.remove(SESSION_STORAGE_KEY_AUTHORIZATION);
    qNotifyNegative(message);
  }
}
