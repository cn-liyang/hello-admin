<script lang="ts" setup>
const modelRef = defineModel<string | number>({ required: true });
</script>

<template>
  <q-input v-model.trim="modelRef" dense filled>
    <template #prepend>
      <slot name="prepend" />
    </template>
    <template #append>
      <slot name="append" />
    </template>
  </q-input>
</template>
