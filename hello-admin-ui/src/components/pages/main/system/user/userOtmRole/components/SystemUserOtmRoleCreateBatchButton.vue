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
const { createBatchDialogIsOpenedRef } = useInjectedStateSystemUserOtmRoles();
</script>

<template>
  <q-btn :color="color" :icon="icon" outline @click="createBatchDialogIsOpenedRef = true" />
</template>
