import { EHttpMethod } from "src/types/enums";

export default function <T extends object>(apiPath: string, request: T) {
  const { requestRef, responseRef, isReadyRef, isLoadingRef, doExecute } = useAsyncStateWrite(
    {
      method: EHttpMethod.PUT,
      url: apiPath,
    },
    request,
  );

  return {
    createRequestRef: requestRef,
    createResponseRef: responseRef,
    createIsReadyRef: isReadyRef,
    createIsLoadingRef: isLoadingRef,
    createDoExecute: doExecute,
  };
}
