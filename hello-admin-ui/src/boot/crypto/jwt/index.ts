import { SessionStorage } from "quasar";
import { IJwtPayload } from "src/types/interfaces/crypto/jwt";
import { ESecurityRole } from "src/types/enums";

function getRoles() {
  const jwt = SessionStorage.getItem(SESSION_STORAGE_KEY_AUTHORIZATION)?.toString().replace("Bearer ", "");
  return jwt ? jwtDecode<IJwtPayload>(jwt).roles : [];
}

export function isAdminRole() {
  return getRoles().some((i) => ESecurityRole.ADMIN.toLowerCase() === i.toLowerCase());
}

export function isGuestRole() {
  return getRoles().every((i) => ESecurityRole.GUEST.toLowerCase() === i.toLowerCase());
}
