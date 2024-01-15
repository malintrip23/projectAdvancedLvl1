package com.example.advancedworking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CarRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Car(1,"Audi",2023,false,UsageT.SUPERCAR,"RS7")));
            log.info("Preloading " + repository.save(new Car(2,"Bmw",2022,true,UsageT.DRIFT,"M5CS")));
        };
    }
}