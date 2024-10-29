package com.topup.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopupPayment {

    private String mobileNo;
    private String areaCode;
    private String amount;
}
