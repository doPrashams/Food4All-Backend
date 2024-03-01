package com.project.Food4All.Repository;

import com.project.Food4All.Model.Hotspot;
import com.project.Food4All.Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HotspotRepo extends MongoRepository<Hotspot,String>  {
    @Query("{ 'hotspotCity': ?0 }")
    List<Hotspot> findByHotspotCity(String city);


}
