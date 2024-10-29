package com.topup.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Meta.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meta {

	/* Code returned with the response */
	private String code;

	/* Description of the response generated */
	private String description;

	/* Status after returned after processing the request */
	private String status;

	/**
	 * Instantiates a new Meta.
	 *
	 * @param code the code
	 */
	public Meta(String code) {
		this.code = code;
	}


}
