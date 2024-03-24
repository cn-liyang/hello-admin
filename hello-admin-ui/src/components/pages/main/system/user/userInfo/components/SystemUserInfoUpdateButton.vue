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
const { updateRequestRef, updateDialogIsOpenedRef } = useInjectedStateSystemUserInfos();
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
          updateRequestRef.nickname = selectedRows[0].nickname;
          updateRequestRef.avatar = selectedRows[0].avatar;
          updateRequestRef.remark = selectedRows[0].remark;
        }
      }
    "
  />
</template>
