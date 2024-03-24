<script lang="ts" setup>
const title = "系统账户表";
const apiPath = API_PATH_SYSTEM_USERS;
const columns = TABLE_COLUMNS_USER_ENTITY;
useProvidingStateSystemUsers();
</script>

<template>
  <TableReadSearchSlot :api-path="apiPath" :columns="columns" :title="title">
    <template #table-top-row-last-left="props">
      <q-btn-group outline rounded>
        <SystemUserCreateButton />
        <SystemUserUpdateButton :disable="props.selectedRows.length !== 1" :selected-rows="props.selectedRows" />
        <SystemUserDeleteBatchButton :disable="!props.selectedRows.length" :selected-rows="props.selectedRows" />
      </q-btn-group>
    </template>
    <template #table-body-column-operation-dropdown="props">
      <SystemUserUpdateItem :selected-row="props.row" @set-selected-row="props.setSelectedRow()" />
      <SystemUserDeleteBatchItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
      <SystemUserRelateUserInfoItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
      <SystemUserRelateUserOtmRoleItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
    </template>
    <template #card-bottom="props">
      <SystemUserCreateDialog @ok="props.doRefresh()" />
      <SystemUserUpdateDialog @ok="props.doRefresh()" />
      <SystemUserDeleteBatchDialog @ok="props.doRefresh()" />
      <SystemUserRelateUserInfoDialog />
      <SystemUserRelateUserOtmRoleDialog />
    </template>
  </TableReadSearchSlot>
</template>
