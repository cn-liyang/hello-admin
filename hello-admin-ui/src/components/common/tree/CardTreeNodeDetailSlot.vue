<script lang="ts" setup>
import { QTableColumn, QTreeLazyLoadParams } from "quasar";

defineProps<{
  title?: string;
  columns?: QTableColumn[];
  tickStrategy?: string;
  loading?: boolean;
}>();
defineEmits<{
  lazyLoad: [v: QTreeLazyLoadParams];
}>();
const expandedKeysRef = defineModel<number[]>("expanded");
const tickedKeysRef = defineModel<number[]>("ticked");

const selectedNodeRef = ref<Record<string, never>>();
// provideLocal
const selectedNodeProvideKey = Symbol();
provideLocal(selectedNodeProvideKey, selectedNodeRef);
// detailDialog
const detailDialogIsOpenedRef = ref(false);
</script>

<template>
  <CardTreeSlot
    v-model:expanded="expandedKeysRef"
    v-model:ticked="tickedKeysRef"
    :loading="loading"
    :tick-strategy="tickStrategy"
    :title="title"
    @lazy-load="(v) => $emit('lazyLoad', v)"
  >
    <template #card-top-row-first-left>
      <slot name="card-top-row-first-left" />
    </template>
    <template #card-top-row="props">
      <div class="row items-center">
        <slot name="card-top-row-last-left" v-bind="props" />
        <q-space />
        <slot name="card-top-row-last-right" v-bind="props" />
      </div>
    </template>
    <template #tree-header-operation="props">
      <ButtonNodeDetail
        @click="
          () => {
            detailDialogIsOpenedRef = true;
            selectedNodeRef = props.node;
            props.setSelectedNodes();
          }
        "
      />
    </template>
    <template #card-bottom="props">
      <slot name="card-bottom" v-bind="props" />
      <DialogInjectRecordDetail
        v-model="detailDialogIsOpenedRef"
        :columns="columns"
        :inject-key="selectedNodeProvideKey"
      />
    </template>
  </CardTreeSlot>
</template>
