package com.topup.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * a generic response dto for endpoints
 *
 * @param <T> the type parameter
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class ResponseDTO<T> {

    /**
     * the response metadata
     */
    private Meta meta;

    /**
     * the response recieved
     */
	private T data;

	/**
	 * The Errors.
	 */
	List<Error> errors;

	/**
	 * Instantiates a new Response dto.
	 *
	 * @param meta the meta
	 */
	public ResponseDTO(Meta meta) {
        this.meta = meta;
    }

	public ResponseDTO(Meta meta, List<Error> errors) {
		this.meta = meta;
		this.errors = errors;
	}
}
