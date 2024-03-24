<script lang="ts" setup>
import { QTableColumn } from "quasar";

withDefaults(
  defineProps<{
    title: string;
    columns: QTableColumn[];
    apiPath: string;
    searchId?: number;
    filterIsHidden?: boolean;
  }>(),
  {
    searchId: 0,
    filterIsHidden: false,
  },
);
defineEmits<{
  ok: [v: Record<string, never>[]];
}>();
</script>

<template>
  <TableReadSearchSlot
    :api-path="apiPath"
    :columns="columns"
    :disable-dropdown="true"
    :filter-is-hidden="filterIsHidden"
    :search-id="searchId"
    :title="title"
  >
    <template #table-top-row-last-left="props">
      <slot name="table-top-row-last-left" v-bind="props" />
    </template>
    <template #table-body-column-operation-dropdown="props">
      <slot name="table-body-column-operation-dropdown" v-bind="props" />
    </template>
    <template #card-bottom="props">
      <q-separator />
      <CardActionsOkCancel :disable="!props.selectedRows.length" @ok="$emit('ok', props.selectedRows)" />
      <slot name="card-bottom" v-bind="props" />
    </template>
  </TableReadSearchSlot>
</template>
