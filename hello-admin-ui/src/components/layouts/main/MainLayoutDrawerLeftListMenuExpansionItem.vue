<script lang="ts" setup>
import { IMenuTree } from "src/types/interfaces/api/system/perm";
import { EPermType } from "src/types/enums/api/system";

defineProps<{
  menu: IMenuTree;
}>();
</script>

<template>
  <q-expansion-item
    :caption="menu.caption"
    :hide-expand-icon="EPermType.VIEW === menu.permType"
    :icon="menu.icon"
    :label="menu.label"
    :to="EPermType.VIEW === menu.permType ? { name: menu.name } : ''"
    expand-separator
  >
    <MainLayoutDrawerLeftListMenuExpansionItem
      v-for="(item, index) in menu?.children"
      :key="index"
      :content-inset-level="0.25"
      :header-inset-level="0.25"
      :menu="item"
    />
  </q-expansion-item>
</template>

<style lang="scss" scoped>
:deep(.q-item__section--avatar) {
  min-width: 0;
}
</style>
