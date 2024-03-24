<script lang="ts" setup>
defineProps<{
  icon: string;
  label: string;
  color?: string;
}>();
</script>

<template>
  <ItemLabelSlot :label="label">
    <template #label-before>
      <q-item-section side>
        <q-icon :color="color" :name="icon" />
      </q-item-section>
    </template>
  </ItemLabelSlot>
</template>

<style lang="scss" scoped>
:deep(.q-item__section--side) {
  padding-right: 6px;
}
</style>
