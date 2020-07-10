package com.krystal.assignment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class RandomNumberStoreResponse {
    private List<Long> lastFiveMinutesNumbers;
    private List<Long> lastTenMinutesNumbers;
    private List<Long> lastThirtyMinutesNumbers;
}
