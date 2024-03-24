<script lang="ts" setup>
withDefaults(
  defineProps<{
    userId: number;
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-table-plus",
    color: "positive",
  },
);
const { createRequestRef, createDialogIsOpenedRef } = useInjectedStateSystemUserInfos();
</script>

<template>
  <q-btn
    :color="color"
    :icon="icon"
    outline
    @click="
      () => {
        createDialogIsOpenedRef = true;
        createRequestRef.userId = userId;
      }
    "
  />
</template>
