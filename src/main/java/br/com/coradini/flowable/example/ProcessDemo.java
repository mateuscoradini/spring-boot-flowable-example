package br.com.coradini.flowable.example;

import lombok.extern.log4j.Log4j2;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class ProcessDemo {








    @EventListener(ApplicationReadyEvent.class)
    public void enrollNewOrder() throws Exception {

    }



}