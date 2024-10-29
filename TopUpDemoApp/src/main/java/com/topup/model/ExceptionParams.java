package com.topup.model;

import com.topup.enums.ResponseCode;

import java.util.Arrays;

/**
 * The Class ExceptionParam contains properties of org.av.core.platform.exception encountered.
 */
public class ExceptionParams {

	/** The status code. */
	private ResponseCode code;

	/** The status. */
	private String status;

	/** The reason. */
	private String reason;

	/** The args. */
	private String[] args;

	/** The description. */
	private String description;

	/**
	 * Instantiates a new org.av.core.platform.exception params.
	 *
	 * @param responseCode the status code
	 *//*
	public ExceptionParams(ResponseCode responseCode) {
		super();
		code = responseCode;
		this.status = Status.FAILURE;
		this.reason = Constants.FAILURE_MESSAGE;
	}*/

	/**
	 * Instantiates a new org.av.core.platform.exception params.
	 *
	 * @param responseCode the status code
	 * @param status       the status
	 * @param reason       the reason
	 */
	public ExceptionParams(ResponseCode responseCode, String status, String reason) {
		super();
		code = responseCode;
		this.status = status;
		this.reason = reason;
	}

	/**
	 * Instantiates a new org.av.core.platform.exception params.
	 *
	 * @param responseCode the response code
	 * @param reason       the reason
	 */
	public ExceptionParams(ResponseCode responseCode, String reason) {
		super();
		code = responseCode;
		this.reason = reason;
	}

	/**
	 * Instantiates a new org.av.core.platform.exception params.
	 *
	 * @param reason the reason
	 */
	public ExceptionParams(String reason) {
		super();
		this.description = "Failure";
		this.reason = reason;
	}

	/**
	 * This method will set arguments to the current object.
	 *
	 * @param args the args
	 *
	 * @return the org.av.core.platform.exception params
	 */
	public ExceptionParams arguments(String... args) {
		if (args != null) {
			this.args = Arrays.copyOf(args, args.length);
		} else {
			this.args = new String[0];
		}
		return this;
	}

	/**
	 * Instantiates a new Exception params.
	 *
	 * @param responseCode the response code
	 * @param status       the status
	 * @param reason       the reason
	 * @param description  the description
	 */
	public ExceptionParams(ResponseCode responseCode, String status, String reason, String description) {
		super();
		code = responseCode;
		this.status = status;
		this.reason = reason;
		this.description = description;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public ResponseCode getCode() {
		return code;
	}

	/**
	 * Gets the args.
	 *
	 * @return the args
	 */
	public String[] getArgs() {
		return args;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Gets the reason.
	 *
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
