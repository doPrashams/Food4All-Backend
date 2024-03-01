package com.project.Food4All.Repository;

import com.project.Food4All.Model.Donors;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonorRepo extends MongoRepository<Donors,String> {

    Donors findByUserID(String donorName);
}
