<script lang="ts" setup>
withDefaults(
  defineProps<{
    label?: string;
    color?: string;
  }>(),
  {
    label: "Relation One To Zero Or One",
    color: "primary",
  },
);
const { relateUserIdRef, relateUserInfoDialogIsOpenedRef } = useInjectedStateSystemUsers();
</script>

<template>
  <DialogCardMaximizeSlot v-model="relateUserInfoDialogIsOpenedRef" :color="color" :label="label">
    <SystemUserInfo :user-id="relateUserIdRef" />
  </DialogCardMaximizeSlot>
</template>
