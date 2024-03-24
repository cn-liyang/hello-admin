import { IId } from "src/types/interfaces/api/entry";
import { IAesPair } from "src/types/interfaces/crypto/aes";

export interface ICaptchaResponse extends IId {
  dataUrl: string;
}

export interface ILoginCode extends IId {
  code: string;
}

export interface ILoginAccount {
  username: string;
  password: string;
}

export interface ILoginRequest extends ILoginCode, ILoginAccount {}

export interface ILoginResponse {
  aesPair: IAesPair;
}
