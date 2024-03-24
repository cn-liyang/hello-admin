<template>
  <q-field dense filled readonly>
    <template #prepend>
      <slot name="prepend" />
    </template>
    <template #append>
      <slot name="append" />
    </template>
    <template #control="props">
      <slot name="control" v-bind="props" />
    </template>
  </q-field>
</template>
