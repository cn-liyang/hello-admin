<script lang="ts" setup>
withDefaults(
  defineProps<{
    selectedNodes: Record<string, never>[];
    icon?: string;
    color?: string;
  }>(),
  {
    icon: "mdi-tag-edit",
    color: "warning",
  },
);

const { updateRequestRef, updateDialogIsOpenedRef } = useInjectedStateSystemPerms();
</script>

<template>
  <q-btn
    :color="color"
    :icon="icon"
    outline
    @click="
      () => {
        updateDialogIsOpenedRef = true;
        if (selectedNodes.length) {
          updateRequestRef.id = selectedNodes[0].id;
          updateRequestRef.parentId = selectedNodes[0].parentId;
          updateRequestRef.permType = selectedNodes[0].permType;
          updateRequestRef.permSign = selectedNodes[0].permSign;
          updateRequestRef.name = selectedNodes[0].name;
          updateRequestRef.icon = selectedNodes[0].icon;
          updateRequestRef.label = selectedNodes[0].label;
          updateRequestRef.caption = selectedNodes[0].caption;
          updateRequestRef.sortBy = selectedNodes[0].sortBy;
          updateRequestRef.remark = selectedNodes[0].remark;
        }
      }
    "
  />
</template>
