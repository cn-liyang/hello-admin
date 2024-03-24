<script lang="ts" setup>
withDefaults(
  defineProps<{
    userId: number;
    label?: string;
    color?: string;
  }>(),
  {
    label: "Create",
    color: "positive",
  },
);
defineEmits<{
  ok: [];
}>();
const { createBatchRequestRef, createBatchDoExecute, createBatchDialogIsOpenedRef } =
  useInjectedStateSystemUserOtmRoles();
</script>

<template>
  <DialogCardMaximizeSlot v-model="createBatchDialogIsOpenedRef" :color="color" :label="label">
    <SystemUserNotRole
      :user-id="userId"
      @ok="
        (v) => {
          createBatchRequestRef = v.map((i) => ({ userId, roleId: i.id }));
          createBatchDoExecute()
            .then(() => $emit('ok'))
            .then(() => (createBatchDialogIsOpenedRef = false));
        }
      "
    />
  </DialogCardMaximizeSlot>
</template>
