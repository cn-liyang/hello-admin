<script setup lang="ts">
defineProps<{
  icon: string;
  label: string;
}>();
</script>

<template>
  <q-item v-close-popup tag="label">
    <q-item-section>{{ label }}</q-item-section>
    <q-item-section avatar>
      <q-avatar :icon="icon" />
    </q-item-section>
  </q-item>
</template>

<style lang="scss" scoped>
:deep(.q-item__section--side) {
  padding: 0;
}

:deep(.q-item__section--avatar) {
  min-width: 0;
}
</style>
