export interface IBaseLogin {
  id: string;
}

export interface ICaptchaResponse extends IBaseLogin {
  dataUrl: string;
}

export interface ILoginRequest extends IBaseLogin {
  code: string;
  username: string;
  password: string;
}
