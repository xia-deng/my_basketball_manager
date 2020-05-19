//package com.lindeng.basketballmanager.init;
//
//import com.lindeng.basketballmanager.model.Arena;
//import com.lindeng.basketballmanager.model.Team;
//import com.lindeng.basketballmanager.util.NameUtil;
//import com.lindeng.basketballmanager.util.RandomUtil;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Component
//public class initTeams {
//
//    private static void initCuba() throws IOException{
//        List<String> universitys = new ArrayList<>();
//        List<Arena> arenas = new ArrayList<>();
//        ClassPathResource classPathResource = new ClassPathResource("schools");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
//        while (reader.read()>0){
//            String line = reader.readLine();
//            if(line.contains("高等") || line.contains("技术") || line.contains("职业") || line.contains("\n") || line.contains("\"") || line.contains("专科")){
//                continue;
//            }
//            if(StringUtils.isEmpty(line.trim()) || line.contains("学院")){
//                continue;
//            }
//            universitys.add(line.trim());
//
//        }
//        List<Team> teamsUniversity = new ArrayList<>();
//        List<String> used = new ArrayList<>();
//        while (teamsUniversity.size()<400){
//            String s = universitys.get(RandomUtil.nextInt(1, universitys.size()-1));
//            if(used.contains(s)){
//                continue;
//            }
//            used.add(s);
//            Team team = new Team();
//            team.setAsset(RandomUtil.nextDouble(10,30));
//            team.setCity(s);
//            team.setLevel(1);
//            team.setTeamCreated(RandomUtil.randomAgoDate());
//            team.setName(s);
//            teamsUniversity.add(team);
//        }
//        printTeamSql(teamsUniversity);
//    }
//
//    private void initFirstLevel(){
//
//    }
//
//    private void initSecondLevel(){
//
//    }
//
//    private void initScba(){}
//
//    public static void main(String[] args) throws IOException {
////        initTeamsAndArenas();
////        String replace = "test hee,fsfds sdfds,fdsfds fsdfs";
////        String removed = "fsfds sdfds";
////        System.out.println(replace.indexOf(removed));
////        if(replace.indexOf(removed) == 0){
////            replace = replace.substring(0, removed.length()+1);
////        }else {
////            System.out.println(replace.substring(0, replace.indexOf(","+removed)));
////            System.out.println(replace.substring(replace.indexOf(","+removed)));
////            replace = replace.substring(0, replace.indexOf(","+removed))+replace.substring(replace.indexOf(","+removed)+(","+removed).length());
////        }
////
////        System.out.println(replace);
//
//        final String regex = "\\$\\{\\w+\\}";
//        final String string = "www.${abc}.${123}.${567}.com";
//
//        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
//        final Matcher matcher = pattern.matcher(string);
//        System.out.println(matcher.find());
//        while (matcher.find()) {
//            System.out.println("完整匹配: " + matcher.group(0));
//            for (int i = 1; i <= matcher.groupCount(); i++) {
//                System.out.println("组 " + i + ": " + matcher.group(i));
//            }
//        }
//    }
//
//    private static void initPosition(){
//        String positionSql ="INSERT INTO position (main_position, name)VALUES ('main_position', '<name>');";
//
//    }
//
//    private static void initTeamsAndArenas() throws IOException{
//        ClassPathResource classPathResource = new ClassPathResource("provinces_teams");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
//        Map<String, List<String>> stringListMap = new HashMap<>();
//        String line = null;
//        List<String> cities = null;
//        while (reader.read()>0){
//            line = reader.readLine();
//            String[] strs = line.split("=");
//            cities = new ArrayList<>();
//            if(strs.length>1){
//                cities.addAll(Arrays.asList(strs[1].trim().split(",")));
//            }
//            stringListMap.put(strs[0], cities);
//        }
//        List<Arena> arenas = new ArrayList<>();
//        List<String> cityList = new ArrayList<>();
//        //随机球馆
//        final int[] i = {1};
//        stringListMap.forEach((province, strings) -> {
//            strings.forEach(city -> {
//                i[0]++;
//                cityList.add(city);
//                Arena arena = new Arena();
//                arena.setId(i[0]);
//                arena.setArenaStatus("租赁");
//                arena.setCenterAirCondition(new Random().nextBoolean());
//                arena.setCenterTV(new Random().nextBoolean());
//                arena.setCity(city);
//                arena.setConvenience(RandomUtil.nextDouble(50.00, 90.00));
//                arena.setProvince(province);
//                arena.setName(arena.getCity()+"体育馆");
//                arena.setCountry("中国");
//                arena.setTrainingCenter(new Random().nextBoolean());
//                arena.setLockerRoom(new Random().nextBoolean());
//                arena.setVisitorsLockerRoom(new Random().nextBoolean());
//                arena.setLevel(level(arena.isCenterAirCondition(), arena.isCenterTV(),arena.isLockerRoom(),arena.isTrainingCenter(),arena.isVisitorsLockerRoom()));
//                arena.setSeats((int)(1000*(1.9*arena.getLevel())));
//                arena.setTicket(RandomUtil.nextInt(50,100) * (0.8*arena.getLevel()));
//                arena.setRent(arena.getTicket()*arena.getSeats()*RandomUtil.nextDouble(0.01,0.2));
//                arenas.add(arena);
//            });
//        });
//
////        System.out.println(arenas);
//        printArenaSql(arenas);
//        //随机二级联赛
//        List<Team> teamsNBL = new ArrayList<>();
//        for(String city : cityList){
//            Team team = new Team();
//            team.setAsset(RandomUtil.nextDouble(10,100));
//            team.setCity(city);
//            team.setLevel(2);
//            team.setTeamCreated(RandomUtil.randomAgoDate());
//            if(city.contains("市")) {
//                team.setName(city.substring(0, city.lastIndexOf("市")) + NameUtil.randomTeamName());
//            } else {
//                team.setName(city+NameUtil.randomTeamName());
//            }
//            teamsNBL.add(team);
//        }
//        while (teamsNBL.size()<64){
//            String city = cityList.get(RandomUtil.nextInt(1, cityList.size()-2));
//            Team team = new Team();
//            team.setAsset(RandomUtil.nextDouble(10,100));
//            team.setCity(city);
//            team.setLevel(2);
//            team.setTeamCreated(RandomUtil.randomAgoDate());
//            if(city.contains("市")) {
//                team.setName(city.substring(0, city.lastIndexOf("市")) + NameUtil.randomTeamName());
//            } else {
//                team.setName(city+NameUtil.randomTeamName());
//            }
//            teamsNBL.add(team);
//        }
//        printTeamSql(teamsNBL);
//
//        //随机CBA
//        List<Team> tesmsCBA = new ArrayList<>();
//        List<String> usedCity = new ArrayList<>();
//        stringListMap.forEach((s, strings) -> {
//            String city = strings.get(RandomUtil.nextInt(0, strings.size()-1));
//            usedCity.add(city);
//            Team team = new Team();
//            team.setAsset(RandomUtil.nextDouble(100,500));
//            team.setCity(city);
//            team.setLevel(3);
//            team.setTeamCreated(RandomUtil.randomAgoDate());
//            if(city.contains("市")) {
//                team.setName(city.substring(0, city.lastIndexOf("市")) + NameUtil.randomTeamName());
//            } else {
//                team.setName(city+NameUtil.randomTeamName());
//            }
//            tesmsCBA.add(team);
//        });
//        printTeamSql(tesmsCBA);
//
//        //随机SCBA
//        List<Team> tesmsSCBA = new ArrayList<>();
//        stringListMap.forEach((s, strings) -> {
//            if(strings.size()>=2 && RandomUtil.nextInt(1, 13) % 2 == 0){
//                strings.remove(usedCity.retainAll(strings));
//            }
//            String city = strings.get(RandomUtil.nextInt(0, strings.size()-1));
//
//            Team team = new Team();
//            team.setAsset(RandomUtil.nextDouble(600,1200));
//            team.setCity(city);
//            team.setLevel(4);
//            team.setTeamCreated(RandomUtil.randomAgoDate());
//            if(city.contains("市")) {
//                team.setName(city.substring(0, city.lastIndexOf("市")) + NameUtil.randomTeamName());
//            } else {
//                team.setName(city+NameUtil.randomTeamName());
//            }
//            tesmsSCBA.add(team);
//        });
//        printTeamSql(tesmsSCBA);
//    }
//
//    private Random ran = new Random();
//    private final static int delta = 0x9fa5 - 0x4e00 + 1;
//
//    public char getRandomHan() {
//        return (char)(0x4e00 + ran.nextInt(delta));
//    }
//
//    private static int level(boolean...booleans){
//        int level = 1;
//        for (int i = 0; i < booleans.length; i++) {
//            level+=booleans[i] ? 1 : 0;
//        }
//        return level;
//    }
//
//    private static void printTeamSql(List<Team> teams){
//        String teamsSql = "insert into team (asset,city,level,name,province,team_created,team_logo,arena,team_league) VALUES (<asset>,'<city>',<level>,'<name>','<province>',<team_created>,'<logo>',null,<legaue>);";
//        teams.forEach(team -> {
//            String temp = teamsSql;
//            String result = temp.replace("<asset>", String.valueOf(team.getAsset())).replace("<city>", team.getCity()).replace("<level>", String.valueOf(team.getLevel()))
//                    .replace("<name>", team.getName()).replace("<team_created>", String.valueOf(team.getTeamCreated())).replace("<logo>", team.getName())
//                    .replace("<legaue>", String.valueOf(team.getLevel()));
//            System.out.println(result);
//        });
//    }
//
//    private static void printArenaSql(List<Arena> arenas){
//        String arenaSql = "INSERT INTO arena (arena_status,center_air_condition,center_tv,city,convenience,country,level,locker_room,name,province,rent,seats,shot_country_code,training_center,visitor_locker_room,ticket)VALUES ('<arena_status>',<center_air_condition>,<center_tv>,'<city>',<convenience>,'<country>',<level>,<locker_room>,'<name>','<province>',<rent>,<seats>,'<shot_country_code>',<training_center>,<visitor_locker_room>,<ticket>);";
//        arenas.forEach(arena -> {
//            String temp = arenaSql;
//            String result = temp.replace("<arena_status>", arena.getArenaStatus()).replace("<center_air_condition>", String.valueOf(arena.isCenterAirCondition())).replace("<center_tv>", String.valueOf(arena.isCenterTV()))
//                    .replace("<city>", arena.getCity()).replace("<convenience>", String.valueOf(arena.getConvenience())).replace("<country>", arena.getCountry()).replace("<level>", String.valueOf(arena.getLevel()))
//                    .replace("<locker_room>", String.valueOf(arena.isLockerRoom())).replace("<name>", arena.getName()).replace("<province>", arena.getProvince()).replace("<rent>",String.valueOf(arena.getRent()))
//                    .replace("<seats>", String.valueOf(arena.getSeats())).replace("<training_center>", String.valueOf(arena.isTrainingCenter())).replace("<visitor_locker_room>", String.valueOf(arena.isVisitorsLockerRoom()))
//                    .replace("<ticket>",String.valueOf(arena.getTicket()));
//            System.out.println(result);
//        });
//    }
//}
