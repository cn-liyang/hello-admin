import { IRole } from "src/types/interfaces/api/system/role";
import { IId, IRemark } from "src/types/interfaces/api/system";
import { IBaseEntity } from "src/types/interfaces/api/system/base";
import { IUserMtmRole } from "src/types/interfaces/api/system/user/userMtmRole";

export interface IRoleOtmUser extends IRole, IUserMtmRole {}

export type IRoleOtmUserCreateRequest = IUserMtmRole;

export interface IRoleOtmUserUpdateRequest extends IId, IRoleOtmUser, IRemark {}

export interface IRoleOtmUserEntity extends IRoleOtmUser, IBaseEntity {}
