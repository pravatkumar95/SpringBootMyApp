package com.topup.enums;

import org.springframework.http.HttpStatus;

/**
 * The Interface MerchantPaymentStatusCode will be implemented by Error and
 * Success codes.
 */
public interface ResponseCode {


	/**
	 * Gets the http status.
	 *
	 * @return the http status
	 */
	HttpStatus getStatus();

	/**
	 * Gets the name of code.
	 *
	 * @return the error code identifier
	 */
	String value();

}
