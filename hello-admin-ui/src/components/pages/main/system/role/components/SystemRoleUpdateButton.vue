<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedRows: Record<string, never>[];
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-table-edit",
    color: "warning",
  },
);
const { updateRequestRef, updateDialogIsOpenedRef } = useInjectedStateSystemRoles();
</script>

<template>
  <q-btn
    :color="color"
    :icon="icon"
    outline
    @click="
      () => {
        updateDialogIsOpenedRef = true;
        if (selectedRows.length) {
          updateRequestRef.id = selectedRows[0].id;
          updateRequestRef.name = selectedRows[0].name;
          updateRequestRef.label = selectedRows[0].label;
          updateRequestRef.remark = selectedRows[0].remark;
        }
      }
    "
  />
</template>
