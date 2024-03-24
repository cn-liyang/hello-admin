import { QTreeLazyLoadParams } from "quasar";
import { EHttpMethod } from "src/types/enums";
import { IIdRequest } from "src/types/interfaces/api/system/base";
import { IPermEntity } from "src/types/interfaces/api/system/perm";
import { EPermType } from "src/types/enums/api/system";

export default function (apiPath: string) {
  const {
    state: searchResponseRef,
    isReady: searchIsReadyRef,
    isLoading: searchIsLoadingRef,
    execute: searchExecute,
  } = useAsyncState<IPermEntity[], IIdRequest[]>(
    (args) =>
      doRequest(
        {
          method: EHttpMethod.POST,
          url: apiPath + API_PATH_PATTERN_CHILDREN,
        },
        args,
      ),
    [],
    {
      immediate: false,
    },
  );

  function doLazyLoad(props: QTreeLazyLoadParams) {
    searchExecute(0, { id: Number(props.key) }).then((r) => {
      if (r?.length) {
        const nodes = r.map((i) => ({
          ...i,
          lazy: EPermType.RAPI !== i.permType,
        }));
        props.done(nodes);
      } else {
        props.done([]);
      }
    });
  }

  return {
    searchResponseRef,
    searchIsReadyRef,
    searchIsLoadingRef,
    searchExecute,
    doLazyLoad,
  };
}
