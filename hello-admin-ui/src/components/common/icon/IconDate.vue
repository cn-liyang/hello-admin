<script lang="ts" setup>
interface QDatePropsRangeValue {
  from: string;
  to: string;
}

const { isRanged } = defineProps<{
  isRanged: boolean;
}>();
const modelRef = defineModel<string>({ required: true });

const originalRef = ref<string | QDatePropsRangeValue>();
watch(originalRef, (value) => {
  if (isRanged) {
    const { from, to } = <QDatePropsRangeValue>value;
    setRef(modelRef, `${from} ~ ${to}`);
  } else {
    setRef(modelRef, <string>value);
  }
});
</script>

<template>
  <q-icon class="cursor-pointer" color="secondary" name="mdi-calendar">
    <q-popup-proxy cover>
      <q-date v-model="originalRef" :mask="$DATE_FORMAT" :range="isRanged" flat>
        <div class="row no-wrap justify-end items-center">
          <q-btn v-close-popup dense flat icon="mdi-close" round />
        </div>
      </q-date>
    </q-popup-proxy>
  </q-icon>
</template>
