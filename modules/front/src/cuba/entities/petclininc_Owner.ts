import { StandardEntity } from "./base/sys$StandardEntity";
import { Pet } from "./petclininc_Pet";
export class Owner extends StandardEntity {
  static NAME = "petclininc_Owner";
  name?: string | null;
  email?: string | null;
  phoneNo?: string | null;
  pets?: Pet[] | null;
}
export type OwnerViewName = "_base" | "_local" | "_minimal";
export type OwnerView<V extends OwnerViewName> = V extends "_base"
  ? Pick<Owner, "id" | "name" | "email" | "phoneNo">
  : V extends "_local"
  ? Pick<Owner, "id" | "name" | "email" | "phoneNo">
  : V extends "_minimal"
  ? Pick<Owner, "id" | "name">
  : never;
