<script lang="ts" setup>
const { captchaResponseRef, captchaIsLoadingRef, captchaExecute, loginRequestRef } = useInjectedStateLogin();
captchaExecute();
</script>

<template>
  <q-input
    v-model.trim="loginRequestRef.code"
    :rules="[(v) => !!v || '请输入验证码']"
    dense
    outlined
    placeholder="请输入验证码"
    standout
  >
    <template #prepend>
      <q-icon name="mdi-security" />
    </template>
    <template #append>
      <q-btn :loading="captchaIsLoadingRef" :ripple="false" class="q-pa-none" dense flat @click="captchaExecute()">
        <img :src="captchaResponseRef.dataUrl" alt="Captcha Image" class="row flex-center" height="38" />
      </q-btn>
    </template>
  </q-input>
</template>
