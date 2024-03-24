<script lang="ts" setup>
const title = "系统角色表";
const apiPath = API_PATH_SYSTEM_ROLES;
const columns = TABLE_COLUMNS_ROLE_ENTITY;
useProvidingStateSystemRoles();
</script>

<template>
  <TableReadSearchSlot :api-path="apiPath" :columns="columns" :title="title">
    <template #table-top-row-last-left="props">
      <q-btn-group outline rounded>
        <SystemRoleCreateButton />
        <SystemRoleUpdateButton :disable="props.selectedRows.length !== 1" :selected-rows="props.selectedRows" />
        <SystemRoleDeleteBatchButton :disable="!props.selectedRows.length" :selected-rows="props.selectedRows" />
      </q-btn-group>
    </template>
    <template #table-body-column-operation-dropdown="props">
      <SystemRoleUpdateItem :selected-row="props.row" @set-selected-row="props.setSelectedRow()" />
      <SystemRoleDeleteBatchItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
      <SystemRoleRelateRoleOtmUserItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
      <SystemRoleRelateRoleOtmPermItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
    </template>
    <template #card-bottom="props">
      <SystemRoleCreateDialog @ok="props.doRefresh()" />
      <SystemRoleUpdateDialog @ok="props.doRefresh()" />
      <SystemRoleDeleteBatchDialog @ok="props.doRefresh()" />
      <SystemRoleRelateRoleOtmUserDialog />
      <SystemRoleRelateRoleOtmPermDialog />
    </template>
  </TableReadSearchSlot>
</template>
