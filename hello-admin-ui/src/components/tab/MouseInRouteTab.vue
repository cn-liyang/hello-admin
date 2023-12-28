<script lang="ts" setup>
const qRouteTabRef = ref(null);
const { isOutside } = useMouseInElement(qRouteTabRef);
</script>

<template>
  <q-route-tab ref="qRouteTabRef">
    <slot v-bind="{ mouseIsInside: !isOutside }" />
  </q-route-tab>
</template>
