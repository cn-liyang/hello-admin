<script lang="ts" setup>
import { EPermType } from "src/types/enums/api/system";

const modelRef = defineModel<EPermType>({ required: true });
</script>

<template>
  <q-option-group v-model="modelRef" :options="$SELECT_OPTIONS_PERM_TYPE" color="primary" dense inline />
</template>
