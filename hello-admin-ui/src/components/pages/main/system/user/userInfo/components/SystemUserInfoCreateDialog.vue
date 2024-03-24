<script lang="ts" setup>
withDefaults(
  defineProps<{
    label?: string;
    color?: string;
  }>(),
  {
    label: "Create",
    color: "positive",
  },
);
defineEmits<{
  ok: [];
}>();
const { createRequestRef, createDoExecute, createDialogIsOpenedRef } = useInjectedStateSystemUserInfos();
</script>

<template>
  <DialogCardMaximizeSlot v-model="createDialogIsOpenedRef" :color="color" :label="label">
    <FormWriteSlot
      @submit="
        createDoExecute()
          .then(() => $emit('ok'))
          .then(() => (createDialogIsOpenedRef = false))
      "
    >
      <InputString v-model="createRequestRef.nickname" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="昵称" />
      <InputString v-model="createRequestRef.avatar" label="头像 DataURL" />
      <InputString v-model="createRequestRef.remark" autogrow label="备注" />
    </FormWriteSlot>
  </DialogCardMaximizeSlot>
</template>
