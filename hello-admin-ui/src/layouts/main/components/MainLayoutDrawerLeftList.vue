<script lang="ts" setup>
const { mainMenusComputedRef } = useGlobalStateMemoryMainMenus();
</script>

<template>
  <q-list>
    <q-expansion-item
      v-for="{ name, icon, label, caption } in mainMenusComputedRef"
      :key="name"
      :caption="caption"
      :icon="icon"
      :label="label"
      :to="{ name }"
      expand-separator
      hide-expand-icon
    />
  </q-list>
</template>
