import { IRole } from "src/types/interfaces/api/system/role";
import { IId, IRemark } from "src/types/interfaces/api/system";
import { IBaseEntity } from "src/types/interfaces/api/system/base";
import { IUserMtmRole } from "src/types/interfaces/api/system/user/userMtmRole";

export interface IUserOtmRole extends IRole, IUserMtmRole {}

export type IUserOtmRoleCreateRequest = IUserMtmRole;

export interface IUserOtmRoleUpdateRequest extends IId, IUserOtmRole, IRemark {}

export interface IUserOtmRoleEntity extends IUserOtmRole, IBaseEntity {}
