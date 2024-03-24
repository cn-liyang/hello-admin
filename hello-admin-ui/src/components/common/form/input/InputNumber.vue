<script lang="ts" setup>
import { ValidationRule } from "quasar";

defineProps<{
  label: string;
}>();

const modelRef = defineModel<number>({ required: true });
</script>

<template>
  <InputSlot
    v-model.trim.number="modelRef"
    :rules="[<ValidationRule>((v) => $REGEXP_NUMBER.pattern.test(v) || `请输入${$REGEXP_NUMBER.message}`)]"
  >
    <template #prepend>
      <div class="text-subtitle2 text-dark">
        {{ label }}
      </div>
    </template>
  </InputSlot>
</template>
