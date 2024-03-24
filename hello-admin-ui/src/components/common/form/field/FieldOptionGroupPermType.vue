<script lang="ts" setup>
import { EPermType } from "src/types/enums/api/system";

defineProps<{
  label: string;
}>();

const modelRef = defineModel<EPermType>({ required: true });
</script>

<template>
  <FieldSlot>
    <template #prepend>
      <div class="text-subtitle2 text-dark">
        {{ label }}
      </div>
    </template>
    <template #append>
      <OptionGroupPermType v-model="modelRef" style="font-size: 0.875rem" />
    </template>
  </FieldSlot>
</template>
