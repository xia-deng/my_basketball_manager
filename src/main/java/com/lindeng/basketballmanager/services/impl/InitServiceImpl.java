package com.lindeng.basketballmanager.services.impl;

import com.lindeng.basketballmanager.dto.Arena;
import com.lindeng.basketballmanager.dto.League;
import com.lindeng.basketballmanager.dto.Team;
import com.lindeng.basketballmanager.enums.ArenaStatusEnum;
import com.lindeng.basketballmanager.repository.ArenaRepository;
import com.lindeng.basketballmanager.repository.LeagueRepository;
import com.lindeng.basketballmanager.repository.TeamRepository;
import com.lindeng.basketballmanager.services.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private LeagueRepository leagueRepository;
    @Autowired
    private ArenaRepository arenaRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void init() {
        try {
            initProvinceAndCity().forEach((s, strings) -> {
                System.out.println("省份："+s+", 市："+strings);
            });
            initUniversity().forEach(s -> {
                System.out.println(s);
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InitServiceImpl initService = new InitServiceImpl();
        initService.init();
    }

    private void initArenasAndTeams(){
        try {
            initProvinceAndCity().forEach((s, strings) -> {
                System.out.println("省份："+s+", 市："+strings);
            });
            initUniversity().forEach(s -> {
                System.out.println(s);
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initLeague(){
        List<League> leagues = new ArrayList<>(10);
        "CBO,CUBA,NBL,CBA,SCBA";
        League league = new League();
        league.setDeployBonus(5000);
        league.setFmvpBonus(10000);
        league.setLevel(1);
        league.setMvpBonus(5000);
        league.setName("CUBA");
        league.setOtherBonus(3000);
        league.setRankBonus("100000,50000,20000,20000,100000");
        league.setTeamsNumber(90);
        l
    }

    private void initCuba(){
        try {
            int cubaSize = 90;
            League league = new League();
            league.setDeployBonus(5000);
            league.setFmvpBonus(10000);
            league.setLevel(1);
            league.setMvpBonus(5000);
            league.setName("CUBA");
            league.setOtherBonus(3000);
            league.setRankBonus("100000,50000,20000,20000,100000");
            league.setTeamsNumber(cubaSize);
            leagueRepository.save(league);
            List<String> allUnis = initUniversity();
            List<String> tempUnis = new ArrayList<>();
            Collections.copy(tempUnis, allUnis);
            List<Arena> arenas = new ArrayList<>(100);
            List<Team> teams = new ArrayList<>(100);
            while (cubaSize>0){
                int size = new Random().nextInt(tempUnis.size());
                String name = tempUnis.get(size);
                tempUnis.remove(size);
                Arena arena = new Arena();
                arena.setArenaStatus(ArenaStatusEnum.BOUGHT.name());
                arena.setCenterAirCondition(size/5==0?true:false);
                arena.setVisitorsLockerRoom(true);
                arena.setLevel(arena.initLevel());
                arena.setEffect(1d);
                arena.setName(name+"体育馆");
                arenas.add(arena);
                Team team = new Team();
                team.setArena(arena);
                team.setLeague(league);
                team.setName(name);
                teams.add(team);
            }
            arenaRepository.saveAll(arenas);
            teamRepository.saveAll(teams);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initOthers(){

    }

    private Map<String, List<String>> initProvinceAndCity() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("provinces_teams");
        BufferedReader reader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
        Map<String, List<String>> provinceAndCity = new HashMap<>();
        String line = null;
        List<String> cities = null;
        while (reader.read() > 0) {
            line = reader.readLine();
            String[] strs = line.split("=");
            cities = new ArrayList<>();
            if (strs.length > 1) {
                cities.addAll(Arrays.asList(strs[1].trim().split(",")));
            }
            provinceAndCity.put(strs[0], cities);
        }
        return provinceAndCity;
    }

    private List<String> initUniversity() throws IOException {
        List<String> universitys = new ArrayList<>();
        ClassPathResource classPathResource = new ClassPathResource("schools");
        BufferedReader reader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
        while (reader.read() > 0) {
            String line = reader.readLine();
            if (line.contains("高等") || line.contains("技术") || line.contains("职业") || line.contains("\n") || line.contains("\"") || line.contains("专科")) {
                continue;
            }
            universitys.add(line.trim());
        }
        return universitys;
    }
}