package com.topup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private String transactionId;

    private String title;
    private String firstName;
    private String lastName;


    private Boolean paymentAccepted;


    /* Customer info, who does the payment. */
    private String areaCode;
    private String siNumber;

    private String accountNo;
    private String payToBillAcc;


    private String circle;
    private String domain;
    private String subLob;
    private String emailAddress;

    private String token; // NonNull if token generated successfully else its value should be null
    private boolean postBackStatus; // Ensure post back received at Bill manager
    private String postBackToken; // PG transaction ID

    private Boolean capPostStatus; // Ensure cap posting done


    private Boolean corpPaymentStatus; // Ensure top up payment completed successfully

    private String paymentPostingCode;

    private long createdAt;
    private long updatedAt;
    private String transDate;

    private String merchantId;

    private String invoiceNumber;

    private BigDecimal amount;

    private String cardNumber;

    private long version;

    /* If customer do recharge */
    private String packageName;
    private String rechargeType;
    private String rechargeCat;

    private boolean validTopUp;
    private boolean paymentEnquiryStatus; // Ensure payment post to ian successfully

    private BigDecimal balance;




    private int postBackRetrials;

    private int corpPaymentRetrials;

    private String message;
    private String  applicationType;
}
