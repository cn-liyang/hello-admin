<script lang="ts" setup>
defineProps<{
  label: string;
}>();
const modelRef = defineModel<string>({ required: true });
</script>

<template>
  <InputSlot v-model.trim="modelRef">
    <template #prepend>
      <div class="text-subtitle2 text-dark">
        {{ label }}
      </div>
    </template>
  </InputSlot>
</template>
