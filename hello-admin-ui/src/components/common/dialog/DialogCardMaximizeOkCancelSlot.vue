<script lang="ts" setup>
defineProps<{
  label: string;
  color: string;
}>();
defineEmits<{
  ok: [];
}>();
</script>

<template>
  <DialogCardMaximizeSlot :color="color" :label="label">
    <slot />
    <template #card-bottom>
      <q-separator />
      <CardActionsOkCancel @ok="$emit('ok')" />
    </template>
  </DialogCardMaximizeSlot>
</template>
