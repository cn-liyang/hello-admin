import { Notify } from "quasar";

export function qNotifyPositive(message: string) {
  return Notify.create({
    type: "positive",
    icon: "mdi-emoticon-happy",
    position: "top",
    progress: true,
    message,
  });
}

export function qNotifyNegative(message: string) {
  return Notify.create({
    type: "negative",
    icon: "mdi-emoticon-sad",
    position: "top",
    progress: true,
    message,
  });
}

export function qNotifyWarning(message: string) {
  return Notify.create({
    type: "warning",
    icon: "mdi-alert",
    position: "top",
    progress: true,
    message,
  });
}

export function qNotifyInfo(message: string) {
  return Notify.create({
    type: "info",
    icon: "mdi-message-processing",
    position: "top",
    progress: true,
    message,
  });
}
