package com.rallychampionship.model;

public class GravelCar extends RallyCar {
    public GravelCar(String make, String model, int horsepower) {
        super(make, model, horsepower);
    }

    @Override
    public double calculatePerformance() {
        // 砂石路面赛车的性能计算逻辑
        return getHorsepower() * 0.8; // 例如，砂石路面的性能系数为 0.8
    }
}
