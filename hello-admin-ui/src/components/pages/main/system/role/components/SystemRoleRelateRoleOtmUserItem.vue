<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedKey: number;
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-relation-one-to-zero-or-many",
    color: "primary",
  },
);
defineEmits<{
  setSelectedRow: [];
}>();
const { relateRoleIdRef, relateRoleOtmUserDialogIsOpenedRef } = useInjectedStateSystemRoles();
</script>

<template>
  <ItemIconLabelSlot
    :color="color"
    :icon="icon"
    label="账户"
    @click="
      () => {
        relateRoleOtmUserDialogIsOpenedRef = true;
        relateRoleIdRef = selectedKey;
        $emit('setSelectedRow');
      }
    "
  />
</template>
