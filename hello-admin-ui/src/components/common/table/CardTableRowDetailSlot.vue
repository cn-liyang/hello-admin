<script lang="ts" setup>
import { QTableColumn } from "quasar";
import { ISearchCondition } from "src/types/interfaces/api/page";
import { ITableOnRequestParameters, ITablePagination } from "src/types/interfaces/quasar/table";

defineProps<{
  title?: string;
  columns?: QTableColumn[];
  rows?: Record<string, never>[];
  filter?: ISearchCondition[];
  loading?: boolean;
  disableDropdown?: boolean;
}>();
defineEmits<{
  request: [v: ITableOnRequestParameters];
}>();
const paginationRef = defineModel<ITablePagination>("pagination");
const selectedRowRef = ref<Record<string, never>>();
// provideLocal
const selectedRowProvideKey = Symbol();
provideLocal(selectedRowProvideKey, selectedRowRef);
// detailDialog
const detailDialogIsOpenedRef = ref(false);
</script>

<template>
  <CardTableSlot
    v-model:pagination="paginationRef"
    :columns="columns"
    :filter="filter"
    :loading="loading"
    :rows="rows"
    :title="title"
    @request="(v) => $emit('request', v)"
  >
    <template #table-top-row-first-left>
      <slot name="table-top-row-first-left" />
    </template>
    <template #table-top-row-first-right>
      <slot name="table-top-row-first-right" />
    </template>
    <template #table-top-row="props">
      <slot name="table-top-row" v-bind="props" />
    </template>
    <template #table-top-row-last-left="props">
      <slot name="table-top-row-last-left" v-bind="props" />
    </template>
    <template #table-body-column-operation="props">
      <ButtonDropdownRowDetail
        :disable-dropdown="disableDropdown"
        @click="
          () => {
            detailDialogIsOpenedRef = true;
            selectedRowRef = props.row;
            props.setSelectedRow();
          }
        "
      >
        <slot name="table-body-column-operation-dropdown" v-bind="props" />
      </ButtonDropdownRowDetail>
    </template>
    <template #card-bottom="props">
      <slot name="card-bottom" v-bind="props" />
      <DialogInjectRecordDetail
        v-model="detailDialogIsOpenedRef"
        :columns="columns"
        :inject-key="selectedRowProvideKey"
      />
    </template>
  </CardTableSlot>
</template>
