<template>
  <q-breadcrumbs active-color="black" class="text-primary" style="font-size: 12px">
    <q-breadcrumbs-el :icon="$route.meta.icon" :label="$route.meta.label" />
  </q-breadcrumbs>
</template>
