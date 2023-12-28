<script lang="ts" setup>
const title = process.env.APP_TITLE;
</script>

<template>
  <q-toolbar>
    <MainLayoutHeaderToolbarLeft />
    <q-separator dark inset vertical />
    <q-toolbar-title>{{ title }}</q-toolbar-title>
    <MainLayoutHeaderToolbarRight />
  </q-toolbar>
</template>
