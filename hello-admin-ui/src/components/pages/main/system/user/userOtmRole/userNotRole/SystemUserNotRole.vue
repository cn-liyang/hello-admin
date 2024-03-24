<script lang="ts" setup>
defineProps<{
  userId: number;
}>();
defineEmits<{
  ok: [v: Record<string, never>[]];
}>();
const title = "账户新增角色查询";
const apiPath = API_PATH_SYSTEM_USER_NOT_ROLES;
const columns = TABLE_COLUMNS_USER_NOT_ROLE_ENTITY;
</script>

<template>
  <TableReadSearchOkCancelSlot
    :api-path="apiPath"
    :columns="columns"
    :filter-is-hidden="true"
    :search-id="userId"
    :title="title"
    @ok="(v) => $emit('ok', v)"
  />
</template>
