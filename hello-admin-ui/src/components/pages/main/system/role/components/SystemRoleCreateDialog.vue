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
const { createRequestRef, createDoExecute, createDialogIsOpenedRef } = useInjectedStateSystemRoles();
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
      <InputString v-model="createRequestRef.name" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="名称" />
      <InputString v-model="createRequestRef.label" label="标签" />
      <InputString v-model="createRequestRef.remark" autogrow label="备注" />
    </FormWriteSlot>
  </DialogCardMaximizeSlot>
</template>
