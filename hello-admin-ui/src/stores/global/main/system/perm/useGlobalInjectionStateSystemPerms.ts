import { IPermCreateRequest, IPermUpdateRequest } from "src/types/interfaces/api/system/perm";
import { EPermType } from "src/types/enums/api/system";
import { InjectionError } from "src/types/classes/error/injection";

const _createRequest: IPermCreateRequest = {
  parentId: 0,
  permType: EPermType.CATA,
  permSign: "",
  name: "",
  icon: "",
  label: "",
  caption: "",
  sortBy: 0,
  remark: "",
};
const _updateRequest: IPermUpdateRequest = {
  id: 0,
  parentId: 0,
  permType: EPermType.CATA,
  permSign: "",
  name: "",
  icon: "",
  label: "",
  caption: "",
  sortBy: 0,
  remark: "",
};
const [useProvidingStateSystemPerms, _useInjectedStateSystemPerms] = createInjectionState(() => {
  // create
  const { createRequestRef, createDoExecute } = useAsyncStateWriteCreate(API_PATH_SYSTEM_PERMS, _createRequest);
  // update
  const { updateRequestRef, updateDoExecute } = useAsyncStateWriteUpdate(API_PATH_SYSTEM_PERMS, _updateRequest);
  // deleteBatch
  const { deleteBatchRequestRef, deleteBatchDoExecute } = useAsyncStateWriteDeleteBatch(API_PATH_SYSTEM_PERMS);
  // deleteTrees
  const { deleteTreesRequestRef, deleteTreesDoExecute } = useAsyncStateWriteDeleteChildren(API_PATH_SYSTEM_PERMS);

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
    deleteTreesRequestRef,
    deleteTreesDoExecute,
    deleteTreesDialogIsOpenedRef: ref(false),
    relatePermOtmRoleDialogIsOpenedRef: ref(false),
  };
});

function useInjectedStateSystemPerms() {
  const injectedState = _useInjectedStateSystemPerms();
  if (!injectedState) {
    const injectionError = new InjectionError("useProvidingStateSystemPerms");
    qNotifyWarning(injectionError.message);
    throw injectionError;
  }
  return injectedState;
}

export { useProvidingStateSystemPerms, useInjectedStateSystemPerms };
