<script lang="ts" setup>
withDefaults(
  defineProps<{
    label?: string;
    color?: string;
  }>(),
  {
    label: "Update",
    color: "warning",
  },
);
defineEmits<{
  ok: [];
}>();
const { updateRequestRef, updateDoExecute, updateDialogIsOpenedRef } = useInjectedStateSystemUsers();
</script>

<template>
  <DialogCardMaximizeSlot v-model="updateDialogIsOpenedRef" :color="color" :label="label">
    <FormWriteSlot
      @submit="
        updateDoExecute()
          .then(() => $emit('ok'))
          .then(() => (updateDialogIsOpenedRef = false))
      "
    >
      <InputString v-model="updateRequestRef.username" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="账户" />
      <InputString v-model="updateRequestRef.password" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="密码" />
      <FieldBoolean v-model="updateRequestRef.expiredAccount" label="是否过期账户" />
      <FieldBoolean v-model="updateRequestRef.expiredPassword" label="是否过期密码" />
      <FieldBoolean v-model="updateRequestRef.locked" label="是否锁定" />
      <FieldBoolean v-model="updateRequestRef.enabled" label="是否启用" />
      <InputString v-model="updateRequestRef.remark" autogrow label="备注" />
    </FormWriteSlot>
  </DialogCardMaximizeSlot>
</template>
