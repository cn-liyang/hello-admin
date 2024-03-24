<script lang="ts" setup>
defineProps<{
  userId: number;
}>();
const title = "账户关联角色表";
const apiPath = API_PATH_SYSTEM_USER_OTM_ROLES;
const columns = TABLE_COLUMNS_USER_OTM_ROLE_ENTITY;
useProvidingStateSystemUserOtmRoles();
</script>

<template>
  <TableReadSearchSlot
    :api-path="apiPath"
    :columns="columns"
    :filter-is-hidden="true"
    :search-id="userId"
    :title="title"
  >
    <template #table-top-row-last-left="props">
      <q-btn-group outline rounded>
        <SystemUserOtmRoleCreateBatchButton />
        <SystemUserOtmRoleDeleteBatchButton :disable="!props.selectedRows.length" :selected-rows="props.selectedRows" />
      </q-btn-group>
    </template>
    <template #table-body-column-operation-dropdown="props">
      <SystemUserOtmRoleDeleteBatchItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
    </template>
    <template #card-bottom="props">
      <SystemUserOtmRoleCreateBatchDialog :user-id="userId" @ok="props.doRefresh()" />
      <SystemUserOtmRoleDeleteBatchDialog @ok="props.doRefresh()" />
    </template>
  </TableReadSearchSlot>
</template>
