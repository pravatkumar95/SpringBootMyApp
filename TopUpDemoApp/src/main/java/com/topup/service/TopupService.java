package com.topup.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topup.model.ServicePlan;
import com.topup.model.Topup;
import com.topup.model.TopupDetails;
import com.topup.model.Transaction;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public interface TopupService {

     void  persistProductCTS();
     //void persistServicePlan();
     List<TopupDetails> fetchTopUpDetails();
     List<ServicePlan> fetchServicePlan();

     List<TopupDetails> getAvailableTopUp(String msisdn);



     //List<Topup>  findByDisplayNames(String displayName);

    // List<Topup> findByDisplayNameAndValidityInTopup(String displayName,Integer validity);


     List<Transaction>  getTransaction();
     //public void persistServicePlan() throws IOException;


}