package com.krystal.assignment.persistence.repository;

import com.krystal.assignment.persistence.entity.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RandomNumberRepository extends JpaRepository<RandomNumber,Long> {


    @Query(value = "SELECT * FROM randomnumber WHERE time  >= ?1", nativeQuery = true)
    List<RandomNumber> findByTime(Long startTime);
}
