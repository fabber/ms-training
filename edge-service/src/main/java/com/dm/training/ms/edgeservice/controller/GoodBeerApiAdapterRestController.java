package com.dm.training.ms.edgeservice.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dm.training.ms.edgeservice.beerclient.BeerClient;
import com.dm.training.ms.edgeservice.dto.Beer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
class GoodBeerApiAdapterRestController {

    private final BeerClient beerClient;

    public GoodBeerApiAdapterRestController(BeerClient beerClient) {
        this.beerClient = beerClient;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/good-beers")
    public Collection<Beer> goodBeers() {
        return beerClient.readBeers()
                .getContent()
                .stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    public Collection<Beer> fallback() {
        return new ArrayList<>();
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Budweiser") &&
                !beer.getName().equals("Coors Light") &&
                !beer.getName().equals("PBR");
    }

}