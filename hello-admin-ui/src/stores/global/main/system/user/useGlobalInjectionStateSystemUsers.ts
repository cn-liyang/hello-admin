import { IUserCreateRequest, IUserUpdateRequest } from "src/types/interfaces/api/system/user";
import { InjectionError } from "src/types/classes/error/injection";

const _createRequest: IUserCreateRequest = {
  username: "",
  password: "",
  expiredAccount: false,
  expiredPassword: false,
  locked: false,
  enabled: true,
  remark: "",
};
const _updateRequest: IUserUpdateRequest = {
  id: 0,
  username: "",
  password: "",
  expiredAccount: false,
  expiredPassword: false,
  locked: false,
  enabled: true,
  remark: "",
};
const [useProvidingStateSystemUsers, _useInjectedStateSystemUsers] = createInjectionState(() => {
  // create
  const { createRequestRef, createDoExecute } = useAsyncStateWriteCreate(API_PATH_SYSTEM_USERS, _createRequest);
  // update
  const { updateRequestRef, updateDoExecute } = useAsyncStateWriteUpdate(API_PATH_SYSTEM_USERS, _updateRequest);
  // deleteBatch
  const { deleteBatchRequestRef, deleteBatchDoExecute } = useAsyncStateWriteDeleteBatch(API_PATH_SYSTEM_USERS);

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
    relateUserIdRef: ref(0),
    relateUserInfoDialogIsOpenedRef: ref(false),
    relateUserOtmRoleDialogIsOpenedRef: ref(false),
  };
});

function useInjectedStateSystemUsers() {
  const injectedState = _useInjectedStateSystemUsers();
  if (!injectedState) {
    const injectionError = new InjectionError("useProvidingStateSystemUsers");
    qNotifyWarning(injectionError.message);
    throw injectionError;
  }
  return injectedState;
}

export { useProvidingStateSystemUsers, useInjectedStateSystemUsers };
