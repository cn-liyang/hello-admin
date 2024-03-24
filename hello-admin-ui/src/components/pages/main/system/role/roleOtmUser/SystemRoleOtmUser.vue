<script lang="ts" setup>
defineProps<{
  roleId: number;
}>();
const title = "角色关联账户表";
const apiPath = API_PATH_SYSTEM_ROLE_OTM_USERS;
const columns = TABLE_COLUMNS_ROLE_OTM_USER_ENTITY;
useProvidingStateSystemRoleOtmUsers();
</script>

<template>
  <TableReadSearchSlot
    :api-path="apiPath"
    :columns="columns"
    :filter-is-hidden="true"
    :search-id="roleId"
    :title="title"
  >
    <template #table-top-row-last-left="props">
      <q-btn-group outline rounded>
        <SystemRoleOtmUserCreateBatchButton />
        <SystemRoleOtmUserDeleteBatchButton :disable="!props.selectedRows.length" :selected-rows="props.selectedRows" />
      </q-btn-group>
    </template>
    <template #table-body-column-operation-dropdown="props">
      <SystemRoleOtmUserDeleteBatchItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
    </template>
    <template #card-bottom="props">
      <SystemRoleOtmUserCreateBatchDialog :role-id="roleId" @ok="props.doRefresh()" />
      <SystemRoleOtmUserDeleteBatchDialog @ok="props.doRefresh()" />
    </template>
  </TableReadSearchSlot>
</template>
