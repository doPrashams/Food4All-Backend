package com.project.Food4All.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Hotspot")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotspot {

    @Id
    private String hotspotID;
    private Integer hotspotSize;
    private String hotspotCity;
    private String hotspotLat;
    private String hotspotLng;
    private String hotspotName;
    private String hotspotAddress;
}
