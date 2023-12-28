<script lang="ts" setup>
const { settingRemovableRef } = useGlobalStateLocalStorageSetting();
</script>

<template>
  <q-btn
    :icon="settingRemovableRef.mainLayout.drawerLeftIsShow ? 'mdi-menu-open' : 'mdi-menu'"
    aria-label="Menu"
    dense
    flat
    round
    style="margin-right: 10px"
    @click="settingRemovableRef.mainLayout.drawerLeftIsShow = !settingRemovableRef.mainLayout.drawerLeftIsShow"
  />
</template>
