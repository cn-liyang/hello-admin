<script lang="ts" setup>
import { QTableColumn } from "quasar";

const { apiPath } = defineProps<{
  title: string;
  columns: QTableColumn[];
  apiPath: string;
  tickStrategy?: string;
}>();
const expandedKeysRef = defineModel<number[]>("expanded");
const tickedKeysRef = defineModel<number[]>("ticked");
// api
const { searchIsLoadingRef, doLazyLoad } = useAsyncStateTreeSearchChildren(apiPath);
</script>

<template>
  <CardTreeNodeDetailSlot
    v-model:expanded="expandedKeysRef"
    v-model:ticked="tickedKeysRef"
    :columns="columns"
    :loading="searchIsLoadingRef"
    :tick-strategy="tickStrategy"
    :title="title"
    @lazy-load="doLazyLoad"
  >
    <template #card-top-row-first-left>
      <slot name="card-top-row-first-left" />
    </template>
    <template #card-top-row-last-left="props">
      <slot name="card-top-row-last-left" v-bind="props" />
    </template>
    <template #card-bottom="props">
      <slot name="card-bottom" v-bind="props" />
    </template>
  </CardTreeNodeDetailSlot>
</template>
