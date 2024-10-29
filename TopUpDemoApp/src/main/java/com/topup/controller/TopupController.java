package com.topup.controller;

import com.topup.enums.PMErrorCodes;
import com.topup.model.*;
import com.topup.service.TopupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.topup.utils.ResultCode.*;
import static com.topup.utils.TopupApiConstants.*;
import static com.topup.utils.Util.getSuccessMeta;

@RestController
@Tag(name = "Tutorial", description = "Tutorial management APIs")
@Slf4j
public class TopupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopupController.class);
    private final TopupService service;
    private StopWatch stopWatch;

    @Autowired
    public TopupController(TopupService service) {
        this.service = service;
    }

//    @GetMapping(value=TOPUP_LIST)
//    public ResponseEntity<?> getTopUpList(){
//          List<Topup> topUps = service.getAvailableTopUpList();
//       return new ResponseEntity<>(topUps,HttpStatus.OK);
//    }


    @GetMapping("/getTopup/{msisdn}")
    public List<TopupDetails> getTopUpDetails(@PathVariable String msisdn){

       return service.getAvailableTopUp(msisdn);

    }


    @PostMapping(value=PERSIST_PRODUCT_CTS)
    @Operation(summary = "To persist products", description = "To persist products", tags = {"Topup"})
    @ApiResponses(value = {})
    public ResponseEntity<?>  persistProductCTS(){

        stopWatch = new StopWatch();
        stopWatch.start();
        LOGGER.info("TopupController: persistProductCTS: initiated at: {}", LocalDateTime.now());
        LOGGER.info("TopupController:persistProductCTS:Init...");
        service.persistProductCTS();
        var meta = getSuccessMeta(AM_CTS_001_CODE,getResponseMessage(AM_CTS_001_CODE));
        var responseDTO = new ResponseDTO(meta, AM_CTS_001_CODE, null);
        LOGGER.info("TopupController:persistProductCTS:end...");
        stopWatch.stop();
        LOGGER.info("TopupController: persistProductCTS: takes: {} milli seconds",stopWatch.getTotalTimeSeconds());
        return new ResponseEntity<>(responseDTO, PMErrorCodes.valueOf(AM_CTS_001_CODE).getStatus());
    }


    @GetMapping(value=TOPUP_LIST)
    @Operation(summary = "To fetch Topup List", description = "To fetch Topup List", tags = {"Topup"})
    @ApiResponses(value = {})
    public ResponseEntity<?> fetchTopUpList(){

        stopWatch = new StopWatch();
        stopWatch.start();
        LOGGER.info("TopupController: fetchTopupList: initiated at: {}", LocalDateTime.now());
        LOGGER.info("TopupController:fetchTopupList:Init...");
        List<TopupDetails> topups=service.fetchTopUpDetails();
        var meta = getSuccessMeta(AM_CTS_002_CODE,getResponseMessage(AM_CTS_002_CODE));
        var responseDTO = new ResponseDTO(meta,topups,null);
        LOGGER.info("TopupController:fetchTopupList:end...");
        stopWatch.stop();
        LOGGER.info("TopupController: fetchTopupList: takes: {} milli seconds",stopWatch.getTotalTimeSeconds());
        return new ResponseEntity<>(responseDTO, PMErrorCodes.valueOf(AM_CTS_002_CODE).getStatus());

    }

    @GetMapping(value=SERVICE_PLAN)
    @Operation(summary = "To fetch Topup List", description = "To fetch Topup List", tags = {"Topup"})
    @ApiResponses(value = {})
    public ResponseEntity<?> fetchServicePlan(){

        stopWatch = new StopWatch();
        stopWatch.start();
        LOGGER.info("TopupController: fetchTopupList: initiated at: {}", LocalDateTime.now());
        LOGGER.info("TopupController:fetchTopupList:Init...");
        List<ServicePlan> topups=service.fetchServicePlan();
        var meta = getSuccessMeta(AM_CTS_002_CODE,getResponseMessage(AM_CTS_002_CODE));
        var responseDTO = new ResponseDTO(meta,topups,null);
        LOGGER.info("TopupController:fetchTopupList:end...");
        stopWatch.stop();
        LOGGER.info("TopupController: fetchTopupList: takes: {} milli seconds",stopWatch.getTotalTimeSeconds());
        return new ResponseEntity<>(responseDTO, PMErrorCodes.valueOf(AM_CTS_002_CODE).getStatus());

    }





//    @GetMapping(value=FETCH_TOPUP)
//    public ResponseEntity<?>  findAllTopUps(){
//
//        List<Topup> topups=service.fetchAllTopUp();
//        return new ResponseEntity<>(topups,HttpStatus.OK);
//    }
//
//    @GetMapping("/getByTopup")
//    public List<Topup> getByID(){
//
//       return service.findByDisplayNames("£9.5 - Island Plan - no credit");
//    }
//
//    @GetMapping("/getByDisplayName")
//    public List<Topup> getByDisplayName(){
//
//        return service.findByDisplayNameAndValidityInTopup("£19.99 - 7 days Holiday Bolt ON - no Credit",7);
//    }
//
//    @GetMapping("/getByCondition")
//    public List<Transaction> getByDisplayNames(){
//
//        List<Transaction> listTransaction= service.getTransaction();
//
//        return listTransaction.stream()
//                .filter(trans -> trans.getCreatedAt() >= 12345 && trans.getCreatedAt() < 56789 && trans.getCapPostStatus()==true && trans.getPaymentAccepted()==true)
//                .collect(Collectors.toList());
//
//
//
//    }



}
