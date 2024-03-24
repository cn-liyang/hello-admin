<script lang="ts" setup>
defineProps<{
  label: string;
  color: string;
}>();
</script>

<template>
  <DialogCardMaximizeSlot :color="color" :label="label">
    <router-view />
  </DialogCardMaximizeSlot>
</template>
