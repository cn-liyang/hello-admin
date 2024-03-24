<script lang="ts" setup>
defineProps<{
  label: string;
  color: string;
}>();

const maximizedRef = ref(false);
</script>

<template>
  <DialogSlot :maximized="maximizedRef" persistent>
    <CardBarSlot :color="color" :label="label">
      <template #bar-right>
        <q-btn
          :icon="maximizedRef ? 'mdi-window-restore' : 'mdi-window-maximize'"
          dense
          flat
          @click="maximizedRef = !maximizedRef"
        />
      </template>
      <slot />
      <template #card-bottom>
        <slot name="card-bottom" />
      </template>
    </CardBarSlot>
  </DialogSlot>
</template>
