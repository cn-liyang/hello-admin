<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedNodes: Record<string, never>[];
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-tag-remove",
    color: "negative",
  },
);

const { deleteTreesRequestRef, deleteTreesDialogIsOpenedRef } = useInjectedStateSystemPerms();
</script>

<template>
  <q-btn
    :color="color"
    :icon="icon"
    outline
    @click="
      () => {
        deleteTreesDialogIsOpenedRef = true;
        if (selectedNodes.length) {
          deleteTreesRequestRef.id = selectedNodes[0].id;
        }
      }
    "
  />
</template>
