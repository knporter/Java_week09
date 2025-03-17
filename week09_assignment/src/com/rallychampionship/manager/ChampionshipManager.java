package com.rallychampionship.manager;

import com.rallychampionship.model.Driver;
import com.rallychampionship.service.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    // 单例实例
    private static ChampionshipManager instance;

    // 车手列表
    private List<Driver> drivers;

    // 比赛结果列表
    private List<RaceResult> raceResults;

    // 私有构造函数，确保外部无法直接实例化
    private ChampionshipManager() {
        drivers = new ArrayList<>();
        raceResults = new ArrayList<>();
    }

    // 获取单例实例的方法
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    // 注册车手
    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    // 记录比赛结果
    public void recordRaceResult(RaceResult result) {
        raceResults.add(result);
    }

    // 获取锦标赛排名
    public List<Driver> getChampionshipStandings() {
        // 按得分从高到低排序
        drivers.sort((d1, d2) -> d2.getPoints() - d1.getPoints());
        return drivers;
    }

    // 获取当前锦标赛领先者
    public Driver getLeadingDriver() {
        getChampionshipStandings(); // 确保排名是最新的
        return drivers.get(0); // 返回排名第一的车手
    }

    // 计算锦标赛总得分
    public int getTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getPoints).sum();
    }

    // 获取所有比赛结果
    public List<RaceResult> getRaceResults() {
        return raceResults;
    }
}