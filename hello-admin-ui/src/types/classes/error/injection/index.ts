export class InjectionError extends Error {
  constructor(message: string) {
    super(`Please call [${message}] on the appropriate parent component!`);
    this.name = this.constructor.name;
  }
}
