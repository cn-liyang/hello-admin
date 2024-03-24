<script lang="ts" setup>
defineProps<{
  label: string;
  color: string;
  disable?: boolean;
}>();
defineEmits<{
  ok: [];
}>();
</script>

<template>
  <DialogCardMaximizeSlot :color="color" :label="label">
    <router-view />
    <template #card-bottom>
      <q-separator />
      <CardActionsOkCancel :disable="disable" @ok="$emit('ok')" />
    </template>
  </DialogCardMaximizeSlot>
</template>
