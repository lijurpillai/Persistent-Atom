package com.perfomatix.atomcore.model.db;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.perfomatix.atomcore.model.db.PagedataModelDb;

public class AnalyticsDataModelDb {

	
	
	private String apiKey;
	private String browser;
	private String clientId;
	private String custId; 
	private String device;
	private String deviceUrl;
	private String isMobile;
	private String isNewUser;
	private String online;	
	private String orgId;
	private String isRule;
	private String ruleName;
	private String ruleDesc;
	private String reqStatus;	
	private String timeStamp;
	private String trackingId;
	private String userId;
	private String version;
	private String browserName;
	private String cookieEnabled;
	private String firstVisit;
	private String hash;
	private String host;
	private String hostname;
	private String lastVisit;
	private String localStorageEnabled;
	private String navigatorAgent;
	private String navigatorVersion;
	private String params;
	private String pathname;
	private String platform;
	private String referrer;
	private String totalVisit;
	private String url;	
	
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
	public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getCookieEnabled() {
		return cookieEnabled;
	}
	public void setCookieEnabled(String cookieEnabled) {
		this.cookieEnabled = cookieEnabled;
	}
	public String getFirstVisit() {
		return firstVisit;
	}
	public void setFirstVisit(String firstVisit) {
		this.firstVisit = firstVisit;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(String lastVisit) {
		this.lastVisit = lastVisit;
	}
	public String getLocalStorageEnabled() {
		return localStorageEnabled;
	}
	public void setLocalStorageEnabled(String localStorageEnabled) {
		this.localStorageEnabled = localStorageEnabled;
	}
	public String getNavigatorAgent() {
		return navigatorAgent;
	}
	public void setNavigatorAgent(String navigatorAgent) {
		this.navigatorAgent = navigatorAgent;
	}
	public String getNavigatorVersion() {
		return navigatorVersion;
	}
	public void setNavigatorVersion(String navigatorVersion) {
		this.navigatorVersion = navigatorVersion;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getPathname() {
		return pathname;
	}
	public void setPathname(String pathname) {
		this.pathname = pathname;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	public String getTotalVisit() {
		return totalVisit;
	}
	public void setTotalVisit(String totalVisit) {
		this.totalVisit = totalVisit;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIsRule() {
		return isRule;
	}
	public void setIsRule(String isRule) {
		this.isRule = isRule;
	}
	public String getRuleDesc() {
		return ruleDesc;
	}
	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}	

}
