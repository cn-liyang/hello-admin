import { IBaseEntity } from "src/types/interfaces/api/system/base";

export interface IUserMtmRole {
  userId: number;
  roleId: number;
}

export interface IUserMtmRoleEntity extends IUserMtmRole, IBaseEntity {}
