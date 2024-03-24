<script lang="ts" setup>
defineProps<{
  label: string;
}>();
</script>

<template>
  <q-item v-close-popup clickable tag="label">
    <slot name="label-before" />
    <q-item-section>{{ label }}</q-item-section>
    <slot name="label-after" />
  </q-item>
</template>
