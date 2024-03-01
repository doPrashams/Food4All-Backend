package com.project.Food4All.Repository;

import com.project.Food4All.Model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<Users,String> {

    Users findByUserEmail(String userName);
    void deleteByUserEmail(String userEmail);
}
