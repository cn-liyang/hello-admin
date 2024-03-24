<script lang="ts" setup>
defineProps<{
  label: string;
}>();

const modelRef = defineModel<boolean>({ required: true });
</script>

<template>
  <FieldSlot>
    <template #prepend>
      <div class="text-subtitle2 text-dark">
        {{ label }}
      </div>
    </template>
    <template #append>
      <q-toggle v-model="modelRef" dense />
    </template>
  </FieldSlot>
</template>
