<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedKey: number;
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-table-remove",
    color: "negative",
  },
);
defineEmits<{
  setSelectedRow: [];
}>();
const { deleteBatchRequestRef, deleteBatchDialogIsOpenedRef } = useInjectedStateSystemUserOtmRoles();
</script>

<template>
  <ItemIconLabelSlot
    :color="color"
    :icon="icon"
    label="删除"
    @click="
      () => {
        deleteBatchDialogIsOpenedRef = true;
        deleteBatchRequestRef.ids = [selectedKey];
        $emit('setSelectedRow');
      }
    "
  />
</template>
