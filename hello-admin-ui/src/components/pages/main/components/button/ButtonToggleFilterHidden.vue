<script lang="ts" setup>
const modelRef = defineModel<boolean>({ required: true });
</script>

<template>
  <q-btn :icon="modelRef ? 'mdi-filter' : 'mdi-filter-off'" flat round @click="modelRef = !modelRef" />
</template>
