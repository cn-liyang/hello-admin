export default function () {
  const $q = useQuasar();

  function loadingShow(message?: string) {
    $q.loading.show({
      delay: 500,
      spinnerSize: 50,
      message,
    });
  }

  function loadingHide() {
    $q.loading.hide();
  }

  return { loadingShow, loadingHide };
}
