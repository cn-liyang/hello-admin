<script lang="ts" setup>
import { ValidationRule } from "quasar";

defineProps<{
  icon: string;
  rules?: ValidationRule[];
}>();
const modelRef = defineModel<string>({ required: true });
</script>

<template>
  <InputSlot v-model.trim="modelRef" :rules="[$VALIDATION_RULE_STRING_TRUTHY, ...(rules || [])]">
    <template #prepend>
      <q-icon :name="icon" />
    </template>
    <template #append>
      <slot />
    </template>
  </InputSlot>
</template>
