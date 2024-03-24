import CryptoJS from "crypto-js";

export function encryptByAes(
  plainText: string,
  keyWordArray: CryptoJS.lib.WordArray,
  cipherOption: { [key: string]: unknown },
) {
  const encryptedCipherParams = CryptoJS.AES.encrypt(plainText, keyWordArray, cipherOption);
  const encryptedCipherWordArray = encryptedCipherParams.ciphertext;
  return encryptedCipherWordArray.toString(CryptoJS.enc.Base64);
}

export function decryptByAes(
  encryptedBase64Text: string,
  keyWordArray: CryptoJS.lib.WordArray,
  cipherOption: { [key: string]: unknown },
) {
  const decryptedWordArray = CryptoJS.AES.decrypt(encryptedBase64Text, keyWordArray, cipherOption);
  return decryptedWordArray.toString(CryptoJS.enc.Utf8);
}
