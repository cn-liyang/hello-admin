<script lang="ts" setup>
import { QTree, QTreeLazyLoadParams, QTreeNode } from "quasar";
import { EPermType } from "src/types/enums/api/system";

defineProps<{
  title?: string;
  tickStrategy?: string;
  loading?: boolean;
}>();
defineEmits<{
  lazyLoad: [v: QTreeLazyLoadParams];
}>();
const expandedKeysRef = defineModel<number[]>("expanded");
const tickedKeysRef = defineModel<number[]>("ticked");

// ref
const qTreeRef = ref<QTree>();
// tree
const { rootNodes } = useAsyncStateTree();
// v-model:selected
const selectedKeyRef = ref(0);
const selectedNodesRef = ref<QTreeNode[]>(rootNodes);
watch(selectedKeyRef, (v) => {
  if (Number.isInteger(v)) {
    const node = (<QTree>getRef(qTreeRef))?.getNodeByKey(v);
    setRef(selectedNodesRef, node ? [node] : []);
  } else {
    setRef(selectedNodesRef, []);
  }
});

function doRefreshNode(node: QTreeNode) {
  setTimeout(() => {
    (<QTree>getRef(qTreeRef))?.setExpanded(node.id, false);
  }, 0);
  node.lazy = true;
  node.children = undefined;
  setTimeout(() => {
    (<QTree>getRef(qTreeRef))?.setExpanded(node.id, true);
  }, 0);
}

function doRefresh() {
  const rootNode = (<QTree>getRef(qTreeRef))?.getNodeByKey(0);
  if (rootNode) {
    doRefreshNode(rootNode);
  }
}

function doRefreshChildren() {
  const selectedNodes = getRef(selectedNodesRef);
  if (selectedNodes.length) {
    doRefreshNode(selectedNodes[0]);
  }
}

function doRefreshParent() {
  const selectedNodes = getRef(selectedNodesRef);
  if (selectedNodes.length) {
    const parentNode = (<QTree>getRef(qTreeRef))?.getNodeByKey(selectedNodes[0].parentId);
    if (parentNode) {
      doRefreshNode(parentNode);
    }
  }
}

tryOnMounted(() => (<QTree>getRef(qTreeRef))?.setExpanded(getRef(selectedKeyRef) || 0, true));
</script>

<template>
  <q-card>
    <q-card-section style="padding-top: 12px; padding-bottom: 12px">
      <div class="column full-width">
        <div class="row items-center">
          <div class="q-table__title">{{ title }}</div>
          <slot name="card-top-row-first-left" />
          <q-space />
          <slot name="card-top-row-first-right" />
          <ButtonRefresh :loading="loading" @click="doRefresh()" />
        </div>
        <q-separator spaced />
        <slot name="card-top-row" v-bind="{ selectedNodes: selectedNodesRef }" />
      </div>
    </q-card-section>
    <q-card-section>
      <q-tree
        ref="qTreeRef"
        v-model:expanded="expandedKeysRef"
        v-model:selected="selectedKeyRef"
        v-model:ticked="tickedKeysRef"
        :nodes="rootNodes"
        :tick-strategy="tickStrategy"
        accordion
        node-key="id"
        @lazy-load="(v) => $emit('lazyLoad', v)"
      >
        <template #default-header="props">
          <div class="row no-wrap items-center q-gutter-x-xs full-width">
            <div
              :class="`text-${
                EPermType.CATA === props.node.permType
                  ? 'teal'
                  : EPermType.VIEW === props.node.permType
                  ? 'green'
                  : 'lime'
              }`"
            >
              {{ $SELECT_OPTIONS_PERM_TYPE.find(({ value }) => props.node.permType === value)?.label }}
            </div>
            <q-icon :name="props.node.icon" />
            <div>{{ props.node.label }}</div>
            <div v-show="$q.screen.gt.sm">{{ props.node.permSign }}</div>
            <q-space />
            <slot
              name="tree-header-operation"
              v-bind="{ ...props, setSelectedNodes: () => (selectedNodesRef = [props.node]) }"
            />
          </div>
        </template>
      </q-tree>
    </q-card-section>
    <slot name="card-bottom" v-bind="{ selectedNodes: selectedNodesRef, doRefreshChildren, doRefreshParent }" />
  </q-card>
</template>
