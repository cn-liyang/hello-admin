import { Loading } from "quasar";

export function qLoadingShow(message?: string) {
  Loading.show({
    delay: 500,
    spinnerSize: 50,
    message,
  });
}

export function qLoadingHide() {
  Loading.hide();
}
