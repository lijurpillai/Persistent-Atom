package com.perfomatix.atomcore.model.response;

public class RuleProfileModelResponse {

	private String org;
	private String orgId;
	private String ruleId;
	private String ruleName;
	private String displayName;
	private boolean isActive;
	private boolean isChatEnabled;
	private boolean isPushEnabled;
	private boolean isNotifiactionEnabled;
	private boolean isSurveyEnabled;
	
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isChatEnabled() {
		return isChatEnabled;
	}
	public void setChatEnabled(boolean isChatEnabled) {
		this.isChatEnabled = isChatEnabled;
	}
	public boolean isPushEnabled() {
		return isPushEnabled;
	}
	public void setPushEnabled(boolean isPushEnabled) {
		this.isPushEnabled = isPushEnabled;
	}
	public boolean isNotifiactionEnabled() {
		return isNotifiactionEnabled;
	}
	public void setNotifiactionEnabled(boolean isNotifiactionEnabled) {
		this.isNotifiactionEnabled = isNotifiactionEnabled;
	}
	public boolean isSurveyEnabled() {
		return isSurveyEnabled;
	}
	public void setSurveyEnabled(boolean isSurveyEnabled) {
		this.isSurveyEnabled = isSurveyEnabled;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}	
	

}
