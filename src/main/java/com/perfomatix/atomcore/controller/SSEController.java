
package com.perfomatix.atomcore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perfomatix.atomcore.model.request.AnalyticSharedData;
import com.perfomatix.atomcore.model.request.AnalyticsDataModelRequest;
import com.perfomatix.atomcore.model.response.ResponseMessage;
import com.perfomatix.atomcore.model.response.ResponseMessage.Type;

/**
 * @author SCJ
 *
 */
@Controller
public class SSEController {
	
	private static final Logger logger = Logger.getLogger(AnalyticsDataController.class);
	
	@RequestMapping(value ="/sseAnalyticsData", method = RequestMethod.GET)
	public @ResponseBody
	ResponseMessage sendAnalyticsData(HttpServletRequest request,HttpServletResponse response, HttpSession session){
		
		return new ResponseMessage(Type.success, "200", "data", AnalyticSharedData.getInstance().getList());
	}

}
