//package com.lindeng.basketballmanager.init;
//
//import com.google.common.base.Splitter;
//import com.lindeng.basketballmanager.model.*;
//import com.lindeng.basketballmanager.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class InitData {
//
//    @Autowired
//    private AbilityRepository abilityRepository;
//
//    @Autowired
//    private ArenaRepository arenaRepository;
//
//    @Autowired
//    private ConstantRepository constantRepository;
//
//    @Autowired
//    private EventRepository eventRepository;
//
//    @Autowired
//    private EventOptionRepository eventOptionRepository;
//
//    @Autowired
//    private EventTypeRepository eventTypeRepository;
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    @Autowired
//    private PersonTypeRepository personTypeRepository;
//
//    @Autowired
//    private StatusRepository statusRepository;
//
//    @Autowired
//    private StatusTypeRepository statusTypeRepository;
//
//    @Autowired
//    private StatusAbilityEffectRepository statusAbilityEffectRepository;
//
//    @Value("${basketball.init.personType}")
//    private String personTypesInit;
//
//    @Value("${basketball.init.statusType}")
//    private String statusTypesInit;
//
//    @Value("${basketball.init.eventType}")
//    private String eventTypesInit;
//
//    @Autowired
//    private TeamRepository teamRepository;
//
//    private void initPersonType(){
//        Iterable<String> types = Splitter.on(',').trimResults().omitEmptyStrings().split(personTypesInit);
//        List<PersonType> personTypes = new ArrayList<>();
//        types.forEach(s -> {
//            PersonType personType = new PersonType(s);
//            personTypes.add(personType);
//        });
//        personTypeRepository.saveAll(personTypes);
//    }
//
//    private void initStatusType(){
//        Iterable<String> types = Splitter.on(',').trimResults().omitEmptyStrings().split(statusTypesInit);
//        List<StatusType> statusTypes = new ArrayList<>();
//        types.forEach(s -> {
//            StatusType type = new StatusType(s);
//            statusTypes.add(type);
//        });
//        statusTypeRepository.saveAll(statusTypes);
//    }
//
//    private void initEventType(){
//        Iterable<String> types = Splitter.on(',').trimResults().omitEmptyStrings().split(eventTypesInit);
//        List<EventType> eventTypes = new ArrayList<>();
//        types.forEach(s -> {
//            EventType type = new EventType(s, s);
//            eventTypes.add(type);
//        });
//        eventTypeRepository.saveAll(eventTypes);
//    }
//
//    private void initEvent(){
//        EventOption eventOption = new EventOption("确认");
//        statusTypeRepository.findAll().forEach(statusType1 -> {
//            switch (statusType1.getName()){
//                case "技能":
//
//            }
//        });
//    }
//
//
//}
