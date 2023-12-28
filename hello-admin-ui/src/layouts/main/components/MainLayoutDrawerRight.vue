<script lang="ts" setup>
const { settingRemovableRef } = useGlobalStateLocalStorageSetting();
</script>

<template>
  <q-drawer v-model="settingRemovableRef.mainLayout.drawerRightIsShow" elevated overlay side="right">
    <q-list>
      <q-item-label header>Essential Links</q-item-label>
    </q-list>
  </q-drawer>
</template>
