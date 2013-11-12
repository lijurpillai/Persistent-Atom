package com.perfomatix.atomcore.model.db;

public class PagedataModelDb {


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
	@Override
	public String toString() {
		return "Pagedata [browserName=" + browserName + ", cookieEnabled="
				+ cookieEnabled + ", firstVisit=" + firstVisit + ", hash="
				+ hash + ", host=" + host + ", hostname=" + hostname
				+ ", lastVisit=" + lastVisit + ", localStorageEnabled="
				+ localStorageEnabled + ", navigatorAgent=" + navigatorAgent
				+ ", navigatorVersion=" + navigatorVersion + ", params="
				+ params + ", pathname=" + pathname + ", platform=" + platform
				+ ", referrer=" + referrer + ", totalVisit=" + totalVisit
				+ ", url=" + url + "]";
	}
}
