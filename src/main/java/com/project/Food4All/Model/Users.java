package com.project.Food4All.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {

    @Id
    private String userID;
    private String userName;
    private String userEmail;
    private String userPwd;
    private String userRole;
    private String userCity;
    private String userPhone;
}
