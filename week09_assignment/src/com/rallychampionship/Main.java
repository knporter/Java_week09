package com.rallychampionship;

import com.rallychampionship.manager.ChampionshipManager;
import com.rallychampionship.model.Driver;
import com.rallychampionship.model.GravelCar;
import com.rallychampionship.model.AsphaltCar;
import com.rallychampionship.service.RallyRaceResult;
import com.rallychampionship.util.ChampionshipStatistics;

public class Main {
    public static void main(String[] args) {
        // 获取 ChampionshipManager 的单例实例
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // 创建车手并分配赛车
        Driver driver1 = new Driver("Sébastien Ogier", "France", new GravelCar("Toyota", "Yaris", 380));
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", new AsphaltCar("Toyota", "Yaris", 380));
        Driver driver3 = new Driver("Ott Tänak", "Estonia", new GravelCar("Hyundai", "i20", 370));
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", new AsphaltCar("Hyundai", "i20", 370));

        // 注册车手
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        // 模拟第一场比赛
        RallyRaceResult race1 = new RallyRaceResult();
        race1.recordResult(driver1, 1); // 车手1获得第1名
        race1.recordResult(driver3, 2); // 车手3获得第2名
        race1.recordResult(driver2, 3); // 车手2获得第3名
        race1.recordResult(driver4, 4); // 车手4获得第4名
        manager.recordRaceResult(race1); // 记录比赛结果

        // 模拟第二场比赛
        RallyRaceResult race2 = new RallyRaceResult();
        race2.recordResult(driver2, 1); // 车手2获得第1名
        race2.recordResult(driver4, 2); // 车手4获得第2名
        race2.recordResult(driver1, 3); // 车手1获得第3名
        race2.recordResult(driver3, 4); // 车手3获得第4名
        manager.recordRaceResult(race2); // 记录比赛结果

        // 显示锦标赛排名
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        manager.getChampionshipStandings().forEach(driver ->
                System.out.println(driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points"));

        // 显示当前锦标赛领先者
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(manager.getLeadingDriver().getName() + " with " + manager.getLeadingDriver().getPoints() + " points");

        // 显示锦标赛统计数据
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getChampionshipStandings().size());
        System.out.println("Total Races: " + ChampionshipStatistics.countTotalRaces(manager.getRaceResults()));
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getChampionshipStandings()));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getChampionshipStandings()));
        System.out.println("Total Championship Points: " + manager.getTotalChampionshipPoints());

        // 显示赛车性能评分
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + driver1.getCar().calculatePerformance());
        System.out.println("Asphalt Car Performance: " + driver2.getCar().calculatePerformance());
    }
}