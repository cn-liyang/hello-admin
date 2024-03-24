<script lang="ts" setup>
withDefaults(
  defineProps<{
    roleId: number;
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
  useInjectedStateSystemRoleOtmUsers();
</script>

<template>
  <DialogCardMaximizeSlot v-model="createBatchDialogIsOpenedRef" :color="color" :label="label">
    <SystemRoleNotUser
      :role-id="roleId"
      @ok="
        (v) => {
          createBatchRequestRef = v.map((i) => ({ roleId, userId: i.id }));
          createBatchDoExecute()
            .then(() => $emit('ok'))
            .then(() => (createBatchDialogIsOpenedRef = false));
        }
      "
    />
  </DialogCardMaximizeSlot>
</template>
