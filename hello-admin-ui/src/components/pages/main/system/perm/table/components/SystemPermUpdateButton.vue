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

const { updateRequestRef, updateDialogIsOpenedRef } = useInjectedStateSystemPerms();
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
          updateRequestRef.parentId = selectedRows[0].parentId;
          updateRequestRef.permType = selectedRows[0].permType;
          updateRequestRef.permSign = selectedRows[0].permSign;
          updateRequestRef.name = selectedRows[0].name;
          updateRequestRef.icon = selectedRows[0].icon;
          updateRequestRef.label = selectedRows[0].label;
          updateRequestRef.caption = selectedRows[0].caption;
          updateRequestRef.sortBy = selectedRows[0].sortBy;
          updateRequestRef.remark = selectedRows[0].remark;
        }
      }
    "
  />
</template>
