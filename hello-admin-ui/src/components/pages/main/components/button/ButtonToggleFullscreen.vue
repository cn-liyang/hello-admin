<script lang="ts" setup>
defineProps<{
  inFullscreen: boolean;
}>();
defineEmits<{
  toggleFullscreen: [];
}>();
</script>

<template>
  <q-btn
    :icon="inFullscreen ? 'mdi-fullscreen-exit' : 'mdi-fullscreen'"
    flat
    round
    @click="$emit('toggleFullscreen')"
  />
</template>
