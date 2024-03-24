export class ValidationError extends Error {
  constructor(message: string) {
    super(message);
    this.name = this.constructor.name;
  }
}

export class ApiValidationError extends ValidationError {
  constructor(message: string) {
    super(`Please check the ${message} api!`);
    this.name = this.constructor.name;
  }
}

export class ApiSignValidationError extends ValidationError {
  constructor(message: string) {
    super(`Please check method or path of the ${message} api sign!`);
    this.name = this.constructor.name;
  }
}

export class ApiMethodValidationError extends ValidationError {
  constructor(message: string) {
    super(`Please check method of the ${message} api sign!`);
    this.name = this.constructor.name;
  }
}

export class ApiPathValidationError extends ValidationError {
  constructor(message: string) {
    super(`Please check path of the ${message} api sign!`);
    this.name = this.constructor.name;
  }
}
