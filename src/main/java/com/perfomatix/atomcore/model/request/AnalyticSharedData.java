package com.perfomatix.atomcore.model.request;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.perfomatix.atomcore.model.db.AnalyticsDataModelDb;

public class AnalyticSharedData {

	private static AnalyticSharedData data = null;
	private static ArrayList<String> AnalyticDataList = null;
	private static final Logger logger = Logger.getLogger(AnalyticSharedData.class);
	

	/**
	 * 
	 */
	private AnalyticSharedData() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public static synchronized AnalyticSharedData getInstance() {

		if (data == null) {
			data = new AnalyticSharedData();
			AnalyticDataList = new ArrayList<String>();
			
		}
		return data;

	}

	public ArrayList<String> getList() {
		
		ArrayList<String> newBeanList = (ArrayList<String>) AnalyticDataList.clone();
		cleanList();

		return newBeanList;

	}

	public void addList(AnalyticsDataModelDb bean) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			AnalyticDataList.add(mapper.writeValueAsString(bean));
			logger.debug("AnalyticDataList :- "+AnalyticDataList.toString() );
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cleanList() {

		AnalyticDataList = new ArrayList<String>();

	}

}
