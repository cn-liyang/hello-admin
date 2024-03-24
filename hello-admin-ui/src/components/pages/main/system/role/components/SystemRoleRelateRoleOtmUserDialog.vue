<script lang="ts" setup>
withDefaults(
  defineProps<{
    label?: string;
    color?: string;
  }>(),
  {
    label: "Relation One To Zero Or Many",
    color: "primary",
  },
);
const { relateRoleIdRef, relateRoleOtmUserDialogIsOpenedRef } = useInjectedStateSystemRoles();
</script>

<template>
  <DialogCardMaximizeSlot v-model="relateRoleOtmUserDialogIsOpenedRef" :color="color" :label="label">
    <SystemRoleOtmUser :role-id="relateRoleIdRef" />
  </DialogCardMaximizeSlot>
</template>
