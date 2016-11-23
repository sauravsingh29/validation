/*
 * 
 */
package com.rxp.apm;

import java.io.Serializable;

/**
 * The Class InputRequest.
 * @author ssing69
 */
public class InputRequest implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 688497167363552074L;
	
	/** The correlation id. */
	protected String correlationId;
	
	/** The zip code. */
	protected String zipCode;
	
	/** The service type needed. */
	protected String serviceTypeNeeded;
	
	/** The customer zip code. */
	protected String customerZipCode;
	
	/** The charge code am. */
	protected String chargeCodeAm;
	
	/** The primary amount collected. */
	protected String primaryAmountCollected;
	
	/** The reschd date. */
	protected String reschdDate;
	
	/** The reschd to time. */
	protected String reschdToTime;
	
	/**
	 * Gets the correlation id.
	 *
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}
	
	/**
	 * Sets the correlation id.
	 *
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	
	/**
	 * Gets the zip code.
	 *
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * Gets the service type needed.
	 *
	 * @return the serviceTypeNeeded
	 */
	public String getServiceTypeNeeded() {
		return serviceTypeNeeded;
	}
	
	/**
	 * Sets the service type needed.
	 *
	 * @param serviceTypeNeeded the serviceTypeNeeded to set
	 */
	public void setServiceTypeNeeded(String serviceTypeNeeded) {
		this.serviceTypeNeeded = serviceTypeNeeded;
	}
	
	/**
	 * Gets the customer zip code.
	 *
	 * @return the customerZipCode
	 */
	public String getCustomerZipCode() {
		return customerZipCode;
	}
	
	/**
	 * Sets the customer zip code.
	 *
	 * @param customerZipCode the customerZipCode to set
	 */
	public void setCustomerZipCode(String customerZipCode) {
		this.customerZipCode = customerZipCode;
	}
	
	/**
	 * Gets the charge code am.
	 *
	 * @return the chargeCodeAm
	 */
	public String getChargeCodeAm() {
		return chargeCodeAm;
	}
	
	/**
	 * Sets the charge code am.
	 *
	 * @param chargeCodeAm the chargeCodeAm to set
	 */
	public void setChargeCodeAm(String chargeCodeAm) {
		this.chargeCodeAm = chargeCodeAm;
	}
	
	/**
	 * Gets the primary amount collected.
	 *
	 * @return the primaryAmountCollected
	 */
	public String getPrimaryAmountCollected() {
		return primaryAmountCollected;
	}
	
	/**
	 * Sets the primary amount collected.
	 *
	 * @param primaryAmountCollected the primaryAmountCollected to set
	 */
	public void setPrimaryAmountCollected(String primaryAmountCollected) {
		this.primaryAmountCollected = primaryAmountCollected;
	}
	
	/**
	 * Gets the reschd date.
	 *
	 * @return the reschdDate
	 */
	public String getReschdDate() {
		return reschdDate;
	}
	
	/**
	 * Sets the reschd date.
	 *
	 * @param reschdDate the reschdDate to set
	 */
	public void setReschdDate(String reschdDate) {
		this.reschdDate = reschdDate;
	}
	
	/**
	 * Gets the reschd to time.
	 *
	 * @return the reschdToTime
	 */
	public String getReschdToTime() {
		return reschdToTime;
	}
	
	/**
	 * Sets the reschd to time.
	 *
	 * @param reschdToTime the reschdToTime to set
	 */
	public void setReschdToTime(String reschdToTime) {
		this.reschdToTime = reschdToTime;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InputRequest [correlationId=");
		builder.append(correlationId);
		builder.append(" | zipCode=");
		builder.append(zipCode);
		builder.append(" | serviceTypeNeeded=");
		builder.append(serviceTypeNeeded);
		builder.append(" | customerZipCode=");
		builder.append(customerZipCode);
		builder.append(" | chargeCodeAm=");
		builder.append(chargeCodeAm);
		builder.append(" | primaryAmountCollected=");
		builder.append(primaryAmountCollected);
		builder.append(" | reschdDate=");
		builder.append(reschdDate);
		builder.append(" | reschdToTime=");
		builder.append(reschdToTime);
		builder.append("]");
		return builder.toString();
	}
	
}
