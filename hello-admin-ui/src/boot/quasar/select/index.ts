import { QSelectOption } from "quasar";
import { EPermType } from "src/types/enums/api/system";

export const SELECT_OPTIONS_PERM_TYPE: QSelectOption<EPermType>[] = [
  {
    label: "目录",
    value: EPermType.CATA,
  },
  {
    label: "视图",
    value: EPermType.VIEW,
  },
  {
    label: "接口",
    value: EPermType.RAPI,
  },
];
