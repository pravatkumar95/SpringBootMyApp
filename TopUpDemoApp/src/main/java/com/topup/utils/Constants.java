package com.topup.utils;

public final class Constants {

    /**
     * The constant SUCCESS.
     */
    public static final String SUCCESS = "0";
    /**
     * The constant FAIL.
     */
    public static final String FAIL = "1";
    /**
     * The constant TIMEOUT.
     */
    public static final String TIMEOUT = "2";

    public static final String RATE_LIMIT_REMAINING_HEADER = "X-Rate-Limit-Remaining";
    public static final String RATE_LIMIT_RETRY_AFTER_MILLS_HEADER = "X-Rate-Limit-Retry-After-Seconds";
    public static final String RATE_LIMIT_BUCKET = "rate_limit_bucket";
    public static final String RATE_LIMIT_BUCKET_CACHE = "rate_limit_bucket-cache";

    public static final String DEV_ENVIRONMENT = "dev";
    public static final String PROD_ENVIRONMENT = "prod";
    public static final String LOCAL_ENVIRONMENT = "local";
    public static final String TEST_ENVIRONMENT = "test";
    public static final String PT_ENVIRONMENT = "pt";
    public static final String SIT_ENVIRONMENT = "sit";
    public static final String UAT_ENVIRONMENT = "uat";

    public static final String REQUEST_A_NEW_CONNECTION_URI = "/services/operations/customer-relationship-management/customer/new-connection";


    public static final String CODE= "code";
    public static final String STATUS= "status";
    public static final String DESCRIPTION= "description";
    public static final String META= "meta";
    public static final String ERRORS= "errors";

    public static final String LOB = "lob";
    public static final String SUB_LOB = "subLob";
    public static final String DOMAIN = "domain";
    public static final String CONSUMER_NAME = "consumerName";
    public static final String CONSUMER_TRANSACTION_ID = "consumerTransactionId";
    public static final String PROGRAM_NAME = "programmeName";
    public static final String ACCOUNT_NUMBER = "accountNumber";
    public static final String INVOICE_NUMBER = "invoiceNumber";
    public static final String INTERACTION_DATE = "interactionDate";
    public static final String BILLING_DATE = "billingDate";
    public static final String CIRCLE_ID = "circleId";
    public static final String ADDRESS_FLAG = "addressFlag";
    public static final String CUSTOMER_EMAIL ="email";
    public static final String TYPE ="type";
    public static final String ACCOUNT_ID = "accountId";

    public static final String CUSTOMER_MIGRATED_TO_BFW = "customerMigrated";
    public static final String MSISDN = "MSISDN";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";
    public static final String CACHE_INVOICE = "Billing_Info";
    public static final String MSISDN_TYPE= "type";
    public static final String ACCOUNT_TYPE = "accountType";

    public static final String DEFAULT_FAIL_MESSAGE = "Something went wrong, Please try again later";

    public static final String CONTENT_TYPE_JSON = "application/json";

    public static final String CLAIM_TOKEN_TYPE = "typ";
    public static final String CLAIM_DOMAIN = "domain";
    public static final String REFRESH_TOKEN = "REFRESH";
    public static final String ACCESS_TOKEN = "ACCESS";
    public static final String CLAIM_DEVICE_HASH_CODE = "deviceHashCode";
    public static final String CLAIM_APPLICATION_TYPE = "applicationType";

    public static final String CUSTOMER_SUMMARY = "customer-summary";
    public static final String WEB_CUSTOMER_SUMMARY_CACHE = "web-customer-summary-cache";
    public static final String APP_CUSTOMER_SUMMARY_CACHE = "app-customer-summary-cache";

    public static final String LOGGED_IN_USER = "logged-in-user";
    public static final String LOGGED_IN_APP_USER_CACHE = "logged-in-app-user-cache";
    public static final String LOGGED_IN_WEB_USER_CACHE = "logged-in-web-user-cache";

    public static final String SUB_LOB_IS_REQUIRED = "Sub lob is required, Kindly provide valid Sub Lob.";
    public static final String MSISDN_IS_REQUIRED = "MSISDN is required, Kindly provide valid MSISDN.";
    public static final String DOMAIN_IS_REQUIRED = "Domain is required, Kindly provide valid domain.";
    public static final String IMSI_IS_REQUIRED = "IMSI is required, Kindly provide valid IMSI.";
    public static final String APPLICATION_TYPE_IS_REQUIRED = "Application type is required, Kindly provide valid Application type.";
    public static final String OTP_IS_REQUIRED = "OTP is required, Kindly provide valid OTP.";
    public static final String CUSTOMER_CLASS_IS_REQUIRED = "Customer class is required, Kindly provide valid customer class.";
    public static final String SERVICE_ID_IS_REQUIRED = "Service id is required.";
    public static final String CUSTOMER_ID_IS_REQUIRED = "Customer id is required.";
    public static final String CIRCLE_ID_IS_REQUIRED = "circle id is required, Kindly provide valid circle id.";
    public static final String CIRCLE_IS_REQUIRED = "circle is required, Kindly provide valid circle.";
    public static final String ALTERNATE_NUMBER_IS_REQUIRED = "Alternate number is required.";
    public static final String COUNTRY_CODE_IS_REQUIRED = "Country code is required.";
    public static final String EMAIL_ADDRESS_IS_REQUIRED = "Email address is required.";
    public static final String PROMOTION_ID_IS_REQUIRED = "Promotion id is required.";
    public static final String ACCOUNT_NUMBER_IS_REQUIRED = "Account number is required, Kindly provide valid account number.";
    public static final String AREA_CODE_IS_REQUIRED = "Area code is required, kindly provide valid area code.";


    public static final String TO_MANY_REQUEST_TRIGGERED_ERROR_MESSAGE = "To many request triggered, Please try again later. ";
    public static final String TO_MANY_REQUEST_TRIGGERED_ERROR_CODE = "TO_MANY_REQUEST";
    public static final String INVALID_REQUEST_TRIGGERED_ERROR_MESSAGE = "Invalid request triggered, Please try again. ";
    public static final String INVALID_REQUEST_TRIGGERED_ERROR_CODE = "INVALID_REQUEST";

    public static final String SERVICES_IS_REQUIRED = "Services is required.";
    public static final String TRANSACTION_IS_REQUIRED = "Transaction is required.";
    public static final String INVOICE_NUMBER_IS_REQUIRED = "Invoice number is required.";
    public static final String PAYMENT_MODE_IS_REQUIRED = "Payment mode is required.";


}
