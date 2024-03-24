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
const { updateRequestRef, updateDoExecute, updateDialogIsOpenedRef } = useInjectedStateSystemRoles();
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
      <InputString v-model="updateRequestRef.name" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="名称" />
      <InputString v-model="updateRequestRef.label" label="标签" />
      <InputString v-model="updateRequestRef.remark" autogrow label="备注" />
    </FormWriteSlot>
  </DialogCardMaximizeSlot>
</template>
