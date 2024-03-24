import { IId, IRemark } from "src/types/interfaces/api/system";
import { IBaseEntity } from "src/types/interfaces/api/system/base";
import { IPermEntity } from "src/types/interfaces/api/system/perm";

export interface IRole {
  name: string;
  label: string;
}

export interface IRoleCreateRequest extends IRole, IRemark {}

export interface IRoleUpdateRequest extends IId, IRole, IRemark {}

export interface IRoleEntity extends IRole, IBaseEntity {
  permEntities?: IPermEntity[];
}
