package com.perfomatix.atomcore.model.db;

import java.util.List;

import org.springframework.data.annotation.Id;

public class MasterAnalyticsData {

	@Id
	private String Id;
	private String trackingId;
	private List <AnalyticsDataModelDb> analyticsData;
	public String getTrackingId() {
		return trackingId;
	}
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}
	public List <AnalyticsDataModelDb> getAnalyticsData() {
		return analyticsData;
	}
	public void setAnalyticsData(List <AnalyticsDataModelDb> analyticsData) {
		this.analyticsData = analyticsData;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
}
