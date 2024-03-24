<script lang="ts" setup>
import { EPermType } from "src/types/enums/api/system";

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

const { createRequestRef, createDoExecute, createDialogIsOpenedRef } = useInjectedStateSystemPerms();
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
      <InputNumber v-model="createRequestRef.parentId" label="父级主键" />
      <FieldOptionGroupPermType v-model="createRequestRef.permType" label="权限类型" />
      <InputString
        v-if="EPermType.CATA === createRequestRef.permType"
        v-model="createRequestRef.permSign"
        label="权限标志"
      />
      <InputString
        v-else
        v-model="createRequestRef.permSign"
        :rules="[$VALIDATION_RULE_STRING_TRUTHY]"
        label="权限标志"
      />
      <InputString v-model="createRequestRef.name" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="名称" />
      <InputString v-model="createRequestRef.icon" label="图标" />
      <InputString v-model="createRequestRef.label" label="标签" />
      <InputString v-model="createRequestRef.caption" label="说明" />
      <InputNumber v-model="createRequestRef.sortBy" label="序号" />
      <InputString v-model="createRequestRef.remark" autogrow label="备注" />
    </FormWriteSlot>
  </DialogCardMaximizeSlot>
</template>
