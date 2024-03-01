package com.project.Food4All.Controller;

import com.project.Food4All.Model.Hotspot;
import com.project.Food4All.Model.Users;
import com.project.Food4All.Service.HotspotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/hotspot")
public class HotspotController {

    @Autowired
    HotspotService hotspotService;

    //Creates the hotspot
    @PostMapping("/addHotspot")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Hotspot> createHotspot(@RequestBody Hotspot hotspot){
        return new ResponseEntity<Hotspot>(hotspotService.addHotspot(hotspot),HttpStatus.CREATED);
    }

    @GetMapping("/fetchAllHotspots")
    public List<Hotspot> findAllHotspots(){
        return new ArrayList<Hotspot>(hotspotService.getAllHotspots());
    }

    @GetMapping("/count")
    public long getMaxCount(){
        return hotspotService.findTheCount();
    }

    @DeleteMapping("/{id}")
    public void deleteHotspot(@PathVariable String id){
        hotspotService.removeHotspot(id);
    }

}
