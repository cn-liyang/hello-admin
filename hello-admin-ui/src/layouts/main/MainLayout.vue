<script lang="ts" setup>
const { menuTreesIsReadyRef, menuTreesExecute } = useGlobalStateMainMenuTrees();
const router = useRouter();
tryOnBeforeMount(async () => {
  if (!getRef(menuTreesIsReadyRef)) {
    await router.isReady();
    await menuTreesExecute();
    await router.replace(ROUTE_RECORD_MAIN_HOME.path);
  }
});
</script>

<template>
  <q-layout view="hHh LpR lFf">
    <MainLayoutHeader />
    <MainLayoutDrawerLeft />
    <MainLayoutDrawerRight />
    <MainLayoutContainer />
    <MainLayoutFooter />
  </q-layout>
</template>
