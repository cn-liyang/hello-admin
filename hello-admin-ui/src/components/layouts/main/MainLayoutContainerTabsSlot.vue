<script lang="ts" setup>
const { tabRef, tabsRef, removeTab } = useGlobalStateMainTabs();
</script>

<template>
  <q-tabs v-model="tabRef" align="left" dense indicator-color="primary" inline-label no-caps shrink>
    <TabMouseInSlot
      v-for="{ path, label } in tabsRef"
      :key="path"
      #="{ mouseIsInside }"
      :label="label"
      :name="path"
      @click="$router.push(path)"
    >
      <BadgeClose v-show="mouseIsInside && tabsRef.length > 1" @click.stop="removeTab(path)" />
    </TabMouseInSlot>
  </q-tabs>
  <q-separator />
</template>
