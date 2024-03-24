import {
  ApiMethodValidationError,
  ApiPathValidationError,
  ApiSignValidationError,
  ApiValidationError,
  ValidationError,
} from "src/types/classes/error/validation";
import { IMenuRapi } from "src/types/interfaces/api/system/perm";

export default function (name: string) {
  const {
    meta: { rapis },
  } = useRoute();
  const { notifyNegative } = useQNotify();
  const { start } = useTimeoutFn(
    () => {
      throw validationError;
    },
    1000,
    { immediate: false },
  );

  const rapiIsVerified = ref(true);

  const rapi = rapis?.find((i) => i.name === name);
  let validationError: ValidationError;
  if (!rapi) {
    setRef(rapiIsVerified, false);
    validationError = new ApiValidationError(`[${name}]`);
    notifyNegative(validationError.message);
    start();
  }
  const { permSign, icon, label, caption } = <IMenuRapi>rapi;
  if (!permSign.includes("#")) {
    setRef(rapiIsVerified, false);
    validationError = new ApiSignValidationError(`[${name}]`);
    notifyNegative(validationError.message);
    start();
  }
  const split = permSign.split("#");
  if (split.length !== 2) {
    setRef(rapiIsVerified, false);
    validationError = new ApiSignValidationError(`[${name}]`);
    notifyNegative(validationError.message);
    start();
  }
  if (!split[0] || !["post", "put", "patch", "delete"].includes(split[0].toLowerCase())) {
    setRef(rapiIsVerified, false);
    validationError = new ApiMethodValidationError(`[${permSign}]`);
    notifyNegative(validationError.message);
    start();
  }
  if (!split[1] || !split[1].startsWith("/")) {
    setRef(rapiIsVerified, false);
    validationError = new ApiPathValidationError(`[${permSign}]`);
    notifyNegative(validationError.message);
    start();
  }

  return {
    icon,
    label,
    caption,
    restApi: {
      method: split[0],
      url: split[1],
    },
    rapiIsVerified,
  };
}
