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
const { createRequestRef, createDoExecute, createDialogIsOpenedRef } = useInjectedStateSystemUsers();
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
      <InputString v-model="createRequestRef.username" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="账户" />
      <InputString v-model="createRequestRef.password" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="密码" />
      <FieldBoolean v-model="createRequestRef.expiredAccount" label="是否过期账户" />
      <FieldBoolean v-model="createRequestRef.expiredPassword" label="是否过期密码" />
      <FieldBoolean v-model="createRequestRef.locked" label="是否锁定" />
      <FieldBoolean v-model="createRequestRef.enabled" label="是否启用" />
      <InputString v-model="createRequestRef.remark" autogrow label="备注" />
    </FormWriteSlot>
  </DialogCardMaximizeSlot>
</template>
