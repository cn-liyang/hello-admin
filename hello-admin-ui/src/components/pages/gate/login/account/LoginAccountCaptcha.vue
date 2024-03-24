<script lang="ts" setup>
const { loginCodeRef, captchaResponseRef, captchaIsLoadingRef, captchaExecute } = useInjectedStateGateCaptcha();
captchaExecute();
</script>

<template>
  <LoginFormInputSlot v-model="loginCodeRef.code" icon="mdi-security" placeholder="请输入验证码">
    <q-skeleton v-if="captchaIsLoadingRef" height="38px" type="QBtn" width="102px" />
    <q-btn v-else :ripple="false" class="q-pa-none" dense flat @click="captchaExecute()">
      <q-img :src="captchaResponseRef.dataUrl" spinner-size="38px" style="height: 38px; width: 102px" />
    </q-btn>
  </LoginFormInputSlot>
</template>
