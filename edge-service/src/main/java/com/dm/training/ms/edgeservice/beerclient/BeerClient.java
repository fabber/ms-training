package com.dm.training.ms.edgeservice.beerclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

import com.dm.training.ms.edgeservice.dto.Beer;

@FeignClient("beer-catalog-service")
public interface BeerClient {

    @GetMapping("/beers")
    Resources<Beer> readBeers();

}
