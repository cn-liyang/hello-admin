<script lang="ts" setup>
const { menuTreeComputedRef } = useGlobalStateMainMenuTrees();
</script>

<template>
  <q-list>
    <MainLayoutDrawerLeftListMenuExpansionItem v-for="(item, index) in menuTreeComputedRef" :key="index" :menu="item" />
  </q-list>
</template>
