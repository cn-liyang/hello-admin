<script lang="ts" setup>
import { QTableColumn } from "quasar";
import { ITableOnRequestParameters, ITablePagination } from "src/types/interfaces/quasar/table";

const { columns, filterIsHidden } = withDefaults(
  defineProps<{
    title: string;
    columns: QTableColumn[];
    rows: Record<string, never>[];
    loading: boolean;
    filterIsHidden?: boolean;
    disableDropdown?: boolean;
  }>(),
  {
    filterIsHidden: false,
    disableDropdown: false,
  },
);
defineEmits<{
  request: [v: ITableOnRequestParameters];
}>();
const paginationRef = defineModel<ITablePagination>("pagination");
// filterIsHidden
const filterIsHiddenRef = ref(filterIsHidden);
// filterIsAdvanced
const filterIsAdvancedRef = ref(false);
// read
const { inputsRef, filterSelectOptions, filterVisibleFieldsRef, filterComputedRef } = useAsyncStateRead(columns);
</script>

<template>
  <CardTableRowDetailSlot
    v-model:pagination="paginationRef"
    :columns="columns"
    :disable-dropdown="disableDropdown"
    :filter="filterComputedRef"
    :loading="loading"
    :rows="rows"
    :title="title"
    @request="(v) => $emit('request', v)"
  >
    <template #table-top-row-first-left>
      <slot name="table-top-row-first-left" />
    </template>
    <template #table-top-row-first-right>
      <ButtonToggleFilterHidden v-model="filterIsHiddenRef" />
    </template>
    <template #table-top-row>
      <q-separator v-show="!filterIsHiddenRef" spaced />
      <div v-show="!filterIsHiddenRef" class="row items-center">
        <div class="column full-width">
          <div class="row items-center">
            <ButtonToggleFilterAdvanced v-model="filterIsAdvancedRef" />
            <q-space />
            <ButtonCancelFilter @click="() => inputsRef.forEach((i) => (i.value = ''))" />
            <SelectMultiple
              v-model="filterVisibleFieldsRef"
              :display-value="$q.lang.label.filter"
              :options="filterSelectOptions"
            />
          </div>
          <q-separator class="bg-transparent" inset spaced />
          <div class="row q-gutter-sm">
            <FormSearch
              v-model="inputsRef"
              :is-advanced="filterIsAdvancedRef"
              :visible-fields="filterVisibleFieldsRef"
            />
          </div>
        </div>
      </div>
    </template>
    <template #table-top-row-last-left="props">
      <slot name="table-top-row-last-left" v-bind="props" />
    </template>
    <template #table-body-column-operation-dropdown="props">
      <slot name="table-body-column-operation-dropdown" v-bind="props" />
    </template>
    <template #card-bottom="props">
      <slot name="card-bottom" v-bind="props" />
    </template>
  </CardTableRowDetailSlot>
</template>
