export interface IId {
  id: number;
}

export interface IIds {
  ids: number[];
}

export interface IRemark {
  remark: string;
}

export interface IBase {
  createBy: string;
  createAt: string;
  updateBy: string;
  updateAt: string;
}

export interface IOption {
  name: string;
  icon: string;
  label: string;
  caption: string;
}
