<script lang="ts" setup>
import { QSelectOption, QTable, QTableColumn } from "quasar";
import { ISearchCondition } from "src/types/interfaces/api/page";
import { ITableOnRequestParameters, ITablePagination } from "src/types/interfaces/quasar/table";

const { columns } = defineProps<{
  title?: string;
  columns?: QTableColumn[];
  rows?: Record<string, never>[];
  filter?: ISearchCondition[];
  loading?: boolean;
}>();
defineEmits<{
  request: [v: ITableOnRequestParameters];
}>();
const paginationRef = defineModel<ITablePagination>("pagination");
// v-model:selected
const selectedRowsRef = ref<Record<string, never>[]>([]);

// :columns
const operableColumns = (columns || []).concat(TABLE_COLUMN_OPERATION);
const columnSelectOptions = (columns || [])
  .filter(({ required }) => !required)
  .map(
    ({ name, label }) =>
      <QSelectOption>{
        label,
        value: name,
      },
  );
const columnVisibleNamesRef = ref<string[]>(columnSelectOptions.map(({ value }) => value));

// ref
const qTableRef = ref<QTable>();

function doRefresh() {
  (<QTable>getRef(qTableRef))?.requestServerInteraction();
  if (getRef(selectedRowsRef).length) {
    setRef(selectedRowsRef, []);
  }
}

tryOnMounted(() => (<QTable>getRef(qTableRef))?.requestServerInteraction());
</script>

<template>
  <q-card>
    <!--:grid="$q.screen.lt.md"-->
    <q-table
      ref="qTableRef"
      v-model:pagination="paginationRef"
      v-model:selected="selectedRowsRef"
      :columns="operableColumns"
      :filter="filter"
      :loading="loading"
      :rows="rows"
      :visible-columns="columnVisibleNamesRef"
      class="my-table-last-column-sticky no-shadow"
      row-key="id"
      selection="multiple"
      @request="(v) => $emit('request', v)"
    >
      <template #top="{ inFullscreen, toggleFullscreen }">
        <div class="column full-width">
          <div class="row items-center">
            <div class="q-table__title">{{ title }}</div>
            <slot name="table-top-row-first-left" />
            <q-space />
            <slot name="table-top-row-first-right" />
            <ButtonRefresh :loading="loading" @click="doRefresh()" />
            <ButtonToggleFullscreen :in-fullscreen="inFullscreen" @toggle-fullscreen="toggleFullscreen()" />
          </div>
          <slot name="table-top-row" />
          <q-separator spaced />
          <div class="row items-center">
            <slot name="table-top-row-last-left" v-bind="{ selectedRows: selectedRowsRef }" />
            <q-space />
            <SelectMultiple
              v-model="columnVisibleNamesRef"
              :display-value="$q.lang.table.columns"
              :options="columnSelectOptions"
            />
          </div>
        </div>
      </template>
      <template #body-cell-operation="props">
        <q-td :props="props">
          <slot
            name="table-body-column-operation"
            v-bind="{ ...props, setSelectedRow: () => (selectedRowsRef = [props.row]) }"
          />
        </q-td>
      </template>
    </q-table>
    <slot name="card-bottom" v-bind="{ selectedRows: selectedRowsRef, doRefresh }" />
  </q-card>
</template>

<style lang="scss">
.my-table-last-column-sticky {
  table {
    thead {
      th:last-child {
        background-color: white;
        font-weight: bold;
        position: sticky;
        right: 0;
        z-index: 1;
      }
    }

    tbody {
      td:last-child {
        background-color: white;
        position: sticky;
        right: 0;
        z-index: 1;
      }
    }
  }
}
</style>
