<script lang="ts" setup>
const { loginIsLoadingRef, doLogin } = useProvidingStateGateLogin();
</script>

<template>
  <LoginFormSlot :disable="loginIsLoadingRef" :loading="loginIsLoadingRef" @submit="doLogin()">
    <LoginAccountUsername />
    <LoginAccountPassword />
    <LoginAccountCaptcha />
  </LoginFormSlot>
</template>
