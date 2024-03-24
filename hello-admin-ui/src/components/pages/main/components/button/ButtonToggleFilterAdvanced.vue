<script lang="ts" setup>
const modelRef = defineModel<boolean>({ required: true });
</script>

<template>
  <q-btn
    :icon="modelRef ? 'mdi-magnify-minus-outline' : 'mdi-magnify-plus-outline'"
    flat
    round
    @click="modelRef = !modelRef"
  />
</template>
