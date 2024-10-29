package com.topup.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.hpsf.Decimal;
import org.luaj.vm2.ast.Str;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

import javax.annotation.processing.Generated;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "topup-details")
public class TopupDetails{

    @Id
    private Integer id;
    private String serviceId;
    private String servicePlanName;
    private Double mrp;
    private String freebies;
    private String validity;
    private Double credit;

}
