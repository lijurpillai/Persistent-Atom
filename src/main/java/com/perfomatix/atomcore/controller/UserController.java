package com.perfomatix.atomcore.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.perfomatix.atomcore.model.db.UserProfileModelDb;
import com.perfomatix.atomcore.model.request.UserModelRequest;
import com.perfomatix.atomcore.model.request.UserProfileModelRequest;
import com.perfomatix.atomcore.model.response.ResponseMessage;
import com.perfomatix.atomcore.model.response.UserProfileModelResponse;
import com.perfomatix.atomcore.service.UserProfileService;
import com.perfomatix.atomcore.util.Constants;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	private UserProfileService userProfileService;
	
	@RequestMapping(value ="/loggedin", method = RequestMethod.GET)
	public @ResponseBody
	ResponseMessage loggedIn(HttpServletRequest request,
			HttpServletResponse response, HttpSession session){
		logger.debug("inside /loggedin");
		UserProfileModelResponse userProfileModelResponse = new UserProfileModelResponse();	
		if(session != null){
			userProfileModelResponse = (UserProfileModelResponse) session.getAttribute(Constants.SESS_KEY_USER_PROFILE);
		}
		else{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		
		if(userProfileModelResponse == null || userProfileModelResponse.getFirstName() == "" ){
			//return new ResponseMessage(ResponseMessage.Type.success,"401", "sessionInValid",null);
			logger.debug("session invalid/null");
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		logger.debug("session valid");
		return new ResponseMessage(ResponseMessage.Type.success,"200", "sessionValid",userProfileModelResponse);
		
	}
	//** login api **//
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public @ResponseBody  
	ResponseMessage login(@RequestBody UserModelRequest userModelRequest, HttpServletResponse response,
			HttpSession session) 	
	
	{   logger.debug("Inside /user");	 
		UserProfileModelDb userProfileModelDb = new UserProfileModelDb(); 
		UserProfileModelResponse userProfileModelResponse = new UserProfileModelResponse();
		userProfileModelDb = userProfileService.findUser(userModelRequest.getUserName(), userModelRequest.getPassword());		
		if(userProfileModelDb != null){
			
			userProfileModelResponse.setFirstName(userProfileModelDb.getFirstName());
			userProfileModelResponse.setLastName(userProfileModelDb.getLastName());
			userProfileModelResponse.setOrg(userProfileModelDb.getOrg());
			userProfileModelResponse.setOrgId(userProfileModelDb.getOrgId());
			userProfileModelResponse.setRoleDesc(userProfileModelDb.getRoleDesc());
			userProfileModelResponse.setRoleId(userProfileModelDb.getRoleId());
			userProfileModelResponse.setUserId(userProfileModelDb.getUserId());
			userProfileModelResponse.setLoginId(userProfileModelDb.getLoginId());
			
			session.setAttribute(Constants.SESS_KEY_USER_PROFILE, userProfileModelResponse);
			return new ResponseMessage(ResponseMessage.Type.success,"200", "loginSuccess",userProfileModelResponse);			
		}
		else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return new ResponseMessage(ResponseMessage.Type.error,"403", "loginFailure",null);
		}
	}
	
	@RequestMapping("/logout")
	public void logOut(HttpSession session, HttpServletResponse response,
			HttpServletRequest request) {
		logger.debug("Inside /logout");
		session.invalidate();
		response.setStatus(HttpServletResponse.SC_OK);
	}
	//** add user api **//
	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public @ResponseBody
	ResponseMessage addUser(@RequestBody @Valid UserProfileModelRequest userProfileModelRequest,BindingResult result,HttpServletResponse response ){
		logger.debug("Inside /user/save");			
		if(result.hasErrors()) {
		 	response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return new ResponseMessage(ResponseMessage.Type.error,"403", "validation error",null);
     }
		boolean status = false;
		UserProfileModelDb userProfileModelDb = new UserProfileModelDb();
			
			userProfileModelDb.setId(userProfileModelRequest.getUserId());
			userProfileModelDb.setFirstName(userProfileModelRequest.getFirstName()); 
			userProfileModelDb.setLastName(userProfileModelRequest.getLastName());
			userProfileModelDb.setRoleDesc(userProfileModelRequest.getRoleDesc());
			userProfileModelDb.setRoleId(userProfileModelRequest.getRoleId());
			userProfileModelDb.setOrg(userProfileModelRequest.getOrg());
			userProfileModelDb.setOrgId( userProfileModelRequest.getOrgId());
			userProfileModelDb.setUserId( userProfileModelRequest.getUserId());
			userProfileModelDb.setLoginId(userProfileModelRequest.getLoginId());
			userProfileModelDb.setPassword(userProfileModelRequest.getPassword());
			userProfileModelDb.setIsActive(userProfileModelRequest.getIsActive().toLowerCase());
			status = userProfileService.addPerson(userProfileModelDb);
			if(status)	{
				logger.debug("Status of add user" + status);
				return new ResponseMessage(ResponseMessage.Type.success,"200", "userAdded",null);	
			}
				
			else{
				return new ResponseMessage(ResponseMessage.Type.error,"500", "systemError",null);	
			}
	};
}
