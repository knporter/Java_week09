package com.rallychampionship.service;

import com.rallychampionship.model.Driver;

import java.util.List;

public interface RaceResult {
    void recordResult(Driver driver, int position);
    List<Driver> getRaceResults();
}