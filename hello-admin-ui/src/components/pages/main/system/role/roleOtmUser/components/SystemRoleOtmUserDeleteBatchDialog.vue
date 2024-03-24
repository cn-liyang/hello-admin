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
const { deleteBatchDoExecute, deleteBatchDialogIsOpenedRef } = useInjectedStateSystemRoleOtmUsers();
</script>

<template>
  <DialogCardOkCancelSlot
    v-model="deleteBatchDialogIsOpenedRef"
    :color="color"
    :label="label"
    @ok="
      deleteBatchDoExecute()
        .then(() => $emit('ok'))
        .then(() => (deleteBatchDialogIsOpenedRef = false))
    "
  >
    <div>Are you sure about this?</div>
  </DialogCardOkCancelSlot>
</template>
