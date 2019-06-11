package br.com.coradini.flowable.example.config;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessOrderEngineConfiguration {


    @Bean
    ProcessEngine createStandAloneInMemProcessEngineConfiguration(){

        ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration()
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
                .setJdbcUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=1000")
                .setAsyncExecutorActivate(false)
                .buildProcessEngine();
        return processEngine;

    }
}
