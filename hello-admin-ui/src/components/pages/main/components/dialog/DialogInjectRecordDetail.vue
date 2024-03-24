<script lang="ts" setup>
import { QTableColumn } from "quasar";
import { ITriple } from "src/types/interfaces";

const { columns } = defineProps<{
  injectKey: symbol;
  columns?: QTableColumn[];
}>();

function getTriples(record?: Record<string, never>) {
  if (record) {
    if (columns) {
      return columns.map(
        ({ field, label, format }) =>
          <ITriple<string, string, never>>{
            left: field,
            middle: label,
            right: format ? format(record[<string>field], record) : record[<string>field],
          },
      );
    } else {
      return Object.entries(record).map(
        ([field, value]) =>
          <ITriple<string, string, never>>{
            left: field,
            middle: field,
            right: value,
          },
      );
    }
  } else {
    return [];
  }
}
</script>

<template>
  <DialogMaximizeInjectRecordSlot :inject-key="injectKey" :persistent="false" color="info" label="Detail">
    <template #default="props">
      <MarkupTableTriples :triples="getTriples(props.record)" />
    </template>
  </DialogMaximizeInjectRecordSlot>
</template>
