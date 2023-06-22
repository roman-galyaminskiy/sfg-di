package com.romangalyminskiy.sfgdi.config;

import com.romangalyminskiy.sfgdi.PetServiceFactory;
import com.romangalyminskiy.sfgdi.repositories.EnglishGreetingRepository;
import com.romangalyminskiy.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.romangalyminskiy.sfgdi.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Configuration
public class GreetingServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory() {
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory) {
        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository() {
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository repository) {
        return new I18nEnglishGreetingService(repository);
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18SpanishGreetingService i18NSpanishService() {
        return new I18SpanishGreetingService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService() {
        return new PrimaryGreetingService();
    }

    @Bean
    ConstructorInjectedGreetingServiceImpl constructorInjectedGreetingServiceImpl() {
        return new ConstructorInjectedGreetingServiceImpl();
    }
}
