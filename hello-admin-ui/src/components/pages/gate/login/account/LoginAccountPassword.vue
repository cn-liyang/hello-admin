<script lang="ts" setup>
import { ValidationRule } from "quasar";

const { loginAccountRef } = useInjectedStateGateLogin();
const isPasswordRef = ref(true);
</script>

<template>
  <LoginFormInputSlot
    v-model="loginAccountRef.password"
    :rules="[
      <ValidationRule>((v) => $REGEXP_LOGIN_PASSWORD.pattern.test(v) || `请输入${$REGEXP_LOGIN_PASSWORD.message}`),
    ]"
    :type="isPasswordRef ? 'password' : 'text'"
    icon="mdi-lock"
    placeholder="请输入密码"
  >
    <q-btn
      :icon="isPasswordRef ? 'mdi-eye-off-outline' : 'mdi-eye-outline'"
      :ripple="false"
      dense
      flat
      round
      @click="isPasswordRef = !isPasswordRef"
    />
  </LoginFormInputSlot>
</template>
