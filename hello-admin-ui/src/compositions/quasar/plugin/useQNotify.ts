export default function () {
  const $q = useQuasar();

  function notifyPositive(message: string) {
    return $q.notify({
      type: "positive",
      icon: "mdi-emoticon-happy",
      position: "top",
      progress: true,
      message,
    });
  }

  function notifyNegative(message: string) {
    return $q.notify({
      type: "negative",
      icon: "mdi-emoticon-sad",
      position: "top",
      progress: true,
      message,
    });
  }

  function notifyWarning(message: string) {
    return $q.notify({
      type: "warning",
      icon: "mdi-alert",
      position: "top",
      progress: true,
      message,
    });
  }

  function notifyInfo(message: string) {
    return $q.notify({
      type: "info",
      icon: "mdi-message-processing",
      position: "top",
      progress: true,
      message,
    });
  }

  return { notifyPositive, notifyNegative, notifyWarning, notifyInfo };
}
