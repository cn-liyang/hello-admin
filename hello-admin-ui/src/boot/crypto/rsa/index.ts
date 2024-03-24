import jsrsasign from "jsrsasign";
import privatePem from "assets/crypto/rsa_pkcs8_2048_private.pem?raw";
import publicPem from "assets/crypto/rsa_pkcs8_2048_public.pem?raw";
import { IBaseEncryption, IBaseResponse } from "src/types/interfaces/api/system/base";
import { IRestApi } from "src/types/interfaces/api";
import RSAKey = jsrsasign.RSAKey;

const ALGORITHM_RSA = "RSA";
const PRIVATE_KEY = <RSAKey>jsrsasign.KEYUTIL.getKey(privatePem);
const PUBLIC_KEY = <RSAKey>jsrsasign.KEYUTIL.getKey(publicPem);

export function encryptByRsa(plainText: string, publicKey: RSAKey | string) {
  return jsrsasign.KJUR.crypto.Cipher.encrypt(plainText, publicKey, ALGORITHM_RSA);
}

export function decryptByRsa(encryptedHexText: string, privateKey: RSAKey | string) {
  return jsrsasign.KJUR.crypto.Cipher.decrypt(encryptedHexText, privateKey, ALGORITHM_RSA);
}

export function encryptByRsaPkcs82048(plainText: string) {
  return encryptByRsa(plainText, PUBLIC_KEY);
}

export function decryptByRsaPkcs82048(encryptedHexText: string) {
  return decryptByRsa(encryptedHexText, PRIVATE_KEY);
}

export async function doRequestWithRsa<O, I = undefined>(restApi: IRestApi, input?: I): Promise<O> {
  const encryptedI = input ? <IBaseEncryption>{ encrypted: encryptByRsaPkcs82048(JSON.stringify(input)) } : input;
  const encryptedO = <IBaseEncryption>await api.request({ ...restApi, data: encryptedI });
  const decryptedI = decryptByRsaPkcs82048(encryptedO.encrypted);
  const decryptedO = <IBaseResponse<O>>JSON.parse(decryptedI);
  return getResponseBodyData(decryptedO);
}
