<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedKey: number;
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-relation-one-to-zero-or-one",
    color: "primary",
  },
);
defineEmits<{
  setSelectedRow: [];
}>();
const { relateUserIdRef, relateUserInfoDialogIsOpenedRef } = useInjectedStateSystemUsers();
</script>

<template>
  <ItemIconLabelSlot
    :color="color"
    :icon="icon"
    label="信息"
    @click="
      () => {
        relateUserInfoDialogIsOpenedRef = true;
        relateUserIdRef = selectedKey;
        $emit('setSelectedRow');
      }
    "
  />
</template>
