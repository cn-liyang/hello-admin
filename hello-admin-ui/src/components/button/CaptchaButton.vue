<script lang="ts" setup>
const props = withDefaults(
  defineProps<{
    ready: boolean;
    total?: number;
  }>(),
  {
    model: false,
    total: 60,
  },
);
const { counter, reset, isActive, pause, resume } = useInterval(1000, { controls: true });
pause();
whenever(
  toRef(() => props.model),
  async () => {
    reset();
    resume();
    await until(counter).changedTimes(props.total);
    pause();
  },
);
</script>

<template>
  <q-btn
    :color="isActive ? '' : 'primary'"
    :disable="isActive"
    :label="isActive ? `${total - counter}秒后重发` : '发送验证码'"
    dark-percentage
    dense
    flat
  />
</template>
