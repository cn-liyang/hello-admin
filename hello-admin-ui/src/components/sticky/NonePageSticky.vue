<script lang="ts" setup>
const { asyncRouteToMain } = useRouteNavigation();
</script>

<template>
  <q-page-sticky :offset="[0, 18]" position="bottom">
    <q-btn-group rounded>
      <q-btn color="primary" icon="mdi-arrow-left-bold-outline" @click="$router.back()" />
      <q-btn color="secondary" icon="mdi-home-outline" @click="asyncRouteToMain()" />
    </q-btn-group>
  </q-page-sticky>
</template>
