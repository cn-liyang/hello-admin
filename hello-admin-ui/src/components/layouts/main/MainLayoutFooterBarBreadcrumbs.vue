<template>
  <q-breadcrumbs active-color="black" class="text-primary" style="font-size: 12px">
    <q-breadcrumbs-el v-for="({ icon, label }, index) in $route.meta?.catas" :key="index" :icon="icon" :label="label" />
  </q-breadcrumbs>
</template>
