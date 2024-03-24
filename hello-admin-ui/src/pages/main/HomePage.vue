<script lang="ts" setup>
const introduction =
  "本人参与开发工作多年，前端技术栈围绕 Vue 全家桶，后端技术栈围绕 Spring 全家桶。在体验了诸多的开发框架中，对于痛点：统一的、跨端的 UI，灵活的、跨库的 ORM，当然还包括基本的性能、效率、社区等，发现了 Quasar 和 MyBatis-Flex 两大框架的优势。因此，本项目采用前后端分离的方式，组合了前面的技术生态系统，同时借鉴网上诸多成熟后台管理框架，快速构建了一个基于 RBAC 的脚手架项目。该项目会持续更新一些实用功能。";
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
      <q-card>
        <q-card-section class="q-pb-none text-h6">技术选型</q-card-section>
        <q-card-section class="q-gutter-xs text-body2">
          <q-card-section horizontal>
            <div class="column q-gutter-y-xs">
              <div class="row no-wrap text-body1">前端技术</div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>quasar</div>
                <div>2.14.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>axios</div>
                <div>1.2.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>vue</div>
                <div>3.4.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>vue-router</div>
                <div>4.2.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>pinia</div>
                <div>2.1.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>vueuse</div>
                <div>10.9.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>...</div>
              </div>
            </div>
            <q-separator inset spaced vertical />
            <div class="column q-gutter-y-xs">
              <div class="row no-wrap text-body1">后端技术</div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>spring-boot</div>
                <div>3.2.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>mybatis-flex</div>
                <div>1.7.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>druid</div>
                <div>1.2.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>h2</div>
                <div>2.2.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>lombok</div>
                <div>1.18.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>easy-captcha</div>
                <div>1.6.x</div>
              </div>
              <div class="row no-wrap justify-between q-gutter-x-sm">
                <div>...</div>
              </div>
            </div>
          </q-card-section>
        </q-card-section>
      </q-card>
    </div>
  </MainPageSlot>
</template>

<style lang="scss" scoped></style>
