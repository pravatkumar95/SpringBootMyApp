package com.topup.model;

import lombok.*;
import org.springframework.data.aerospike.annotation.Indexed;
import org.springframework.data.aerospike.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "topup-details")
public class Topup {
    @Id
    private Double mrp;
    private String displayName;
    private String description;
    private Integer validity;
    private Double  credit;
    private Boolean isRoaming;



}
