package com.rallychampionship.service;

import com.rallychampionship.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class RallyRaceResult implements RaceResult {
    private List<Driver> results;

    public RallyRaceResult() {
        results = new ArrayList<>();
    }

    @Override
    public void recordResult(Driver driver, int position) {
        driver.addPoints(calculatePoints(position));
        results.add(driver);
    }

    @Override
    public List<Driver> getRaceResults() {
        return results;
    }

    private int calculatePoints(int position) {
        switch (position) {
            case 1: return 25;
            case 2: return 18;
            case 3: return 15;
            case 4: return 12;
            default: return 0;
        }
    }
}