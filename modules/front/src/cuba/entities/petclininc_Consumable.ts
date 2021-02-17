import { StandardEntity } from "./base/sys$StandardEntity";
export class Consumable extends StandardEntity {
  static NAME = "petclininc_Consumable";
  title?: string | null;
  description?: string | null;
  price?: any | null;
}
export type ConsumableViewName = "_base" | "_local" | "_minimal";
export type ConsumableView<V extends ConsumableViewName> = V extends "_base"
  ? Pick<Consumable, "id" | "title" | "description" | "price">
  : V extends "_local"
  ? Pick<Consumable, "id" | "title" | "description" | "price">
  : V extends "_minimal"
  ? Pick<Consumable, "id" | "title">
  : never;
