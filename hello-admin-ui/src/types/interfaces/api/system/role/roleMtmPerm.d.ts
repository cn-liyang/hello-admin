import { IBaseEntity } from "src/types/interfaces/api/system/base";

export interface IRoleMtmPerm {
  roleId: number;
  permId: number;
}

export interface IRoleMtmPermEntity extends IRoleMtmPerm, IBaseEntity {}
