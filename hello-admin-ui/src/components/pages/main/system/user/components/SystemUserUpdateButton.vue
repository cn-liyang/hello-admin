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
const { updateRequestRef, updateDialogIsOpenedRef } = useInjectedStateSystemUsers();
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
          updateRequestRef.username = selectedRows[0].username;
          updateRequestRef.password = selectedRows[0].password;
          updateRequestRef.expiredAccount = selectedRows[0].expiredAccount;
          updateRequestRef.expiredPassword = selectedRows[0].expiredPassword;
          updateRequestRef.locked = selectedRows[0].locked;
          updateRequestRef.enabled = selectedRows[0].enabled;
          updateRequestRef.remark = selectedRows[0].remark;
        }
      }
    "
  />
</template>
