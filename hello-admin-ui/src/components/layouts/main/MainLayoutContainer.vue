<template>
  <q-page-container>
    <MainLayoutContainerTabsSlot />
    <router-view #="{ Component }">
      <transition enter-active-class="animated fadeIn" leave-active-class="animated fadeOut">
        <keep-alive :max="10">
          <component :is="Component" />
        </keep-alive>
      </transition>
    </router-view>
  </q-page-container>
</template>
