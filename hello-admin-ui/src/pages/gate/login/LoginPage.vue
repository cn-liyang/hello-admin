<script lang="ts" setup>
const title = process.env.APP_TITLE;
</script>

<template>
  <GatePageSlot>
    <q-card>
      <q-card-section>
        <q-item-label class="text-h6 text-center">{{ title }}</q-item-label>
        <q-item-label class="text-caption text-right text-italic">-- cn-liyang</q-item-label>
      </q-card-section>
      <q-separator />
      <q-card-section>
        <LoginAccount />
      </q-card-section>
    </q-card>
  </GatePageSlot>
</template>
