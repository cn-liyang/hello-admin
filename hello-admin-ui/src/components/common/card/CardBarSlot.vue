<script lang="ts" setup>
defineProps<{
  label: string;
  color: string;
}>();
</script>

<template>
  <q-card>
    <q-bar :class="`bg-${color}`">
      <div class="text-capitalize">{{ label }}</div>
      <q-space />
      <slot name="bar-right" />
      <q-btn v-close-popup dense flat icon="mdi-window-close" round />
    </q-bar>
    <q-card-section>
      <slot />
    </q-card-section>
    <slot name="card-bottom" />
  </q-card>
</template>
