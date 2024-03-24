import { IIdRequest } from "src/types/interfaces/api/system/base";
import { EHttpMethod } from "src/types/enums";

const _deleteRequest: IIdRequest = {
  id: 0,
};
export default function (apiPath: string) {
  const { notifyNegative } = useQNotify();

  const { requestRef, responseRef, isReadyRef, isLoadingRef, doExecute } = useAsyncStateWrite(
    {
      method: EHttpMethod.DELETE,
      url: apiPath + API_PATH_PATTERN_CHILDREN,
    },
    _deleteRequest,
  );

  function deleteTreesDoExecute() {
    if (!getRef(requestRef).id) {
      const message = `Please check input arguments(empty) of the ${EHttpMethod.DELETE}#${
        apiPath + API_PATH_PATTERN_CHILDREN
      } api`;
      notifyNegative(message);
      return Promise.reject(message);
    }
    return doExecute();
  }

  return {
    deleteTreesRequestRef: requestRef,
    deleteTreesResponseRef: responseRef,
    deleteTreesIsReadyRef: isReadyRef,
    deleteTreesIsLoadingRef: isLoadingRef,
    deleteTreesDoExecute,
  };
}
