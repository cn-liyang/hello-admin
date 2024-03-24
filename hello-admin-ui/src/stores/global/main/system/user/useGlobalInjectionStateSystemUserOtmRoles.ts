import { IUserOtmRoleCreateRequest } from "src/types/interfaces/api/system/user/userOtmRole";
import { InjectionError } from "src/types/classes/error/injection";

const _createRequest: IUserOtmRoleCreateRequest[] = [];
const [useProvidingStateSystemUserOtmRoles, _useInjectedStateSystemUserOtmRoles] = createInjectionState(() => {
  // createBatch
  const { createBatchRequestRef, createBatchDoExecute } = useAsyncStateWriteCreateBatch(
    API_PATH_SYSTEM_USER_OTM_ROLES,
    _createRequest,
  );
  // deleteBatch
  const { deleteBatchRequestRef, deleteBatchDoExecute } = useAsyncStateWriteDeleteBatch(API_PATH_SYSTEM_USER_OTM_ROLES);

  return {
    createBatchRequestRef,
    createBatchDoExecute,
    createBatchDialogIsOpenedRef: ref(false),
    deleteBatchRequestRef,
    deleteBatchDoExecute,
    deleteBatchDialogIsOpenedRef: ref(false),
  };
});

function useInjectedStateSystemUserOtmRoles() {
  const injectedState = _useInjectedStateSystemUserOtmRoles();
  if (!injectedState) {
    const injectionError = new InjectionError("useProvidingStateSystemUserOtmRoles");
    qNotifyWarning(injectionError.message);
    throw injectionError;
  }
  return injectedState;
}

export { useProvidingStateSystemUserOtmRoles, useInjectedStateSystemUserOtmRoles };
