<script lang="ts" setup>
const { userInfoRemovableRef } = useGlobalStateSessionStorageMainUserInfo();
</script>

<template>
  <q-avatar>
    <span class="text-black">{{ userInfoRemovableRef.nickname?.at(0) }}</span>
    <q-badge color="red" floating rounded transparent />
  </q-avatar>
</template>
