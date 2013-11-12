package com.perfomatix.atomcore.model.request;

import java.util.List;

public class AnalyticsDataModelRequest {

	 
	private String apiKey;
	private String browser;
	private String clientId;
	private String custId; 
	private String device;
	private String deviceUrl;
	private String isMobile;
	private String isNewUser;
	private String isRule;
	private String online;	
	private String orgId;
	private PageDataModelRequest pageData;	
	private String reqStatus;
	private String ruleId;
	private String ruleDesc;
	private String ruleName;
	private String timeStamp;
	private String trackingId;
	private String userId;
	private String version;
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getDeviceUrl() {
		return deviceUrl;
	}
	public void setDeviceUrl(String deviceUrl) {
		this.deviceUrl = deviceUrl;
	}
	public String getIsMobile() {
		return isMobile;
	}
	public void setIsMobile(String isMobile) {
		this.isMobile = isMobile;
	}
	public String getIsNewUser() {
		return isNewUser;
	}
	public void setIsNewUser(String isNewUser) {
		this.isNewUser = isNewUser;
	}
	public String getOnline() {
		return online;
	}
	public void setOnline(String online) {
		this.online = online;
	}
	
	public String getReqStatus() {
		return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public PageDataModelRequest getPageData() {
		return pageData;
	}
	public void setPageData(PageDataModelRequest pageData) {
		this.pageData = pageData;
	}
	public String getIsRule() {
		return isRule;
	}
	public void setIsRule(String isRule) {
		this.isRule = isRule;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getRuleDesc() {
		return ruleDesc;
	}
	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}
	
	
	
	
}
