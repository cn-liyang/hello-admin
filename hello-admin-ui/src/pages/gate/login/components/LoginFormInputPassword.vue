<script lang="ts" setup>
import { ValidationRule } from "quasar";

const validationRules: ValidationRule[] = [
  (v) => !!v || "请输入密码",
  (v) => REGEXP_LOGIN_PASSWORD.pattern.test(v) || `请输入${REGEXP_LOGIN_PASSWORD.message}`,
];
const isPasswordRef = ref(true);
const { loginRequestRef } = useInjectedStateLogin();
</script>

<template>
  <q-input
    v-model.trim="loginRequestRef.password"
    :rules="validationRules"
    :type="isPasswordRef ? 'password' : 'text'"
    dense
    outlined
    placeholder="请输入密码"
    standout
  >
    <template #prepend>
      <q-icon name="mdi-lock" />
    </template>
    <template #append>
      <q-btn
        :icon="isPasswordRef ? 'mdi-eye-off-outline' : 'mdi-eye-outline'"
        dense
        flat
        @click="isPasswordRef = !isPasswordRef"
      />
    </template>
  </q-input>
</template>
