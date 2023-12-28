<script lang="ts" setup>
import { ValidationRule } from "quasar";

const validationRules: ValidationRule[] = [
  (v) => !!v || "请输入帐号",
  (v) => REGEXP_LOGIN_USERNAME.pattern.test(v) || `请输入${REGEXP_LOGIN_USERNAME.message}`,
];
const { loginRequestRef } = useInjectedStateLogin();
</script>

<template>
  <q-input
    v-model.trim="loginRequestRef.username"
    :rules="validationRules"
    dense
    outlined
    placeholder="请输入帐号"
    standout
  >
    <template #prepend>
      <q-icon name="mdi-account" />
    </template>
  </q-input>
</template>
