<script lang="ts" setup>
const { settingRemovableRef } = useGlobalStateLocalStorageSetting();
</script>

<template>
  <q-avatar>
    <span class="text-black">{{ settingRemovableRef.username?.at(0) || "A" }}</span>
    <q-badge color="red" floating rounded transparent />
  </q-avatar>
</template>
