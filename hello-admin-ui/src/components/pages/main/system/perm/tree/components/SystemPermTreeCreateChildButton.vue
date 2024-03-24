<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedNodes: Record<string, never>[];
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-tag-plus",
    color: "positive",
  },
);

const { createRequestRef, createDialogIsOpenedRef } = useInjectedStateSystemPerms();
</script>

<template>
  <q-btn
    :color="color"
    :icon="icon"
    outline
    @click="
      () => {
        createDialogIsOpenedRef = true;
        if (selectedNodes.length) {
          createRequestRef.parentId = selectedNodes[0].id;
        }
      }
    "
  />
</template>
