package com.perfomatix.atomcore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.perfomatix.atomcore.model.db.RuleProfileModelDb;
import com.perfomatix.atomcore.model.request.OrgDetail;
import com.perfomatix.atomcore.model.request.RuleProfileModelRequest;
import com.perfomatix.atomcore.model.response.ResponseMessage;
import com.perfomatix.atomcore.model.response.UserProfileModelResponse;
import com.perfomatix.atomcore.service.RuleProfileService;
import com.perfomatix.atomcore.util.Constants;
import com.perfomatix.atomcore.util.UtilService;


@Controller
public class RuleController {
	
	private static final Logger logger = Logger.getLogger(RuleController.class);

	@Autowired
	private RuleProfileService ruleProfileService;
	
	@RequestMapping("/getRule")
	public @ResponseBody
	ResponseMessage getrule(@RequestBody OrgDetail orgDetail, HttpServletResponse response,HttpServletRequest request,
			HttpSession session) {
		logger.debug("In /getRule");
		// check if orgId in req is null
		 // return 403
		if(orgDetail.getOrgId() == null || orgDetail.getOrgId().isEmpty()){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return new ResponseMessage(ResponseMessage.Type.error,"403", Constants.ORG_ID_NULL,null);
		}
		UserProfileModelResponse userProfileModelResponse = new UserProfileModelResponse();
		userProfileModelResponse = (UserProfileModelResponse) session.getAttribute(Constants.SESS_KEY_USER_PROFILE);
				
		System.out.println(userProfileModelResponse.getOrgId() + "" + orgDetail.getOrgId());
		
		// check if orgId in req == orgId in session.
		if(orgDetail.getOrgId().equals(userProfileModelResponse.getOrgId())){			
			List<RuleProfileModelDb> ruleList = ruleProfileService.getRuleList(UtilService.generateCollectionName(Constants.RULE_PROFILE_COLLECTION,orgDetail.getOrgId()));
			return new ResponseMessage(ResponseMessage.Type.success,"200", Constants.RULE_LIST,ruleList);
			
		}
		else{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return new ResponseMessage(ResponseMessage.Type.error,"403", Constants.ORG_ID_NO_MATCH,null);
		}	
	}
	
	@RequestMapping("/addRule")
	public @ResponseBody
	ResponseMessage addrule(@RequestBody RuleProfileModelRequest ruleProfileModelRequest , HttpServletResponse response,HttpServletRequest request,
			HttpSession session) {
		System.out.println("In /addRule");
		// TO DO - Add validation for by Org Id
		if(ruleProfileModelRequest.getOrgId() == null || ruleProfileModelRequest.getOrgId().isEmpty() ){
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return new ResponseMessage(ResponseMessage.Type.success,"403", Constants.ORG_ID_NULL,null);
		}
		RuleProfileModelDb ruleProfileModelDb = new RuleProfileModelDb();
		
		ruleProfileModelDb.setIsActive(ruleProfileModelRequest.getIsActive());
		ruleProfileModelDb.setIsChatEnabled(ruleProfileModelRequest.getIsChatEnabled());
		ruleProfileModelDb.setDisplayName(ruleProfileModelRequest.getDisplayName());
		ruleProfileModelDb.setIsNotifiactionEnabled(ruleProfileModelRequest.getIsNotifiactionEnabled());
		ruleProfileModelDb.setOrg(ruleProfileModelRequest.getOrg());
		ruleProfileModelDb.setOrgId(ruleProfileModelRequest.getOrgId());
		ruleProfileModelDb.setIsPushEnabled(ruleProfileModelRequest.getIsPushEnabled());
		ruleProfileModelDb.setRuleId(ruleProfileModelRequest.getRuleId());
		ruleProfileModelDb.setRuleName(ruleProfileModelRequest.getRuleName());
		ruleProfileModelDb.setIsSurveyEnabled(ruleProfileModelRequest.getIsSurveyEnabled());
		
		ruleProfileService.addRule(ruleProfileModelDb,UtilService.generateCollectionName(Constants.RULE_PROFILE_COLLECTION,ruleProfileModelRequest.getOrgId()));		
		return new ResponseMessage(ResponseMessage.Type.success,"200", Constants.RULE_ADDED,null);
			
		}
}
