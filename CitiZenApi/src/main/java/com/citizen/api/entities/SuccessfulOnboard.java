package com.citizen.api.entities;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SuccessfulOnboard {

	private String applicationId;
	private String applicationStage;
	private String controlFlowId;

	/**
	 * 
	 * @return
	 * The applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}

	/**
	 * 
	 * @param applicationId
	 * The applicationId
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	/**
	 * 
	 * @return
	 * The applicationStage
	 */
	public String getApplicationStage() {
		return applicationStage;
	}

	/**
	 * 
	 * @param applicationStage
	 * The applicationStage
	 */
	public void setApplicationStage(String applicationStage) {
		this.applicationStage = applicationStage;
	}

	/**
	 * 
	 * @return
	 * The controlFlowId
	 */
	public String getControlFlowId() {
		return controlFlowId;
	}

	/**
	 * 
	 * @param controlFlowId
	 * The controlFlowId
	 */
	public void setControlFlowId(String controlFlowId) {
		this.controlFlowId = controlFlowId;
	}

}