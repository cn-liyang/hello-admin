<script lang="ts" setup>
const { doLogout } = useAsyncStateLogout();
</script>

<template>
  <ListSlot>
    <ItemLabelIconSlot icon="mdi-account-circle" label="个人中心" />
    <ItemLabelIconSlot icon="mdi-cog" label="系统配置" />
    <q-separator />
    <ItemLabelIconSlot icon="mdi-logout" label="退出登录" @click="doLogout()" />
  </ListSlot>
</template>
