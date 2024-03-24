<script lang="ts" setup>
defineProps<{
  caption: string;
}>();
</script>

<template>
  <q-tooltip :delay="100" :offset="[5, 5]" anchor="top middle" self="bottom middle">
    <div class="text-caption">{{ caption }}</div>
  </q-tooltip>
</template>
