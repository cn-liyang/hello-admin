import { EHttpMethod } from "src/types/enums";

export default function <T extends object[]>(apiPath: string, request: T) {
  const { requestRef, responseRef, isReadyRef, isLoadingRef, doExecute } = useAsyncStateWrite(
    {
      method: EHttpMethod.PUT,
      url: apiPath + API_PATH_PATTERN_BATCH,
    },
    request,
  );

  return {
    createBatchRequestRef: requestRef,
    createBatchResponseRef: responseRef,
    createBatchIsReadyRef: isReadyRef,
    createBatchIsLoadingRef: isLoadingRef,
    createBatchDoExecute: doExecute,
  };
}
