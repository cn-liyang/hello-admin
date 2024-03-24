<script lang="ts" setup>
const { injectKey } = defineProps<{
  injectKey: symbol;
  label: string;
  color: string;
}>();
// injectLocal
const recordRef = injectLocal<Record<string, never>>(injectKey);
</script>

<template>
  <DialogCardMaximizeSlot :color="color" :label="label">
    <slot v-bind="{ record: recordRef }" />
  </DialogCardMaximizeSlot>
</template>
