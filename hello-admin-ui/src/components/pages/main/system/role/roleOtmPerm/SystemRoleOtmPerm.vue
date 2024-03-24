<script lang="ts" setup>
const { roleId } = defineProps<{
  roleId: number;
}>();
const title = "角色关联权限树";
const apiPath = API_PATH_SYSTEM_ROLE_OTM_PERMS;
const columns = TABLE_COLUMNS_ROLE_OTM_PERM_ENTITY;
// api
const { relateRoleOtmPermDialogIsOpenedRef } = useInjectedStateSystemRoles();
const { tickedKeysRef, disableComputedRef, doSearch, doUpdate } = useAsyncStateSystemRoleOtmPerms(apiPath, roleId);
tryOnMounted(() => doSearch());
</script>

<template>
  <TreeSearchOkCancelSlot
    v-model:ticked="tickedKeysRef"
    :api-path="apiPath"
    :columns="columns"
    :default-expand-all="true"
    :disable="disableComputedRef"
    :title="title"
    tick-strategy="leaf"
    @ok="doUpdate().then(() => (relateRoleOtmPermDialogIsOpenedRef = false))"
  />
</template>
