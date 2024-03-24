<script lang="ts" setup>
import { QTab } from "quasar";

const qTabRef = ref<QTab>();
const { isOutside } = useMouseInElement(qTabRef);
</script>

<template>
  <q-tab ref="qTabRef">
    <slot v-bind="{ mouseIsInside: !isOutside }" />
  </q-tab>
</template>
