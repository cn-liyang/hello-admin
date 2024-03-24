<script lang="ts" setup>
defineProps<{
  disable?: boolean;
}>();
defineEmits<{
  ok: [];
}>();
</script>

<template>
  <q-card-actions align="right">
    <q-btn v-close-popup color="secondary" dense flat icon="mdi-cancel" push round>
      <TooltipTopMiddle caption="Cancel" />
    </q-btn>
    <q-btn :disable="disable" color="primary" dense flat icon="mdi-send" push round @click="$emit('ok')">
      <TooltipTopMiddle caption="Ok" />
    </q-btn>
  </q-card-actions>
</template>
