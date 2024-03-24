import { IIdsRequest } from "src/types/interfaces/api/system/base";
import { EHttpMethod } from "src/types/enums";

const _deleteRequest: IIdsRequest = {
  ids: [],
};
export default function (apiPath: string) {
  const { notifyNegative } = useQNotify();

  const { requestRef, responseRef, isReadyRef, isLoadingRef, doExecute } = useAsyncStateWrite(
    {
      method: EHttpMethod.DELETE,
      url: apiPath + API_PATH_PATTERN_BATCH,
    },
    _deleteRequest,
  );

  /* function deleteBatchDoExecute() {
    if (!getRef(requestRef).ids.length) {
      const message = `Please check input arguments(empty) of the ${EHttpMethod.DELETE}#${
        apiPath + API_PATH_PATTERN_BATCH
      } api`;
      notifyNegative(message);
      return Promise.reject(message);
    }
    return doExecute();
  } */

  return {
    deleteBatchRequestRef: requestRef,
    deleteBatchResponseRef: responseRef,
    deleteBatchIsReadyRef: isReadyRef,
    deleteBatchIsLoadingRef: isLoadingRef,
    deleteBatchDoExecute: doExecute,
  };
}
