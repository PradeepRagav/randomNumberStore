package com.krystal.assignment.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "randomnumber")
@Getter
@Setter
@NoArgsConstructor
public class RandomNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "time")
    private Long time;

    @Override public String toString() {
        return "RandomNumber{" + "number=" + number + ", time=" + time + '}';
    }
}
