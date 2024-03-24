import { IUserInfoCreateRequest, IUserInfoUpdateRequest } from "src/types/interfaces/api/system/user/userInfo";
import { InjectionError } from "src/types/classes/error/injection";

const _createRequest: IUserInfoCreateRequest = {
  userId: 0,
  nickname: "",
  avatar: "",
  remark: "",
};
const _updateRequest: IUserInfoUpdateRequest = {
  id: 0,
  nickname: "",
  avatar: "",
  remark: "",
};
const [useProvidingStateSystemUserInfos, _useInjectedStateSystemUserInfos] = createInjectionState(() => {
  // create
  const { createRequestRef, createDoExecute } = useAsyncStateWriteCreate(API_PATH_SYSTEM_USER_INFOS, _createRequest);
  // update
  const { updateRequestRef, updateDoExecute } = useAsyncStateWriteUpdate(API_PATH_SYSTEM_USER_INFOS, _updateRequest);
  // deleteBatch
  const { deleteBatchRequestRef, deleteBatchDoExecute } = useAsyncStateWriteDeleteBatch(API_PATH_SYSTEM_USER_INFOS);

  return {
    createRequestRef,
    createDoExecute,
    createDialogIsOpenedRef: ref(false),
    updateRequestRef,
    updateDoExecute,
    updateDialogIsOpenedRef: ref(false),
    deleteBatchRequestRef,
    deleteBatchDoExecute,
    deleteBatchDialogIsOpenedRef: ref(false),
  };
});

function useInjectedStateSystemUserInfos() {
  const injectedState = _useInjectedStateSystemUserInfos();
  if (!injectedState) {
    const injectionError = new InjectionError("useProvidingStateSystemUserInfos");
    qNotifyWarning(injectionError.message);
    throw injectionError;
  }
  return injectedState;
}

export { useProvidingStateSystemUserInfos, useInjectedStateSystemUserInfos };
