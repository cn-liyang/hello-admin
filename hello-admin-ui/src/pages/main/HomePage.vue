<script lang="ts" setup>
const introduction = "你好后台管理系统";
</script>

<template>
  <MainPageSlot>
    <div class="row items-start q-gutter-md">
      <q-card>
        <q-card-section class="q-pb-none text-h6">项目简介</q-card-section>
        <q-card-section class="q-gutter-xs text-body2">
          <div>{{ introduction }}</div>
        </q-card-section>
        <q-card-section class="q-pt-none text-body1">当前版本: v1.0.0</q-card-section>
      </q-card>
    </div>
  </MainPageSlot>
</template>

<style lang="scss" scoped></style>
