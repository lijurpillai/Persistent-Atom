'use strict';

var utilService = angular.module('myApp.utilServices', []);

utilService.value('version', '0.1');

utilService.factory('Constants',['$log',function($log){
	// env
	var env = "qa";
	//var env = "dev";
	// pubnub key
	var publish_key = 'pub-c-d4a57f9f-86b6-430b-99f8-68494e8bcabb';
    var subscribe_key = 'sub-c-8bb20b58-4b4c-11e3-8e17-02ee2ddab7fe';
    //channels
	var analyticsChannel = "analyticsData";
	var chatChannel = "chat";	
	var assignmentChannel = "assignmentChannel";
	var msgTypeChatClose = 99; // Clinet closes window
	var msgTypeChat = 1; // Chat
	var msgTypePush = 21; // Push
	var msgTypeAssign = 31;// Assignment
	var msgTypeRelease = 32;// Release assignment
	//session key
	var session_key_userProfile = "userProfile";
	var session_key_ruleProfile = "ruleProfile";
	//other
	var seperator = '_';
	// error message
	var maxWindowLimit = {id: 1 , msg:"Reached max chat window limit of : "};
	// device names
	var androidDevice = "Android",
		iOSDevice = "iOS",
		winDevice = "IEMobile";		
	var desktopDevice = "Desktop";
	//device img url
	var urlWindows = "img/icons/desktop.png",
		urlAndroid ="img/icons/android.png" ,
		urlWinMobile="img/icons/metro.png" ,
		urlIOs = "img/icons/ios.png";
	// Rule Column Name
	var ruleColName = "Rule Name";
	// Toot Tip Text
	var allUsersTxt = "This shows the number of connected users both active and inactive.";
	var activeUsersTxt = "Shows the list of users who are active (does some activity like clicking a link etc.).";
	var deviceDetailsTxt = "Shows the device details using which the users are connected.";
	var rulesDetailsTxt = "Shows the list of rules configured and the number of times they are triggered.";
	var pageCountTxt = "The number of times each page is viewed by all active users combined.";
	var userDetailsTxt = "User geography details and shows the percentage of first time users.";
	return{	
		PUB_KEY:publish_key,
		SUB_KEY:subscribe_key,		
		PUBNUB_ANALYTICS_CHANNEL:analyticsChannel,
		PUBNUB_CHAT_CHANNEL: chatChannel,
		PUB_NUB_ASSIGN_CHANNEL:assignmentChannel,
		SEPERATOR: seperator,
		SESS_KEY_USER_PROFILE:session_key_userProfile,
		SESS_KEY_RULE_PROFILE:session_key_ruleProfile,
		MSG_TYP_CHAT_CLOSE:msgTypeChatClose,
		MSG_TYP_CHAT:msgTypeChat,
		MSG_TYP_PUSH : msgTypePush,
		MSG_TYP_ASSIGN : msgTypeAssign,
		MSG_TYP_RELEASE : msgTypeRelease,
		ERR_MSG_MAX_WINDOW:maxWindowLimit,
		ANDROID_DEVICE:androidDevice,
		I_OS_DEVICE:iOSDevice,	
		WIN_DEVICE : winDevice,
		DESKTOP:desktopDevice,
		URL_WIN:urlWindows,
		URL_ANDROID:urlAndroid,
		URL_IOS:urlIOs,
		URL_WINMOB:urlWinMobile,
		ENV:env,
		RULE_COL_NAME:ruleColName,
		ALL_USERS_TXT:allUsersTxt,
		ACTIVE_USERS_TXT:activeUsersTxt,
		USER_DETAILS_TXT:userDetailsTxt,
		RULES_DETAILS_TXT:rulesDetailsTxt,
		PAGE_COUNT_TXT:pageCountTxt,
		DEVICE_DETAILS_TXT:deviceDetailsTxt
      };
}]);

utilService.factory('SessionManager',['$log','Constants','RuleData','AnalyticsData',function($log,Constants,RuleData,AnalyticsData){
	$log.info("inside Sessionmanager");
	return{	
		clearSession:function(key){
			$log.info("inside Sessionmanager>clearSession");
			if(sessionStorage){		  
				sessionStorage.clear(key);			
			}			
		},
		resetOnLogOut:function(){
			$log.info("resetOnLogOut");
			//** clear user profile from session **//			
			if(sessionStorage){		  
				sessionStorage.clear(Constants.SESS_KEY_USER_PROFILE);			
			}
			//** reset rule profile array **//
			RuleData.resetRuleConfig();
			//**reset rule array**//
			RuleData.resetRuleData();
			//**reset analtics data**//
			AnalyticsData.resetAnalyticsData();
			//** reset page count bar chart data **//
			AnalyticsData.resetPageCount();
			
			
		},
		getSessionData:function(key){
			$log.info("inside Sessionmanager>getrSession");
			if(sessionStorage){		  
				return JSON.parse(sessionStorage.getItem(key));		
			}
		}
      };
}]);

