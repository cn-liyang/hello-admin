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
const { updateRequestRef, updateDialogIsOpenedRef } = useInjectedStateSystemUsers();
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
        updateRequestRef.username = selectedRow.username;
        updateRequestRef.password = selectedRow.password;
        updateRequestRef.expiredAccount = selectedRow.expiredAccount;
        updateRequestRef.expiredPassword = selectedRow.expiredPassword;
        updateRequestRef.locked = selectedRow.locked;
        updateRequestRef.enabled = selectedRow.enabled;
        updateRequestRef.remark = selectedRow.remark;
        $emit('setSelectedRow');
      }
    "
  />
</template>
