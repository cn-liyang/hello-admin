<script lang="ts" setup>
import { QTableColumn } from "quasar";

defineProps<{
  columns: QTableColumn[];
  apiPath: string;
}>();
const modelRef = defineModel<boolean>({ required: true });
const title = "系统权限表";
</script>

<template>
  <TableReadSearchSlot :api-path="apiPath" :columns="columns" :title="title">
    <template #table-top-row-first-left>
      <ButtonToggleTableTree v-model="modelRef" />
    </template>
    <template #table-top-row-last-left="props">
      <q-btn-group outline rounded>
        <SystemPermCreateButton />
        <SystemPermUpdateButton :disable="props.selectedRows.length !== 1" :selected-rows="props.selectedRows" />
        <SystemPermDeleteBatchButton :disable="!props.selectedRows.length" :selected-rows="props.selectedRows" />
      </q-btn-group>
    </template>
    <template #table-body-column-operation-dropdown="props">
      <SystemPermUpdateItem :selected-row="props.row" @set-selected-row="props.setSelectedRow()" />
      <SystemPermDeleteBatchItem :selected-key="props.key" @set-selected-row="props.setSelectedRow()" />
      <!--<SystemPermRelatePermOtmRoleItem @set-selected-row="props.setSelectedRow()" />-->
    </template>
    <template #card-bottom="props">
      <SystemPermCreateDialog @ok="props.doRefresh()" />
      <SystemPermUpdateDialog @ok="props.doRefresh()" />
      <SystemPermDeleteBatchDialog @ok="props.doRefresh()" />
      <!--<SystemPermRelatePermOtmRoleDialog  />-->
    </template>
  </TableReadSearchSlot>
</template>
