package com.project.Food4All.Repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "googleClient", url = "https://maps.googleapis.com")
public interface GoogleMapsClient {

    @GetMapping("/maps/api/directions/json")
    String getDirections(
            @RequestParam("origin") String origin,
            @RequestParam("destination") String destination,
            @RequestParam("key") String apiKey
    );
}