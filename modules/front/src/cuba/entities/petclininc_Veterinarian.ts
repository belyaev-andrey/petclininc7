import { StandardEntity } from "./base/sys$StandardEntity";
import { User } from "./base/sec$User";
export class Veterinarian extends StandardEntity {
  static NAME = "petclininc_Veterinarian";
  user?: User | null;
  hourlyRate?: any | null;
}
export type VeterinarianViewName = "_base" | "_local" | "_minimal";
export type VeterinarianView<V extends VeterinarianViewName> = V extends "_base"
  ? Pick<Veterinarian, "id" | "user" | "hourlyRate">
  : V extends "_local"
  ? Pick<Veterinarian, "id" | "hourlyRate">
  : V extends "_minimal"
  ? Pick<Veterinarian, "id" | "user" | "hourlyRate">
  : never;
