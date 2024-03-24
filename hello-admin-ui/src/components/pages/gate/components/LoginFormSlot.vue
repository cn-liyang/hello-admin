<script lang="ts" setup>
defineProps<{
  disable: boolean;
  loading: boolean;
}>();
</script>

<template>
  <q-form class="q-gutter-y-sm" style="max-width: 20em">
    <slot />
    <LoginFormSubmitButton :disable="disable" :loading="loading" />
  </q-form>
</template>
