<script lang="ts" setup>
const { loginIsLoadingRef, asyncLoginAccount } = useProvidingStateLogin();
</script>

<template>
  <LoginFormSlot @submit="asyncLoginAccount()">
    <LoginFormInputUsername />
    <LoginFormInputPassword />
    <LoginFormInputCaptcha />
    <LoginFormSubmit :disable="loginIsLoadingRef" :loading="loginIsLoadingRef" />
  </LoginFormSlot>
</template>
