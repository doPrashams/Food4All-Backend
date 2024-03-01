package com.project.Food4All.Service;

import com.project.Food4All.Repository.GoogleMapsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionsService {

    @Autowired
    private GoogleMapsClient googleMapsClient;

    public String getDirections(String origin, String destination, String apiKey) {
        return googleMapsClient.getDirections(origin, destination, apiKey);
    }
}
