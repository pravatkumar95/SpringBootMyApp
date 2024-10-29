package com.topup.model;

import lombok.Data;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
@Data
public class DemoTopUp {
    @Id
    public String mobileNo;
    public String areaCode;
    public String amount;

}
