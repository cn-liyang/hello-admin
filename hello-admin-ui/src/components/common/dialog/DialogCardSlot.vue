<script lang="ts" setup>
defineProps<{
  label: string;
  color: string;
}>();
</script>

<template>
  <DialogSlot persistent>
    <CardBarSlot :color="color" :label="label">
      <slot />
      <template #card-bottom>
        <slot name="card-bottom" />
      </template>
    </CardBarSlot>
  </DialogSlot>
</template>
