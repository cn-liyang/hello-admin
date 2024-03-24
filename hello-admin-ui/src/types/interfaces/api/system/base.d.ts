import { IBase, IId, IIds, IRemark } from "src/types/interfaces/api/system/index";

export interface IBaseResponse<T> {
  code: string;
  message: string;
  data?: T;
  timestamp: number;
}

export interface IBaseEncryption {
  encrypted: string;
}

export interface IBaseEntity extends IId, IBase, IRemark {}

export type IIdRequest = IId;

export type IIdsRequest = IIds;
