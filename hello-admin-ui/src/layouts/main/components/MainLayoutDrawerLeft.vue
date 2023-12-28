<script lang="ts" setup>
const { settingRemovableRef } = useGlobalStateLocalStorageSetting();
const isMiniRef = ref(true);
</script>

<template>
  <q-drawer
    v-model="settingRemovableRef.mainLayout.drawerLeftIsShow"
    :breakpoint="600"
    :mini="!settingRemovableRef.mainLayout.drawerLeftIsShow || isMiniRef"
    :width="220"
    bordered
    class="bg-blue-1"
    show-if-above
    @click.stop="isMiniRef = false"
  >
    <q-scroll-area class="fit">
      <MainLayoutDrawerLeftList />
    </q-scroll-area>
    <!--<div class="q-mini-drawer-hide absolute" style="top: 6px; right: 11px">
      <q-btn color="accent" dense icon="mdi-chevron-left" round @click.stop="isMiniRef = true" />
    </div>-->
  </q-drawer>
</template>
