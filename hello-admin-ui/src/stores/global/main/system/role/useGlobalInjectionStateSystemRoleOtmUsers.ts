import { IRoleOtmUserCreateRequest } from "src/types/interfaces/api/system/role/roleOtmUser";
import { InjectionError } from "src/types/classes/error/injection";

const _createRequest: IRoleOtmUserCreateRequest[] = [];
const [useProvidingStateSystemRoleOtmUsers, _useInjectedStateSystemRoleOtmUsers] = createInjectionState(() => {
  // createBatch
  const { createBatchRequestRef, createBatchDoExecute } = useAsyncStateWriteCreateBatch(
    API_PATH_SYSTEM_ROLE_OTM_USERS,
    _createRequest,
  );
  // deleteBatch
  const { deleteBatchRequestRef, deleteBatchDoExecute } = useAsyncStateWriteDeleteBatch(API_PATH_SYSTEM_ROLE_OTM_USERS);

  return {
    createBatchRequestRef,
    createBatchDoExecute,
    createBatchDialogIsOpenedRef: ref(false),
    deleteBatchRequestRef,
    deleteBatchDoExecute,
    deleteBatchDialogIsOpenedRef: ref(false),
  };
});

function useInjectedStateSystemRoleOtmUsers() {
  const injectedState = _useInjectedStateSystemRoleOtmUsers();
  if (!injectedState) {
    const injectionError = new InjectionError("useProvidingStateSystemRoleOtmUsers");
    qNotifyWarning(injectionError.message);
    throw injectionError;
  }
  return injectedState;
}

export { useProvidingStateSystemRoleOtmUsers, useInjectedStateSystemRoleOtmUsers };
