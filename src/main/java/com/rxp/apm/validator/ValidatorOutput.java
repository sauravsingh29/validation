/*
 * 
 */
package com.rxp.apm.validator;

import com.rxp.apm.response.BaseResponse;

/**
 * The Class ValidatorOutput.
 * 
 * @author ssing69
 */
public class ValidatorOutput extends BaseResponse{

	/** The valid. */
	private boolean valid = true;

	/**
	 * Checks if is valid.
	 *
	 * @return the valid
	 */
	public boolean isValid() {
		if (!getMessages().isEmpty()) {
			setValid(false);
		}
		return valid;
	}

	/**
	 * Sets the valid.
	 *
	 * @param valid  the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ValidatorOutput [valid=");
		builder.append(valid);
		builder.append(" | responseCode=");
		builder.append(responseCode);
		builder.append(" | responseMessage=");
		builder.append(responseMessage);
		builder.append(" | messages=");
		builder.append(messages);
		builder.append("]");
		return builder.toString();
	}

}