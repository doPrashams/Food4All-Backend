package com.project.Food4All.Service;

import com.project.Food4All.Constants;
import com.project.Food4All.Model.Hotspot;
import com.project.Food4All.Model.Users;
import com.project.Food4All.Repository.HotspotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class HotspotService {

    @Autowired
    HotspotRepo hotspotRepo;

    //adds hotspot
    public Hotspot addHotspot(Hotspot hotspot){

         Hotspot hs = (Hotspot) hotspotRepo.save(hotspot);
        return hs;
    }

    public List<Hotspot> getHostpotsByCity(String city) {
        return hotspotRepo.findByHotspotCity(city);
    }

    public List<Hotspot> getAllHotspots() { return hotspotRepo.findAll();}

    public long findTheCount(){ return hotspotRepo.count();}

    public Hotspot findHotspotById(String id) {
        return hotspotRepo.findById(id).orElse(null);
    }

    public void removeHotspot(String id){
        Hotspot hotspot = findHotspotById(id);
        try{
            hotspotRepo.delete(hotspot);
        }
        catch (Exception e){
            System.out.println("Exception: Hotspot issue :- Hotspot service removeHotspot()");
        }
    }
}
