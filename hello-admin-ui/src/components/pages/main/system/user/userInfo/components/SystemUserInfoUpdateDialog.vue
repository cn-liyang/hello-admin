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
const { updateRequestRef, updateDoExecute, updateDialogIsOpenedRef } = useInjectedStateSystemUserInfos();
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
      <InputString v-model="updateRequestRef.nickname" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="昵称" />
      <InputString v-model="updateRequestRef.avatar" label="头像 DataURL" />
      <InputString v-model="updateRequestRef.remark" autogrow label="备注" />
    </FormWriteSlot>
  </DialogCardMaximizeSlot>
</template>
