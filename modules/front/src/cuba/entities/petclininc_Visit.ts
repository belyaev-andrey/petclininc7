import { StandardEntity } from "./base/sys$StandardEntity";
import { Pet } from "./petclininc_Pet";
import { Veterinarian } from "./petclininc_Veterinarian";
import { Consumable } from "./petclininc_Consumable";
export class Visit extends StandardEntity {
  static NAME = "petclininc_Visit";
  pet?: Pet | null;
  veterinarian?: Veterinarian | null;
  date?: any | null;
  duration?: number | null;
  description?: string | null;
  amount?: any | null;
  consumables?: Consumable[] | null;
  number?: any | null;
  endDate?: any | null;
  caption?: string | null;
}
export type VisitViewName = "_base" | "_local" | "_minimal";
export type VisitView<V extends VisitViewName> = V extends "_base"
  ? Pick<
      Visit,
      | "id"
      | "pet"
      | "date"
      | "duration"
      | "description"
      | "amount"
      | "number"
      | "endDate"
      | "caption"
    >
  : V extends "_local"
  ? Pick<
      Visit,
      | "id"
      | "date"
      | "duration"
      | "description"
      | "amount"
      | "number"
      | "endDate"
      | "caption"
    >
  : V extends "_minimal"
  ? Pick<Visit, "id" | "pet" | "date">
  : never;
