<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedRow: Record<string, never>;
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-table-edit",
    color: "warning",
  },
);
defineEmits<{
  setSelectedRow: [];
}>();

const { updateRequestRef, updateDialogIsOpenedRef } = useInjectedStateSystemPerms();
</script>

<template>
  <ItemIconLabelSlot
    :color="color"
    :icon="icon"
    label="编辑"
    @click="
      () => {
        updateDialogIsOpenedRef = true;
        updateRequestRef.id = selectedRow.id;
        updateRequestRef.parentId = selectedRow.parentId;
        updateRequestRef.permType = selectedRow.permType;
        updateRequestRef.permSign = selectedRow.permSign;
        updateRequestRef.name = selectedRow.name;
        updateRequestRef.icon = selectedRow.icon;
        updateRequestRef.label = selectedRow.label;
        updateRequestRef.caption = selectedRow.caption;
        updateRequestRef.sortBy = selectedRow.sortBy;
        updateRequestRef.remark = selectedRow.remark;
        $emit('setSelectedRow');
      }
    "
  />
</template>
