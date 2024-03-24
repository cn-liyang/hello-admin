<script lang="ts" setup>
const { settingRemovableRef } = useGlobalStateLocalStorageSetting();
const isMiniRef = ref(true);
</script>

<template>
  <q-drawer
    v-model="settingRemovableRef.mainLayout.drawerLeftIsShow"
    :breakpoint="600"
    :mini="!settingRemovableRef.mainLayout.drawerLeftIsShow || isMiniRef"
    :width="200"
    bordered
    class="bg-blue-1"
    show-if-above
    @click.capture="isMiniRef = false"
  >
    <q-scroll-area class="fit">
      <MainLayoutDrawerLeftListMenu />
    </q-scroll-area>
    <div class="q-mini-drawer-hide absolute text-brown" style="top: 6px; right: 11px">
      <q-btn dense icon="mdi-chevron-left" outline round unelevated @click="isMiniRef = true" />
    </div>
  </q-drawer>
</template>
