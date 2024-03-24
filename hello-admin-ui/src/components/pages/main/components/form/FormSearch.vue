<script lang="ts" setup>
import { IFormSearch } from "src/types/interfaces/quasar/form";
import { EValueType } from "src/types/enums/table";

const { visibleFields } = defineProps<{
  visibleFields: string[];
  isAdvanced: boolean;
}>();
const modelRef = defineModel<IFormSearch[]>({ required: true });
</script>

<template>
  <div v-for="({ field, valueType }, index) in modelRef" v-show="visibleFields.includes(field)" :key="index">
    <FormSearchField v-if="EValueType.BOOL === valueType" v-model="modelRef[index]" :is-advanced="isAdvanced" />
    <FormSearchInput v-else v-model="modelRef[index]" :is-advanced="isAdvanced" />
  </div>
</template>
