<script lang="ts" setup>
import { EQueryOperator } from "src/types/enums/api/sql";

defineProps<{
  queryOperators: EQueryOperator[];
}>();
const modelRef = defineModel<EQueryOperator>({ required: true });
</script>

<template>
  <q-btn :label="modelRef" color="secondary" dense flat style="min-width: 1em">
    <TooltipTopMiddle caption="Select Operator" />
    <q-menu>
      <ListSlot separator>
        <ItemLabelSlot v-for="i in queryOperators" :key="i" :label="i" @click="modelRef = i" />
      </ListSlot>
    </q-menu>
  </q-btn>
</template>
