package com.company.petclininc.portal.rest;

import com.company.petclininc.entity.Consumable;
import com.company.petclininc.service.VisitService;
import com.haulmont.cuba.core.app.serialization.EntitySerializationAPI;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VisitRestController {

    @Inject
    private VisitService visitService;

    @GetMapping(value = "consumables/used", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ConsumableDto> getUsedConsumables() {
        return visitService.getUsedConsumables().stream().map(ConsumableDto::new).collect(Collectors.toList());
    }

}