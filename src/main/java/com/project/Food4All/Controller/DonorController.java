package com.project.Food4All.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Food4All.Model.Donors;
import com.project.Food4All.Model.Hotspot;
import com.project.Food4All.Model.Users;
import com.project.Food4All.Service.DirectionsService;
import com.project.Food4All.Service.DonorService;
import com.project.Food4All.Service.HotspotService;
import com.project.Food4All.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static com.project.Food4All.Constants.apiKey;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/donors")
public class DonorController {

    @Autowired
    DonorService donorService;

    @Autowired
    HotspotService hotspotService;

    @Autowired
    DirectionsService directionsService;

    @Autowired
    UserService userService;

    //get user from 'donorID'
    @GetMapping("/{donorID}")
    public ResponseEntity<Donors> findUserByUserName(@PathVariable String donorID){
        return new ResponseEntity(donorService.getDonorDetails(donorID), HttpStatus.OK);
    }

    //Creates the donor
    @PostMapping("/addDonor")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Users> createDonor(@RequestBody Users user){
        return new ResponseEntity<Users>(userService.addUser(user),HttpStatus.CREATED);
    }


    @GetMapping("/getHotspotLocation")
    public ResponseEntity<Hotspot> getDirections(@RequestParam(name = "lat", required = true) String donorLat,
                                                 @RequestParam(name = "lng", required = true) String donorLng,
                                                 @RequestParam(name = "city", required = true) String city) {
        Hotspot hotspot = null;
        List<Hotspot> hotspots = hotspotService.getHostpotsByCity(city);
        HashMap<String,Double> hmap = new HashMap<>();
        hotspots.stream().forEach(System.out::println);

        //find the shortest distance or the closed hotspot from the donor location
        String distance = null;
        for(int i=0;i< hotspots.size();i++){
            Hotspot tmpHotspot = hotspots.get(i);
            String origin = Double.parseDouble(donorLat) + "," + Double.parseDouble(donorLng);
            String destination = Double.parseDouble(tmpHotspot.getHotspotLat()) + "," + Double.parseDouble(tmpHotspot.getHotspotLng());
            String jsonResponse = directionsService.getDirections(origin, destination, apiKey);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = null;
            try {
                node = mapper.readTree(jsonResponse);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            JsonNode routes = node.get("routes");
            if (routes.size() > 0) {
                JsonNode legs = routes.get(0).get("legs");
                 distance = legs.get(0).get("distance").get("text").toString().split(" ")[0].substring(1);
            }


                hmap.put(tmpHotspot.getHotspotName(),Double.parseDouble(distance));
        }
//        hmap.entrySet().stream()
//                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));


        String keyWithLowestValue = hmap.entrySet().stream()
                .min((e1, e2) -> Double.compare(e1.getValue(), e2.getValue()))
                .map(Map.Entry::getKey)
                .orElse(null);

        for(int i=0;i<hotspots.size();i++){
            if(keyWithLowestValue.equals(hotspots.get(i).getHotspotName())){
                    hotspot = hotspots.get(i);
            }
        }



            return new ResponseEntity<Hotspot>(hotspot,HttpStatus.OK);
          }
}
