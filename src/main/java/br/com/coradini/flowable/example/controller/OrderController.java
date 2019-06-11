package br.com.coradini.flowable.example.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/order")
public class OrderController {


    @PostMapping(value = "/new", produces = "application/json")
    public String createNewOrder(){
        return  "newOrder";

    }
}
