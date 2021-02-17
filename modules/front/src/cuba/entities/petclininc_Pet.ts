import { StandardEntity } from "./base/sys$StandardEntity";
import { PetType } from "./petclininc_PetType";
import { Owner } from "./petclininc_Owner";
import { Category } from "./base/sys$Category";
export class Pet extends StandardEntity {
  static NAME = "petclininc_Pet";
  name?: string | null;
  petType?: PetType | null;
  owner?: Owner | null;
  category?: Category | null;
}
export type PetViewName = "_base" | "_local" | "_minimal";
export type PetView<V extends PetViewName> = V extends "_base"
  ? Pick<Pet, "id" | "name" | "owner">
  : V extends "_local"
  ? Pick<Pet, "id" | "name">
  : V extends "_minimal"
  ? Pick<Pet, "id" | "name" | "owner">
  : never;
