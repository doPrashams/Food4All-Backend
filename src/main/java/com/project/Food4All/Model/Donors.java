package com.project.Food4All.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Donors")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Donors {

    @Id
    private String userID;
    private String userEmail;
    private String userName;
    private Integer timesDonated;
    private Integer amountOfFood;
}
