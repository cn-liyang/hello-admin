<script lang="ts" setup>
const { seconds } = withDefaults(
  defineProps<{
    seconds?: number;
  }>(),
  {
    seconds: 60,
  },
);
const { counter, reset, pause, resume } = useInterval(1000, { controls: true, immediate: false });

async function doSend() {
  resume();
  await until(counter).toMatch((r) => r > seconds);
  pause();
  reset();
}
</script>

<template>
  <q-btn
    :color="seconds > counter ? '' : 'primary'"
    :disable="seconds > counter"
    :label="seconds > counter ? `${seconds - counter}秒后重发` : '发送验证码'"
    dark-percentage
    dense
    flat
    @click="doSend()"
  />
</template>
