<script lang="ts" setup>
import { QTableColumn } from "quasar";

const { apiPath, searchId } = withDefaults(
  defineProps<{
    title: string;
    columns: QTableColumn[];
    apiPath: string;
    searchId?: number;
    filterIsHidden?: boolean;
    disableDropdown?: boolean;
  }>(),
  {
    searchId: 0,
    filterIsHidden: false,
    disableDropdown: false,
  },
);
// search
const { paginationRef, searchResponseRef, searchIsLoadingRef, doRequest } = useAsyncStateReadSearch(apiPath, searchId);
</script>

<template>
  <TableReadSlot
    v-model:pagination="paginationRef"
    :columns="columns"
    :disable-dropdown="disableDropdown"
    :filter-is-hidden="filterIsHidden"
    :loading="searchIsLoadingRef"
    :rows="searchResponseRef"
    :title="title"
    @request="doRequest"
  >
    <template #table-top-row-first-left>
      <slot name="table-top-row-first-left" />
    </template>
    <template #table-top-row-last-left="props">
      <slot name="table-top-row-last-left" v-bind="{ ...props, rowsIsEmpty: searchResponseRef.length <= 0 }" />
    </template>
    <template #table-body-column-operation-dropdown="props">
      <slot name="table-body-column-operation-dropdown" v-bind="props" />
    </template>
    <template #card-bottom="props">
      <slot name="card-bottom" v-bind="props" />
    </template>
  </TableReadSlot>
</template>
