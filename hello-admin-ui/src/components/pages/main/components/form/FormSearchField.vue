<script lang="ts" setup>
import { IFormSearch } from "src/types/interfaces/quasar/form";

defineProps<{
  isAdvanced: boolean;
}>();
const modelRef = defineModel<IFormSearch>({ required: true });
</script>

<template>
  <q-field dense filled readonly>
    <template #prepend>
      <div class="text-subtitle2 text-dark">
        {{ modelRef.label }}
      </div>
    </template>
    <template #append>
      <ToggleString v-model="modelRef.value" dense />
    </template>
  </q-field>
</template>
