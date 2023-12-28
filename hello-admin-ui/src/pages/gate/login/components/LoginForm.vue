<script lang="ts" setup>
const { loginIsLoadingRef, asyncLogin } = useProvidingStateLogin();
</script>

<template>
  <LoginFormSlot @submit="asyncLogin()">
    <LoginFormInputUsername />
    <LoginFormInputPassword />
    <LoginFormInputCaptcha />
    <LoginFormSubmit :disable="loginIsLoadingRef" :loading="loginIsLoadingRef" />
  </LoginFormSlot>
</template>
