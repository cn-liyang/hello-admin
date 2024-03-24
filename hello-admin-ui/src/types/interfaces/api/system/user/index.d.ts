import { IId, IRemark } from "src/types/interfaces/api/system";
import { IBaseEntity } from "src/types/interfaces/api/system/base";

export interface IUser {
  username: string;
  password: string;
  expiredAccount: boolean;
  expiredPassword: boolean;
  locked: boolean;
  enabled: boolean;
}

export interface IUserCreateRequest extends IUser, IRemark {}

export interface IUserUpdateRequest extends IId, IUser, IRemark {}

export interface IUserEntity extends IUser, IBaseEntity {}
