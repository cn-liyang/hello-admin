<script lang="ts" setup>
defineProps<{
  label: string;
  icon: string;
  color?: string;
}>();
</script>

<template>
  <ItemLabelSlot :label="label">
    <template #label-after>
      <q-item-section avatar>
        <q-avatar :color="color" :icon="icon" />
      </q-item-section>
    </template>
  </ItemLabelSlot>
</template>

<style lang="scss" scoped>
:deep(.q-item__section--side) {
  padding-left: 0;
}

:deep(.q-item__section--avatar) {
  min-width: 0;
}
</style>
