package com.perfomatix.atomcore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perfomatix.atomcore.model.db.AnalyticsDataModelDb;
import com.perfomatix.atomcore.model.db.MasterAnalyticsData;
import com.perfomatix.atomcore.model.request.AnalyticSharedData;
import com.perfomatix.atomcore.model.request.AnalyticsDataModelRequest;
import com.perfomatix.atomcore.model.response.ResponseMessage;
import com.perfomatix.atomcore.model.response.UserProfileModelResponse;
import com.perfomatix.atomcore.service.AnalyticsDataService;
import com.perfomatix.atomcore.util.Constants;
import com.perfomatix.atomcore.util.UtilService;

@Controller
public class AnalyticsDataController {
	
	private static final Logger logger = Logger.getLogger(AnalyticsDataController.class);
	
	@Autowired
	AnalyticsDataService analyticsDataService;
	
	@RequestMapping(value ="/analyticsData", method = RequestMethod.POST)
	public @ResponseBody
	ResponseMessage analyticsData(@RequestBody AnalyticsDataModelRequest analyticsDataModelRequest,HttpServletRequest request,
			HttpServletResponse response, HttpSession session){
		logger.debug("Inside /analyticsData" + "--"+analyticsDataModelRequest.getTrackingId()+"--"+analyticsDataModelRequest.getPageData().getBrowserName());
		logger.debug("inside AnalyticsDataController" );
		
		String orgId = null;	
		MasterAnalyticsData masterAnalyticsData = new MasterAnalyticsData();
		AnalyticsDataModelDb analyticsDataModelDb = new AnalyticsDataModelDb();
		UserProfileModelResponse userProfileModelResponse =  new UserProfileModelResponse();		
		List <AnalyticsDataModelDb> analyticsList =  new ArrayList<AnalyticsDataModelDb>();
		userProfileModelResponse = (UserProfileModelResponse) session.getAttribute(Constants.SESS_KEY_USER_PROFILE);
		if(userProfileModelResponse != null){
			orgId = userProfileModelResponse.getOrgId();
		}		
		orgId = "dshop";
		if(orgId != null && !orgId.isEmpty()){
			analyticsDataModelDb.setOrgId(orgId);
			analyticsDataModelDb.setApiKey(analyticsDataModelRequest.getApiKey());
			analyticsDataModelDb.setBrowser(analyticsDataModelRequest.getBrowser());
			analyticsDataModelDb.setBrowserName(analyticsDataModelRequest.getPageData().getBrowserName());
			analyticsDataModelDb.setClientId(analyticsDataModelRequest.getClientId());
			analyticsDataModelDb.setCookieEnabled(analyticsDataModelRequest.getPageData().getCookieEnabled());
			analyticsDataModelDb.setCustId(analyticsDataModelRequest.getCustId());
			analyticsDataModelDb.setDevice(analyticsDataModelRequest.getDevice());
			analyticsDataModelDb.setDeviceUrl(analyticsDataModelRequest.getDeviceUrl());
			analyticsDataModelDb.setFirstVisit(analyticsDataModelRequest.getPageData().getFirstVisit());
			analyticsDataModelDb.setHost(analyticsDataModelRequest.getPageData().getHost());
			analyticsDataModelDb.setHostname(analyticsDataModelRequest.getPageData().getHostname());
			analyticsDataModelDb.setIsMobile(analyticsDataModelRequest.getIsMobile());
			analyticsDataModelDb.setIsNewUser(analyticsDataModelRequest.getIsNewUser());
			analyticsDataModelDb.setLastVisit(analyticsDataModelRequest.getPageData().getLastVisit());
			analyticsDataModelDb.setLocalStorageEnabled(analyticsDataModelRequest.getPageData().getLocalStorageEnabled());
			analyticsDataModelDb.setNavigatorAgent(analyticsDataModelRequest.getPageData().getNavigatorAgent());
			analyticsDataModelDb.setNavigatorVersion(analyticsDataModelRequest.getPageData().getNavigatorVersion());			
			analyticsDataModelDb.setParams(analyticsDataModelRequest.getPageData().getParams());
			analyticsDataModelDb.setPathname(analyticsDataModelRequest.getPageData().getPathname());
			analyticsDataModelDb.setPlatform(analyticsDataModelRequest.getPageData().getPlatform());
			analyticsDataModelDb.setReferrer(analyticsDataModelRequest.getPageData().getReferrer());
			analyticsDataModelDb.setReqStatus(analyticsDataModelRequest.getReqStatus());
			analyticsDataModelDb.setRuleName(analyticsDataModelRequest.getRuleName());
			analyticsDataModelDb.setTimeStamp(analyticsDataModelRequest.getTimeStamp());
			analyticsDataModelDb.setTotalVisit(analyticsDataModelRequest.getPageData().getTotalVisit());
			analyticsDataModelDb.setTrackingId(analyticsDataModelRequest.getTrackingId());
			analyticsDataModelDb.setUrl(analyticsDataModelRequest.getPageData().getUrl());
			analyticsDataModelDb.setUserId(analyticsDataModelRequest.getUserId());
			analyticsDataModelDb.setVersion(analyticsDataModelRequest.getVersion());			
			if(analyticsDataModelRequest.getIsRule()!= null && analyticsDataModelRequest.getIsRule().equalsIgnoreCase("true")){
				logger.debug("Rule data available adding rule details to DB model");
				analyticsDataModelDb.setIsRule(analyticsDataModelRequest.getIsRule());
				analyticsDataModelDb.setRuleName(analyticsDataModelRequest.getRuleName());
				analyticsDataModelDb.setRuleDesc(analyticsDataModelRequest.getRuleDesc());
			}
			analyticsList.add(analyticsDataModelDb);
			masterAnalyticsData.setTrackingId(analyticsDataModelRequest.getTrackingId());
			masterAnalyticsData.setAnalyticsData(analyticsList);
			// check if tracking id exists in DB 
			 // if yes append analyticsData 
			// else create new
			
			AnalyticSharedData.getInstance().addList(analyticsDataModelDb); // added by Sandeep T S
			
			if(analyticsDataService.isNewTrackingId(UtilService.generateCollectionName(Constants.ANALYTICS_DATA_COLLECTION,orgId), 
					analyticsDataModelRequest.getTrackingId())){
				logger.debug("new user " + analyticsDataModelRequest.getTrackingId() + " calling addAnalyticsData");
				analyticsDataService.addAnalyticsData(masterAnalyticsData, UtilService.generateCollectionName(Constants.ANALYTICS_DATA_COLLECTION,orgId));
			}
			else{
				analyticsDataService.updateAnalyticsData(UtilService.generateCollectionName(Constants.ANALYTICS_DATA_COLLECTION,orgId),analyticsDataModelDb,analyticsDataModelRequest.getTrackingId());
			}
			
			return new ResponseMessage(ResponseMessage.Type.success,"200", "dataUploaded for " + analyticsDataModelRequest.getTrackingId() ,null);
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return new ResponseMessage(ResponseMessage.Type.error,"403", "validation error" ,null);
		}		
		
	}

}
