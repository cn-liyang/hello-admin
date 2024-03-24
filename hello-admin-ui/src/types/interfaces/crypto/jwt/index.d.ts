import { JwtPayload } from "jwt-decode";

export interface IJwtPayload extends JwtPayload {
  user: string;
  roles: string[];
}
