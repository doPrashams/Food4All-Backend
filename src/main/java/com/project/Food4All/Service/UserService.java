package com.project.Food4All.Service;

import com.project.Food4All.Constants;
import com.project.Food4All.Model.Users;
import com.project.Food4All.Repository.DonorRepo;
import com.project.Food4All.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DonorService donorService;


    //to save the user to the DB
    public Users addUser(Users user){
        user.setUserRole(Constants.DONOR);
        Users usr = userRepo.save(user);
        donorService.createDonor(usr);
        return usr;
    }

    //find all the users
    public List<Users> findAllUsers() {

        return userRepo.findAll().stream()
                .filter(user -> !user.getUserID().equals("65d2b3bd1385cf5498538d06"))
                .collect(Collectors.toList());
    }

    //get user by 'userName'
    public Users getUserByUserEmail(String userEmail){
        return userRepo.findByUserEmail(userEmail);
    }

    //update 'userName' and 'userPwd'
    public Users editUser(Users user){
        Users usr = userRepo.findByUserEmail(user.getUserEmail());
        usr.setUserName(user.getUserEmail());
        usr.setUserPwd(user.getUserPwd());
        return userRepo.save(usr);
    }

    //delete the user
    public void removeUser(String userID){
        userRepo.deleteByUserEmail(userID);
    }
}
