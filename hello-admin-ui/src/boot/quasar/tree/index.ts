import { QTreeNode } from "quasar";
import { EPermType } from "src/types/enums/api/system";

export const TREE_NODE_ROOT: QTreeNode = {
  id: 0,
  icon: "mdi-slash-forward",
  label: "",
  lazy: true,
  noTick: true,
  permType: EPermType.CATA,
} as const;
