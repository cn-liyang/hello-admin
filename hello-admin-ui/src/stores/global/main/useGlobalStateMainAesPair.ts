import CryptoJS from "crypto-js";
import { IRestApi } from "src/types/interfaces/api";
import { EHttpMethod } from "src/types/enums";
import { IAesPair } from "src/types/interfaces/crypto/aes";
import { IBaseEncryption, IBaseResponse } from "src/types/interfaces/api/system/base";

export const API_REST_AES_PAIR: IRestApi = {
  method: EHttpMethod.GET,
  url: "/aes-pair",
} as const;

export const API_RESPONSE_AES_PAIR: IAesPair = {
  key: "",
  iv: "",
};

export default createGlobalState(() => {
  const aesPairRef = ref(API_RESPONSE_AES_PAIR);
  const keyWordArrayComputedRef = computed(() => CryptoJS.enc.Base64.parse(getRef(aesPairRef, "key")));
  const cipherOptionComputedRef = computed(() => ({
    iv: CryptoJS.enc.Base64.parse(getRef(aesPairRef, "iv")),
    mode: CryptoJS.mode.CBC,
    padding: CryptoJS.pad.Pkcs7,
  }));

  function encryptByAesCbcPkcs7(plainText: string) {
    return encryptByAes(plainText, getRef(keyWordArrayComputedRef), getRef(cipherOptionComputedRef));
  }

  function decryptByAesCbcPkcs7(encryptedBase64Text: string) {
    return decryptByAes(encryptedBase64Text, getRef(keyWordArrayComputedRef), getRef(cipherOptionComputedRef));
  }

  const {
    state: aesPairResponseRef,
    isReady: aesPairIsReadyRef,
    isLoading: aesPairIsLoadingRef,
    execute: aesPairExecute,
  } = useAsyncState<IAesPair>(() => doRequestWithRsa(API_REST_AES_PAIR), API_RESPONSE_AES_PAIR, {
    immediate: false,
    onSuccess: (r) => setRef(aesPairRef, r),
  });

  async function doRequestWithAes<O, I = undefined>(restApi: IRestApi, input?: I): Promise<O> {
    if (!getRef(aesPairRef).key || !getRef(aesPairRef).iv) {
      await aesPairExecute();
    }
    const encryptedI = input ? <IBaseEncryption>{ encrypted: encryptByAesCbcPkcs7(JSON.stringify(input)) } : input;
    const encryptedO = <IBaseEncryption>await api.request({ ...restApi, data: encryptedI });
    const decryptedI = decryptByAesCbcPkcs7(encryptedO.encrypted);
    const decryptedO = <IBaseResponse<O>>JSON.parse(decryptedI);
    return getResponseBodyData(decryptedO);
  }

  function setAesPair(aesPair: IAesPair) {
    setRef(aesPairRef, aesPair);
    setRef(aesPairIsReadyRef, true);
  }

  return {
    aesPairRef,
    doRequestWithAes,
    aesPairResponseRef,
    aesPairIsReadyRef,
    aesPairIsLoadingRef,
    aesPairExecute,
    setAesPair,
  };
});
