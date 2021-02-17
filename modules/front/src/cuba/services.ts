import { CubaApp, FetchOptions } from "@cuba-platform/rest";

import { Visit } from "./entities/petclininc_Visit";

export type petclininc_VisitService_calculateAmount_params = {
  visit: Visit;
};

export var restServices = {
  petclininc_VisitService: {
    calculateAmount: (cubaApp: CubaApp, fetchOpts?: FetchOptions) => (
      params: petclininc_VisitService_calculateAmount_params
    ) => {
      return cubaApp.invokeService(
        "petclininc_VisitService",
        "calculateAmount",
        params,
        fetchOpts
      );
    },
    getUsedConsumables: (cubaApp: CubaApp, fetchOpts?: FetchOptions) => () => {
      return cubaApp.invokeService(
        "petclininc_VisitService",
        "getUsedConsumables",
        {},
        fetchOpts
      );
    }
  }
};
