<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedKey: number;
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-relation-one-to-zero-or-many",
    color: "secondary",
  },
);
defineEmits<{
  setSelectedRow: [];
}>();
const { relateRoleIdRef, relateRoleOtmPermDialogIsOpenedRef } = useInjectedStateSystemRoles();
</script>

<template>
  <ItemIconLabelSlot
    :color="color"
    :icon="icon"
    label="权限"
    @click="
      () => {
        relateRoleOtmPermDialogIsOpenedRef = true;
        relateRoleIdRef = selectedKey;
        $emit('setSelectedRow');
      }
    "
  />
</template>
