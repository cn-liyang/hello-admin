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
const { relateUserIdRef, relateUserOtmRoleDialogIsOpenedRef } = useInjectedStateSystemUsers();
</script>

<template>
  <ItemIconLabelSlot
    :color="color"
    :icon="icon"
    label="角色"
    @click="
      () => {
        relateUserOtmRoleDialogIsOpenedRef = true;
        relateUserIdRef = selectedKey;
        $emit('setSelectedRow');
      }
    "
  />
</template>
