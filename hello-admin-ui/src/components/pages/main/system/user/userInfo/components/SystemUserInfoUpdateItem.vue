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
const { updateRequestRef, updateDialogIsOpenedRef } = useInjectedStateSystemUserInfos();
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
        updateRequestRef.nickname = selectedRow.nickname;
        updateRequestRef.avatar = selectedRow.avatar;
        updateRequestRef.remark = selectedRow.remark;
        $emit('setSelectedRow');
      }
    "
  />
</template>
