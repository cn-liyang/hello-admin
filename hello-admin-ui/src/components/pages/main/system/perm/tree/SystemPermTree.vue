<script lang="ts" setup>
import { QTableColumn } from "quasar";

defineProps<{
  columns: QTableColumn[];
  apiPath: string;
}>();
const modelRef = defineModel<boolean>({ required: true });
const title = "系统权限树";
</script>

<template>
  <TreeSearchSlot :api-path="apiPath" :columns="columns" :title="title">
    <template #card-top-row-first-left>
      <ButtonToggleTableTree v-model="modelRef" />
    </template>
    <template #card-top-row-last-left="props">
      <q-btn-group outline rounded>
        <SystemPermTreeCreateChildButton :disable="!props.selectedNodes.length" :selected-nodes="props.selectedNodes" />
        <SystemPermTreeUpdateButton :disable="!props.selectedNodes.length" :selected-nodes="props.selectedNodes" />
        <SystemPermTreeDeleteChildrenButton
          :disable="!props.selectedNodes.length"
          :selected-nodes="props.selectedNodes"
        />
      </q-btn-group>
    </template>
    <template #card-bottom="props">
      <SystemPermTreeCreateChildDialog @ok="props.doRefreshChildren()" />
      <SystemPermTreeUpdateDialog @ok="props.doRefreshParent()" />
      <SystemPermTreeDeleteChildrenDialog @ok="props.doRefreshParent()" />
    </template>
  </TreeSearchSlot>
</template>
