import { IId, IRemark } from "src/types/interfaces/api/system";
import { IBaseEntity } from "src/types/interfaces/api/system/base";

export interface IUserInfo {
  nickname: string;
  avatar: string;
}

export interface IUserInfoCreateRequest extends IUserInfo, IRemark {
  userId: number;
}

export interface IUserInfoUpdateRequest extends IId, IUserInfo, IRemark {}

export interface IUserInfoEntity extends IUserInfo, IBaseEntity {
  userId: number;
}
