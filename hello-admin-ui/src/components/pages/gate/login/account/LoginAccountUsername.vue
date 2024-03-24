<script lang="ts" setup>
import { ValidationRule } from "quasar";

const { loginAccountRef } = useInjectedStateGateLogin();
</script>

<template>
  <LoginFormInputSlot
    v-model.trim="loginAccountRef.username"
    :rules="[
      <ValidationRule>((v) => $REGEXP_LOGIN_USERNAME.pattern.test(v) || `请输入${$REGEXP_LOGIN_USERNAME.message}`),
    ]"
    icon="mdi-account"
    placeholder="请输入帐号"
  />
</template>
