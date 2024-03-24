<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedRows: Record<string, never>[];
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-table-remove",
    color: "negative",
  },
);
const { deleteBatchRequestRef, deleteBatchDialogIsOpenedRef } = useInjectedStateSystemRoles();
</script>

<template>
  <q-btn
    :color="color"
    :icon="icon"
    outline
    @click="
      () => {
        deleteBatchDialogIsOpenedRef = true;
        if (selectedRows.length) {
          deleteBatchRequestRef.ids = selectedRows.map((i) => i.id);
        }
      }
    "
  />
</template>
