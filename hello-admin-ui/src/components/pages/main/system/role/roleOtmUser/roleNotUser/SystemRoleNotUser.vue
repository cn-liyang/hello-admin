<script lang="ts" setup>
defineProps<{
  roleId: number;
}>();
defineEmits<{
  ok: [v: Record<string, never>[]];
}>();
const title = "角色新增账户查询";
const apiPath = API_PATH_SYSTEM_ROLE_NOT_USERS;
const columns = TABLE_COLUMNS_ROLE_NOT_USER_ENTITY;
</script>

<template>
  <TableReadSearchOkCancelSlot
    :api-path="apiPath"
    :columns="columns"
    :filter-is-hidden="true"
    :search-id="roleId"
    :title="title"
    @ok="(v) => $emit('ok', v)"
  />
</template>
