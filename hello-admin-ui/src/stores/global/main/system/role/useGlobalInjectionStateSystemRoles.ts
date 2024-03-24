import { IRoleCreateRequest, IRoleUpdateRequest } from "src/types/interfaces/api/system/role";
import { InjectionError } from "src/types/classes/error/injection";

const _createRequest: IRoleCreateRequest = {
  name: "",
  label: "",
  remark: "",
};
const _updateRequest: IRoleUpdateRequest = {
  id: 0,
  name: "",
  label: "",
  remark: "",
};
const [useProvidingStateSystemRoles, _useInjectedStateSystemRoles] = createInjectionState(() => {
  // create
  const { createRequestRef, createDoExecute } = useAsyncStateWriteCreate(API_PATH_SYSTEM_ROLES, _createRequest);
  // update
  const { updateRequestRef, updateDoExecute } = useAsyncStateWriteUpdate(API_PATH_SYSTEM_ROLES, _updateRequest);
  // deleteBatch
  const { deleteBatchRequestRef, deleteBatchDoExecute } = useAsyncStateWriteDeleteBatch(API_PATH_SYSTEM_ROLES);

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
    relateRoleIdRef: ref(0),
    relateRoleOtmUserDialogIsOpenedRef: ref(false),
    relateRoleOtmPermDialogIsOpenedRef: ref(false),
  };
});

function useInjectedStateSystemRoles() {
  const injectedState = _useInjectedStateSystemRoles();
  if (!injectedState) {
    const injectionError = new InjectionError("useProvidingStateSystemRoles");
    qNotifyWarning(injectionError.message);
    throw injectionError;
  }
  return injectedState;
}

export { useProvidingStateSystemRoles, useInjectedStateSystemRoles };
