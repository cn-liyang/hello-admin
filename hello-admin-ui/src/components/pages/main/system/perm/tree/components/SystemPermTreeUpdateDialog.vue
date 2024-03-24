<script lang="ts" setup>
import { EPermType } from "src/types/enums/api/system";

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
const { updateRequestRef, updateDoExecute, updateDialogIsOpenedRef } = useInjectedStateSystemPerms();
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
      <InputString
        v-if="EPermType.CATA === updateRequestRef.permType"
        v-model="updateRequestRef.permSign"
        label="权限标志"
      />
      <InputString
        v-else
        v-model="updateRequestRef.permSign"
        :rules="[$VALIDATION_RULE_STRING_TRUTHY]"
        label="权限标志"
      />
      <InputString v-model="updateRequestRef.name" :rules="[$VALIDATION_RULE_STRING_TRUTHY]" label="名称" />
      <InputString v-model="updateRequestRef.icon" label="图标" />
      <InputString v-model="updateRequestRef.label" label="标签" />
      <InputString v-model="updateRequestRef.caption" label="说明" />
      <InputNumber v-model="updateRequestRef.sortBy" label="序号" />
      <InputString v-model="updateRequestRef.remark" autogrow label="备注" />
    </FormWriteSlot>
  </DialogCardMaximizeSlot>
</template>
