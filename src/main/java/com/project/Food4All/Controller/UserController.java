package com.project.Food4All.Controller;

import com.project.Food4All.Model.Users;
import com.project.Food4All.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;


    //Creates the user
    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Users> createUser(@RequestBody Users user){
        return new ResponseEntity<Users>(userService.addUser(user),HttpStatus.CREATED);

    }

    //get all the users
    @GetMapping
    public List<Users> getAllUsers(){
        return userService.findAllUsers();
    }

    //get user from 'userEmail'
    @GetMapping("/{userEmail}")
    public ResponseEntity<Users> findUserByUserName(@PathVariable String userEmail){
        return new ResponseEntity(userService.getUserByUserEmail(userEmail), HttpStatus.OK);
    }

    //update user credentials 'userName' and 'userPwd'
    @PutMapping
    public Users updateUser(@RequestBody Users user){
        return userService.editUser(user);
    }

    //delete the user
    @DeleteMapping("/{userID}")
    public void deleteUserByUserMail(@PathVariable String userID){
         userService.removeUser(userID);
    }
}
