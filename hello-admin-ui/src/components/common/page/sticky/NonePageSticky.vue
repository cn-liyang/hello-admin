<script lang="ts" setup></script>

<template>
  <q-page-sticky :offset="[0, 18]" position="bottom">
    <q-btn-group rounded>
      <q-btn color="secondary" icon="mdi-arrow-left-bold-outline" @click="$router.back()" />
      <!--<q-btn color="primary" icon="mdi-home-outline" @click="routeToMain()" />-->
    </q-btn-group>
  </q-page-sticky>
</template>
