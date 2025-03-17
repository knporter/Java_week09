package com.rallychampionship.util;

import com.rallychampionship.model.Driver;
import com.rallychampionship.service.RaceResult;

import java.util.List;

public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        if (drivers.isEmpty()) {
            return 0;
        }
        return drivers.stream().mapToInt(Driver::getPoints).average().orElse(0);
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        return drivers.stream()
                .collect(java.util.stream.Collectors.groupingBy(Driver::getCountry, java.util.stream.Collectors.summingInt(Driver::getPoints)))
                .entrySet().stream()
                .max(java.util.Map.Entry.comparingByValue())
                .map(java.util.Map.Entry::getKey)
                .orElse("Unknown");
    }

    public static int countTotalRaces(List<RaceResult> raceResults) {
        return raceResults.size();
    }
}