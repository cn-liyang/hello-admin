<script lang="ts" setup>
defineProps<{
  userId: number;
}>();
const title = "系统账户信息表";
const apiPath = API_PATH_SYSTEM_USER_INFOS;
const columns = TABLE_COLUMNS_USER_INFO_ENTITY;
useProvidingStateSystemUserInfos();
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
        <SystemUserInfoCreateButton :disable="!props.rowsIsEmpty" :user-id="userId" />
        <SystemUserInfoUpdateButton :disable="props.selectedRows.length !== 1" :selected-rows="props.selectedRows" />
        <SystemUserInfoDeleteBatchButton :disable="!props.selectedRows.length" :selected-rows="props.selectedRows" />
      </q-btn-group>
    </template>
    <template #table-body-column-operation-dropdown="props">
      <SystemUserInfoUpdateItem :selected-row="props.row" @set-selected-row="props.setSelectedRow()" />
      <SystemUserInfoDeleteBatchItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
    </template>
    <template #card-bottom="props">
      <SystemUserInfoCreateDialog @ok="props.doRefresh()" />
      <SystemUserInfoUpdateDialog @ok="props.doRefresh()" />
      <SystemUserInfoDeleteBatchDialog @ok="props.doRefresh()" />
    </template>
  </TableReadSearchSlot>
</template>
