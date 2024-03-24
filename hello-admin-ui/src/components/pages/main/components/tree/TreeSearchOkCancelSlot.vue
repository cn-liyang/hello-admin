<script lang="ts" setup>
import { QTableColumn } from "quasar";

const { apiPath } = defineProps<{
  title: string;
  columns: QTableColumn[];
  apiPath: string;
  disable?: boolean;
}>();
const expandedKeysRef = defineModel<number[]>("expanded");
const tickedKeysRef = defineModel<number[]>("ticked");
defineEmits<{
  ok: [];
}>();
</script>

<template>
  <TreeSearchSlot
    v-model:expanded="expandedKeysRef"
    v-model:ticked="tickedKeysRef"
    :api-path="apiPath"
    :columns="columns"
    :title="title"
    tick-strategy="leaf"
  >
    <template #card-bottom>
      <q-separator />
      <CardActionsOkCancel :disable="disable" @ok="$emit('ok')" />
    </template>
  </TreeSearchSlot>
</template>
