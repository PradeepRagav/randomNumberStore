package com.krystal.assignment.rest;

import com.krystal.assignment.model.RandomNumberStoreRequest;
import com.krystal.assignment.model.RandomNumberStoreResponse;
import com.krystal.assignment.service.RandomNumberStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {


    @Autowired
    private RandomNumberStoreService randomNumberStoreService;


    @PostMapping(value ="/randomNumber")
    public RandomNumberStoreResponse storeRandNumber(@RequestBody RandomNumberStoreRequest request){
        return randomNumberStoreService.processRandomNumber(request.getNumbers());
    }
}
