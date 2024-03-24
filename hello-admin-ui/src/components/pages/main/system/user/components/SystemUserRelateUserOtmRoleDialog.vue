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
const { relateUserIdRef, relateUserOtmRoleDialogIsOpenedRef } = useInjectedStateSystemUsers();
</script>

<template>
  <DialogCardMaximizeSlot v-model="relateUserOtmRoleDialogIsOpenedRef" :color="color" :label="label">
    <SystemUserOtmRole :user-id="relateUserIdRef" />
  </DialogCardMaximizeSlot>
</template>
