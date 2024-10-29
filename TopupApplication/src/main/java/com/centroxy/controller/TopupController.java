package com.centroxy.controller;

import com.centroxy.service.TopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

public class TopupController {

    private final TopupService service;

    @Autowired
    public TopupController(TopupService service){
        this.service=service;

    }


    public String getBalanceAndData(@RequestParam String subscriberNumber){



    }

    public String refill(@RequestParam String subscriberNumber){

    }
}
