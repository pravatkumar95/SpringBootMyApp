package com.topup.serviceImpl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.topup.Exception.FileLocationNotFoundException;
import com.topup.controller.TopupController;
import com.topup.model.*;
import com.topup.repository.ProductCTSRepository;
import com.topup.repository.ServicePlanRepository;
import com.topup.repository.TopupDetailsRepository;
import com.topup.service.TopupService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.activation.UnsupportedDataTypeException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
class TopupServiceImplement implements TopupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopupServiceImplement.class);

    private final String filePath;
    private final ProductCTSRepository productCTSRepository;
    private final ServicePlanRepository servicePlanRepository;
    private final TopupDetailsRepository topupDetailsRepository;

    @Autowired
    TopupServiceImplement(@Value("${topUp.file.path}") String filePath, ProductCTSRepository productCTSRepository, ServicePlanRepository servicePlanRepository, TopupDetailsRepository topupDetailsRepository) {
        this.productCTSRepository = productCTSRepository;
        this.filePath = filePath;
        this.servicePlanRepository = servicePlanRepository;
        this.topupDetailsRepository = topupDetailsRepository;
    }


    @Override
    public List<TopupDetails> getAvailableTopUp(String msisdn) {
        String serviceid = "4677";
//        TODO: make the service Id dynamic from the IN  request

        return topupDetailsRepository.findAllByServiceId(serviceid);
    }

    @Override
    public void persistProductCTS() {
        LOGGER.info("TopupServiceImpl:persistProductCTS:Init...");

        try {
            persistTopupDetails();
            //         persistServicePlan();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("TopupServiceImpl:storeDataFromExcelToDatabase:Error reading file...");
            throw new FileLocationNotFoundException(e.getMessage());
        }
        LOGGER.info("TopupServiceImpl:storeDataFromExcelToDatabase:end...");
    }

    private void persistTopupDetails() throws IOException {
        productCTSRepository.deleteAll();
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // skip the header row
        List<TopupDetails> listofTopups = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row nextRow = rowIterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            TopupDetails topup = new TopupDetails();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int cellColumnIndex = cell.getColumnIndex();

                switch (cellColumnIndex) {
                    case 0:
                        topup.setId(Integer.parseInt(cell.getStringCellValue()));
                        break;
                    case 1:
                        topup.setServiceId(cell.getStringCellValue());
                        break;
                    case 3:
                        topup.setMrp(cell.getNumericCellValue());
                        break;
                    case 4:
                        topup.setFreebies((cell.getStringCellValue()));
                        break;
                    case 5:
                        topup.setValidity(cell.getStringCellValue());
                        break;
                    case 6:
                        if (cell.getCellType().equals(CellType.NUMERIC)){
                            topup.setCredit(cell.getNumericCellValue());
                        }else {
                            topup.setCredit(0D);
                        }
                        break;

                }
            }
            listofTopups.add(topup);
        }
        topupDetailsRepository.saveAll(listofTopups);
    }

    private void persistServicePlan() throws IOException {
        servicePlanRepository.deleteAll();
        FileInputStream inputStream = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(1);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // skip the header row
        List<ServicePlan> servicePlans = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row nextRow = rowIterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            ServicePlan servicePlan = new ServicePlan();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int cellColumnIndex = cell.getColumnIndex();
                switch (cellColumnIndex) {
                    case 0:
                        System.out.println("column ---0");
                        servicePlan.setServiceID(String.valueOf(cell.getNumericCellValue()));
                        break;
                    case 1:
                        System.out.println("column---1");
                        servicePlan.setIsland(cell.getStringCellValue());
                        break;
                    case 2:
                        System.out.println("column---2");
                        servicePlan.setPlanName((cell.getStringCellValue()));
                        break;
                }
                if (servicePlan.getServiceID() != null && !servicePlan.getServiceID().isEmpty())
                    servicePlans.add(servicePlan);

            }

        }

        servicePlanRepository.saveAll(servicePlans);

    }


    public List<TopupDetails> fetchTopUpDetails() {
        LOGGER.info("TopupServiceImpl: fetch All Data from Aerospike Database");
        List<TopupDetails> listofTopup = new ArrayList<>();
        Iterable<TopupDetails> iterable = topupDetailsRepository.findAll();
        Iterator<TopupDetails> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            listofTopup.add(iterator.next());
        }
        LOGGER.info("TopupServiceImpl:fetch All Data From Aerospike Database:end...");
        return listofTopup;


    }

    public List<ServicePlan> fetchServicePlan() {
        LOGGER.info("TopupServiceImpl: fetch All Data from Aerospike Database");
        List<ServicePlan> listofServicePlan = new ArrayList<>();
        Iterable<ServicePlan> iterable = servicePlanRepository.findAll();
        Iterator<ServicePlan> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            listofServicePlan.add(iterator.next());
        }
        LOGGER.info("TopupServiceImpl:fetch All Data From Aerospike Database:end...");
        return listofServicePlan;


    }


//
//@Override
//public List<Topup> findByDisplayNameAndValidityInTopup(String displayName, Integer validity) {
//
//    return productCTSRepository.findByDisplayNameAndValidity(displayName, validity);
//}

    @Override
    public List<Transaction> getTransaction() {

        String filePaths = "static/transaction.json";

        try (InputStream inputStream = new ClassPathResource(filePaths).getInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(inputStream, new TypeReference<List<Transaction>>() {
            });

        } catch (IOException e) {

            throw new FileLocationNotFoundException(e.getMessage());

        }
    }
}


