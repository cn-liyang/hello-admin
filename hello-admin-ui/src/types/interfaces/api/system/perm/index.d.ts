import { IId, IOption, IRemark } from "src/types/interfaces/api/system";
import { EPermType } from "src/types/enums/api/system";
import { IBaseEntity } from "src/types/interfaces/api/system/base";

export interface IMenuTree extends IOption {
  permType: EPermType;
  permSign: string;
  children?: IMenuTree[];
}

export type IMenuCata = IOption;

export interface IMenuView extends IOption {
  permSign: string;
}

export interface IMenuRapi extends IOption {
  permSign: string;
}

export interface IPerm {
  parentId: number;
  permType: EPermType;
  permSign: string;
  name: string;
  icon: string;
  label: string;
  caption: string;
  sortBy: number;
}

export interface IPermCreateRequest extends IPerm, IRemark {}

export interface IPermUpdateRequest extends IId, IPerm, IRemark {}

export interface IPermEntity extends IPerm, IBaseEntity {
  children?: IPermEntity[];
}
