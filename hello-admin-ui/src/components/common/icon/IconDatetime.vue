<script lang="ts" setup>
const modelRef = defineModel<string>({ required: true });
</script>

<template>
  <q-icon class="cursor-pointer" color="secondary" name="mdi-calendar">
    <q-menu>
      <q-list>
        <q-item>
          <q-card class="row no-wrap justify-center items-center">
            <q-date v-model="modelRef" :mask="$DATETIME_FORMAT" flat>
              <div class="row no-wrap justify-end items-center">
                <q-btn v-close-popup dense flat icon="mdi-close" round />
              </div>
            </q-date>
            <q-time v-model="modelRef" :mask="$DATETIME_FORMAT" flat format24h>
              <div class="row no-wrap justify-end items-center">
                <q-btn v-close-popup dense flat icon="mdi-close" round />
              </div>
            </q-time>
          </q-card>
        </q-item>
      </q-list>
    </q-menu>
  </q-icon>
</template>

<style lang="scss" scoped>
.q-item {
  padding: 0;
}

.q-card {
  border-radius: 0;
}
</style>
