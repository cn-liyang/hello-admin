import { IRoleOtmPermEntity, IRoleOtmUserCreateRequest } from "src/types/interfaces/api/system/role/roleOtmPerm";

const _createRequest: IRoleOtmUserCreateRequest[] = [];
export default function (apiPath: string, roleId: number) {
  const { tickedKeysRef } = useAsyncStateTree();
  const { searchResponseRef, executeSearch } = useAsyncStateTreeSearchLeafs<IRoleOtmPermEntity>(apiPath, roleId);
  // createBatch
  const { createBatchRequestRef, createBatchDoExecute } = useAsyncStateWriteCreateBatch(
    API_PATH_SYSTEM_ROLE_OTM_PERMS,
    _createRequest,
  );
  // deleteBatch
  const { deleteBatchRequestRef, deleteBatchDoExecute } = useAsyncStateWriteDeleteBatch(API_PATH_SYSTEM_ROLE_OTM_PERMS);

  const disableComputedRef = computed(
    () =>
      getRef(searchResponseRef).every(({ permId }) => getRef(tickedKeysRef).includes(permId)) &&
      getRef(tickedKeysRef).every((i) =>
        getRef(searchResponseRef)
          .map(({ permId }) => permId)
          .includes(i),
      ),
  );

  function doSearch() {
    executeSearch().then((r) => {
      setRef(
        tickedKeysRef,
        r.map(({ permId }) => permId),
      );
    });
  }

  function doUpdate() {
    const deletedIds = getRef(searchResponseRef)
      .filter(({ permId }) => !getRef(tickedKeysRef).includes(permId))
      .map(({ id }) => id);
    if (deletedIds.length) {
      setRef(getRef(deleteBatchRequestRef), "ids", deletedIds);
      return deleteBatchDoExecute();
    }
    const createdRequests = getRef(tickedKeysRef)
      .filter(
        (i) =>
          !getRef(searchResponseRef)
            .map(({ permId }) => permId)
            .includes(i),
      )
      .map((i) => <IRoleOtmUserCreateRequest>{ roleId, permId: i });
    if (createdRequests.length) {
      setRef(createBatchRequestRef, createdRequests);
      return createBatchDoExecute();
    }
    return Promise.reject();
  }

  return {
    tickedKeysRef,
    disableComputedRef,
    doSearch,
    doUpdate,
  };
}
