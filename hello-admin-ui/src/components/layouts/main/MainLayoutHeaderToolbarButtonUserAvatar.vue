<script lang="ts" setup>
const { userInfoRemovableRef } = useGlobalSessionStorageMainUserInfo();
</script>

<template>
  <q-avatar>
    <div class="text-black">{{ userInfoRemovableRef.nickname?.at(0) }}</div>
    <q-badge color="red" floating rounded transparent />
  </q-avatar>
</template>
