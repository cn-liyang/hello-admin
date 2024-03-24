<script lang="ts" setup>
withDefaults(
  defineProps<{
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-table-plus",
    color: "positive",
  },
);
const { createDialogIsOpenedRef } = useInjectedStateSystemRoles();
</script>

<template>
  <q-btn :color="color" :icon="icon" outline @click="createDialogIsOpenedRef = true" />
</template>
