package com.rxp.apm.config;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Request {

	private Object request;
	Map<String, Object> other = new HashMap<>();

	/**
	 * @return the other
	 */
	@JsonAnyGetter
	public Map<String, Object> getOther() {
		return this.other;
	}

	/**
	 * @param other
	 *            the other to set
	 */
	@JsonAnySetter
	public void setOther(String key, Object value) {
		this.other.put(key, value);
	}

	/**
	 * @return the request
	 */
	public Object getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(Object request) {
		this.request = request;
	}

}
