<script lang="ts" setup>
const modelRef = defineModel<boolean>({ required: true });
</script>

<template>
  <q-btn :icon="modelRef ? 'mdi-table' : 'mdi-file-tree'" color="secondary" flat round @click="modelRef = !modelRef" />
</template>
