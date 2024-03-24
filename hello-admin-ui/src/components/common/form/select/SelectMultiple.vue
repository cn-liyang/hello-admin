<script lang="ts" setup>
const modelRef = defineModel<string[]>({ required: true });
</script>

<template>
  <q-select v-model="modelRef" dense emit-value map-options multiple options-cover options-dense outlined />
</template>
