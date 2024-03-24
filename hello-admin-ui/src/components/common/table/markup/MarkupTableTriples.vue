<script lang="ts" setup>
import { ITriple } from "src/types/interfaces";

defineProps<{
  triples: ITriple<string, string, never>[];
}>();
</script>

<template>
  <q-markup-table>
    <tbody>
      <tr v-for="{ left, middle, right } in triples" :key="left">
        <td>{{ middle }}</td>
        <td>{{ right }}</td>
      </tr>
    </tbody>
  </q-markup-table>
</template>