utilService.factory('UtilService',['$log','Constants',function($log,Constants){
	//** Page config for chart display**//
	/*var pageCountConfig = [[1,"Index"], 
	                       [2, "Home"], 
	                       [3, "Autumn"], 
	                       [4, "Other"]];*/
	//** Ends **//
	//** assignemnt tracker**//
		var assignmentTracker= [];		
	//** assignemnt tracker ENDS**//
	
return{
	getDeviceImgUrl :function(device){
		switch (device) {
		case "Desktop":
			return Constants.URL_WIN;
			break;
		case "iOS":
			return Constants.URL_IOS;
			break;
		case "Android":
			return Constants.URL_ANDROID;
			break;
		case "IEMobile":
			return Constants.URL_WINMOB;
			break;
		default:
			return Constants.URL_WIN;
			break;
		}
	},
	getChannelNameForAssignment : function(orgId){
		console.log("ASSIGNMENT CHANEL -- >" + orgId + Constants.SEPERATOR + Constants.PUB_NUB_ASSIGN_CHANNEL);
		return orgId + Constants.SEPERATOR + Constants.PUB_NUB_ASSIGN_CHANNEL;
	},
	setAssignmentTracker:function(trackingId,agentId){	
		var isNewTrackingId = true;
		var tracker = {};		
		// if tracker is null add data.
		if(assignmentTracker.length == 0){			
			tracker.trackingId = trackingId;
			tracker.agentId = agentId;
			tracker.status = true; // assigned
			assignmentTracker.push(tracker);			
		}
		// else if trackingId matches update status to true and agent Id
		else{			
			for ( var i = 0; i < assignmentTracker.length; i++) {
				// if t_id already exist update
				if(assignmentTracker[i].trackingId === trackingId){
					isNewTrackingId = false;
					assignmentTracker[i].agentId = agentId;	
					assignmentTracker[i].status = true;
					break;
					//assignmentTracker.push(tracker);
				}								
			}
			if(isNewTrackingId){
				tracker.trackingId = trackingId;
				tracker.agentId = agentId;	
				tracker.status = true;
				assignmentTracker.push(tracker);
			}
		}
		
		},
		getAssignmentTracker:function(){
			return assignmentTracker;
		},
	
		isReqAssigned : function(trackingId){
			console.log("I AM IN isReqAssigned ");
			var isReqAssigned = false;
			// loop through assignmentTracker and check for status
			for ( var i = 0; i < assignmentTracker.length; i++) {
				// if true return return assignmentTracker obj
				if(assignmentTracker[i].trackingId === trackingId ){
					isReqAssigned = true;
					return assignmentTracker[i];
				}
			}
			// if new not yet assigned return false.
			if(!isReqAssigned){
				return isReqAssigned;
			}
		},
		removeAssignmentData : function(trackingId){
			for ( var i = 0; i < assignmentTracker.length; i++){
				if(trackingId === assignmentTracker[i].trackingId){
					assignmentTracker.splice(i,1);
				}
			}
		}
		
};
	
}]);

utilService.factory('UserAgentService',['$log',function($log){
	$log.info("UserAgentService");
	var uAgent = null;	
	
	 return{
		 getBrowserType:function(){
				$log.info("UserAgentService > getBrowserType");
				var browser = uAgent.match(/(Firefox|Chrome|Safari|Opera|;MSIE)/i);
				if(browser!=null){
					return browser[0];
				}
				else {
					return "Other";
				}				
			},
		getDeviceType:function(){
			var device = "Desktop";
			$log.info("UserAgentService > getDevice");
			var mobDevice = uAgent.match(/(Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini)/i);			
			
			if(mobDevice){
				device = mobDevice[0];
				if(device =="iPhone"||device =="iPad"||device =="iPod" ){
					device = "iOS";					
				}
			}
			return device;
		},
		setUserAgent:function(uaString){
			$log.info("UserAgentService > setUserAgent");
			uAgent = uaString;		
		},
		getUserAgent:function(){
			return uAgent;
		},
		isMobile:function(){
			var device = uAgent.match(/(Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini)/);			
			var isMobile = false;			
			if(device){				
				isMobile = true;
			}
			return isMobile;
		}
      };
}]);