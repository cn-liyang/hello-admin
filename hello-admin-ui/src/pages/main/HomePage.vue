<script lang="ts" setup></script>

<template>
  <MainPageSlot>
    <div class="row items-start q-gutter-md">
      <q-card>
        <q-card-section class="q-pb-none text-h6">项目简介</q-card-section>
        <q-card-section class="q-gutter-xs text-body2">
          <div>本项目借鉴了网上诸多成熟后台管理框架。</div>
          <div>前后端组合了 Quasar、MyBatis-Flex 等的特性。</div>
          <div>后续会继续更新一些实用功能。</div>
        </q-card-section>
        <q-card-section class="q-pt-none text-body1">当前版本: v1.0.0</q-card-section>
      </q-card>
      <q-card>
        <q-card-section class="q-pb-none text-h6">技术选型</q-card-section>
        <q-card-section horizontal>
          <q-card-section>
            <div class="text-body1">前端技术</div>
            <div class="text-body2">
              <q-markup-table dense flat separator="none">
                <tbody>
                  <tr>
                    <td class="text-left">vue</td>
                    <td class="text-right">3.4.x</td>
                  </tr>
                  <tr>
                    <td class="text-left">vue-router</td>
                    <td class="text-right">4.2.x</td>
                  </tr>
                </tbody>
              </q-markup-table>
            </div>
          </q-card-section>
          <q-card-section class="q-gutter-y-xs">
            <div class="text-body1">后端技术</div>
            <div class="text-body2">后端技术</div>
            <div class="text-body2">后端技术</div>
            <div class="text-body2">后端技术</div>
            <div class="text-body2">后端技术</div>
          </q-card-section>
        </q-card-section>
      </q-card>
      <q-card>HomePage</q-card>
      <q-card>HomePage</q-card>
      <q-card>HomePage</q-card>
      <q-card>HomePage</q-card>
      <q-card>HomePage</q-card>
      <q-card>HomePage</q-card>
      <q-card>HomePage</q-card>
    </div>
  </MainPageSlot>
</template>

<style lang="scss" scoped></style>
