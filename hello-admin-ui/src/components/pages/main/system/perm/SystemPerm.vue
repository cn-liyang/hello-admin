<script lang="ts" setup>
const panelRef = ref(true);
const apiPath = API_PATH_SYSTEM_PERMS;
const columns = TABLE_COLUMNS_PERM_ENTITY;
useProvidingStateSystemPerms();
</script>

<template>
  <q-tab-panels v-model="panelRef" animated>
    <q-tab-panel :name="true">
      <SystemPermTree v-model="panelRef" :api-path="apiPath" :columns="columns" />
    </q-tab-panel>
    <q-tab-panel :name="false">
      <SystemPermTable v-model="panelRef" :api-path="apiPath" :columns="columns" />
    </q-tab-panel>
  </q-tab-panels>
</template>
