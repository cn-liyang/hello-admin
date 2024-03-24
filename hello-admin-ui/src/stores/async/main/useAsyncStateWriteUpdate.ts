import { EHttpMethod } from "src/types/enums";

export default function <T extends object>(apiPath: string, request: T) {
  const { requestRef, responseRef, isReadyRef, isLoadingRef, doExecute } = useAsyncStateWrite(
    {
      method: EHttpMethod.PATCH,
      url: apiPath,
    },
    request,
  );

  return {
    updateRequestRef: requestRef,
    updateResponseRef: responseRef,
    updateIsReadyRef: isReadyRef,
    updateIsLoadingRef: isLoadingRef,
    updateDoExecute: doExecute,
  };
}
