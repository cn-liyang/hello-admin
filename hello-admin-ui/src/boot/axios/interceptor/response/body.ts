import { IBaseResponse } from "src/types/interfaces/api/system/base";
import { EResponseCode } from "src/types/enums/api";

export function getResponseBodyData<O>({ code, message, data }: IBaseResponse<O>): Promise<O> {
  return new Promise((resolve, reject) => {
    if (EResponseCode.SUCCESS === code) {
      return resolve(<O>data);
    } else {
      qNotifyWarning(`${code}: ${message}`);
      return reject();
    }
  });
}
