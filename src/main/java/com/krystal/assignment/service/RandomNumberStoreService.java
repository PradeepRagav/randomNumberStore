package com.krystal.assignment.service;

import com.krystal.assignment.model.RandomNumberStoreResponse;
import com.krystal.assignment.persistence.entity.RandomNumber;
import com.krystal.assignment.persistence.repository.RandomNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RandomNumberStoreService {

    @Autowired
    private RandomNumberRepository randomNumberRepository;


    private static final Long FIVE_MINS = 5 * 60 * 1000L;
    private static final Long TEN_MINS = 10 * 60 * 1000L;
    private static final Long THIRTY_MINS = 30 * 60* 1000L;

    public RandomNumberStoreResponse processRandomNumber(List<Long> numbers){

        Long time = System.currentTimeMillis();
        System.out.println(time);
        List<RandomNumber> randomNumbers = new ArrayList<>();
        numbers.stream().forEach(number -> {
            RandomNumber randomNumber = new RandomNumber();
            randomNumber.setNumber(number);
            randomNumber.setTime(time);
            randomNumbers.add(randomNumber);
        });

        randomNumberRepository.saveAll(randomNumbers);


        Long thirtyTime = time - THIRTY_MINS;
        Long tenTime = time - TEN_MINS;
        Long fiveTime = time - FIVE_MINS;


        List<RandomNumber> byTime = randomNumberRepository.findByTime(thirtyTime);
        RandomNumberStoreResponse randomNumberStoreResponse = new RandomNumberStoreResponse();
        List<Long> thirty = new ArrayList<>();
        List<Long> ten = new ArrayList<>();
        List<Long> five = new ArrayList<>();


        byTime.stream().forEach(randomNumberDb -> {

            if(randomNumberDb.getTime() >= fiveTime){
                five.add(randomNumberDb.getNumber());
                ten.add(randomNumberDb.getNumber());
            }else if(randomNumberDb.getTime() >= tenTime){
                ten.add(randomNumberDb.getNumber());
            }
            thirty.add(randomNumberDb.getNumber());
        });
        randomNumberStoreResponse.setLastThirtyMinutesNumbers(thirty);
        randomNumberStoreResponse.setLastFiveMinutesNumbers(five);
        randomNumberStoreResponse.setLastTenMinutesNumbers(ten);

        return randomNumberStoreResponse;
    }
}
