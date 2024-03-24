const CANCEL = {
  label: "取消",
  flat: true,
  dense: true,
  color: "secondary",
} as const;
const OK = {
  label: "确认",
  flat: true,
  dense: true,
  color: "primary",
} as const;

export default function () {
  const $q = useQuasar();

  function dialogAlert(message: string, onOk: () => void) {
    return $q
      .dialog({
        class: "bg-red-1",
        title: "警告：",
        message,
        cancel: CANCEL,
        ok: OK,
      })
      .onOk(onOk);
  }

  return { dialogAlert };
}
