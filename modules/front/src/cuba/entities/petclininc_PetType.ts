import { StandardEntity } from "./base/sys$StandardEntity";
export class PetType extends StandardEntity {
  static NAME = "petclininc_PetType";
  name?: string | null;
}
export type PetTypeViewName = "_base" | "_local" | "_minimal";
export type PetTypeView<V extends PetTypeViewName> = V extends "_base"
  ? Pick<PetType, "id" | "name">
  : V extends "_local"
  ? Pick<PetType, "id" | "name">
  : V extends "_minimal"
  ? Pick<PetType, "id" | "name">
  : never;
