<script lang="ts" setup>
const { asyncLogout } = useAsyncStateLogout();
</script>

<template>
  <q-menu auto-close fit persistent>
    <q-list dense>
      <MenuItem icon="mdi-account-circle" label="个人中心" />
      <MenuItem icon="mdi-cog" label="系统配置" />
      <q-separator />
      <MenuItem icon="mdi-logout" label="退出登录" @click="asyncLogout()" />
    </q-list>
  </q-menu>
</template>
