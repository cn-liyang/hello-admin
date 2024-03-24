<script lang="ts" setup>
withDefaults(
  defineProps<{
    label?: string;
    color?: string;
  }>(),
  {
    label: "Relation One To Zero Or Many",
    color: "secondary",
  },
);
const { relateRoleIdRef, relateRoleOtmPermDialogIsOpenedRef } = useInjectedStateSystemRoles();
</script>

<template>
  <DialogCardMaximizeSlot v-model="relateRoleOtmPermDialogIsOpenedRef" :color="color" :label="label">
    <SystemRoleOtmPerm :role-id="relateRoleIdRef" />
  </DialogCardMaximizeSlot>
</template>
