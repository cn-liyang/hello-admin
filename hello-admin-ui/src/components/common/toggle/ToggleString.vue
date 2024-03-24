<script lang="ts" setup>
const modelRef = defineModel<string>({ required: true });
</script>

<template>
  <q-toggle v-model="modelRef" :false-value="'false'" :true-value="'true'" dense />
</template>
