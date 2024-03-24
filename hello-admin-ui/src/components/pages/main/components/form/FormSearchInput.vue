<script lang="ts" setup>
import { IFormSearch } from "src/types/interfaces/quasar/form";
import { EQueryOperator } from "src/types/enums/api/sql";
import { EValueType } from "src/types/enums/table";

defineProps<{
  isAdvanced: boolean;
}>();
const modelRef = defineModel<IFormSearch>({ required: true });

const queryOperatorsComputedRef = computed(() => {
  const { valueType } = getRef(modelRef);
  return getQueryOperators(valueType);
});
const placeholderComputedRef = computed(() => {
  const { operator } = getRef(modelRef);
  return getQueryOperatorPlaceholder(operator);
});
const hintComputedRef = computed(() => {
  const { field, operator, value } = getRef(modelRef);
  return getQueryOperatorHint(operator, field, value);
});
</script>

<template>
  <q-input
    v-model.trim="modelRef.value"
    :bottom-slots="isAdvanced"
    :placeholder="placeholderComputedRef"
    :readonly="EValueType.TIME === modelRef.valueType"
    debounce="1000"
    dense
    filled
  >
    <template #prepend>
      <div class="text-subtitle2 text-dark">
        {{ modelRef.label }}
      </div>
      <div v-show="isAdvanced" style="height: 40px; margin-left: 6px">
        <ButtonMenuQueryOperator v-model="modelRef.operator" :query-operators="queryOperatorsComputedRef" />
      </div>
    </template>
    <template #append>
      <IconDate
        v-if="EValueType.TIME === modelRef.valueType"
        v-model.trim="modelRef.value"
        :is-ranged="[EQueryOperator.BETWEEN, EQueryOperator.NOT_BETWEEN].includes(modelRef.operator)"
      />
    </template>
    <template #hint>
      {{ hintComputedRef }}
    </template>
  </q-input>
</template>
