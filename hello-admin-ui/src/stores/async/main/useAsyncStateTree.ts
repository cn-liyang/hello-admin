export default function () {
  const rootNodes = [TREE_NODE_ROOT];
  const tickedKeysRef = ref<number[]>([]);
  const expandedKeysRef = ref<number[]>([]);

  return {
    rootNodes,
    tickedKeysRef,
    expandedKeysRef,
  };
}
