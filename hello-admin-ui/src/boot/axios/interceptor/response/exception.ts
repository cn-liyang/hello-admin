import { EExceptionCode } from "src/types/enums/api";

export function notifyException(code: string, message: string) {
  if (code.startsWith(EExceptionCode.ALERT)) {
    qNotifyWarning(message);
  }
  if (code.startsWith(EExceptionCode.ERROR)) {
    qNotifyNegative(message);
  }
}
