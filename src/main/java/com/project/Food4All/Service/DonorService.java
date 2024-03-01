package com.project.Food4All.Service;

import com.project.Food4All.Model.Donors;
import com.project.Food4All.Model.Users;
import com.project.Food4All.Repository.DonorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService {

    @Autowired
    private DonorRepo donorRepo;

    public void createDonor(Users user){
        Donors dnr = new Donors();
        dnr.setUserID(user.getUserID());
        dnr.setUserName(user.getUserName());
        dnr.setUserEmail(user.getUserEmail());
        dnr.setAmountOfFood(0);
        dnr.setTimesDonated(0);
        try{
            donorRepo.save(dnr);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Donors getDonorDetails(String donorID){
        return donorRepo.findByUserID(donorID);
    }
}
