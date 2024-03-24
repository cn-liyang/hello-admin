<script lang="ts" setup>
withDefaults(
  defineProps<{
    label?: string;
    color?: string;
  }>(),
  {
    label: "Delete",
    color: "negative",
  },
);
defineEmits<{
  ok: [];
}>();
const { deleteTreesDoExecute, deleteTreesDialogIsOpenedRef } = useInjectedStateSystemPerms();
</script>

<template>
  <DialogCardOkCancelSlot
    v-model="deleteTreesDialogIsOpenedRef"
    :color="color"
    :label="label"
    @ok="
      deleteTreesDoExecute()
        .then(() => $emit('ok'))
        .then(() => (deleteTreesDialogIsOpenedRef = false))
    "
  >
    <div>Are you sure about this?</div>
  </DialogCardOkCancelSlot>
</template>
