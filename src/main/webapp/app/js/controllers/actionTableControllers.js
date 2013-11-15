'use strict';
/* Controllers */

angular.module('myApp.actionTableCtrl', []).
  controller('TableCtrl',['$scope','AnalyticsData','$log','ChatService','PubnubService','Constants','SessionManager','UtilService',
                          function($scope,AnalyticsData,$log,ChatService,PubnubService,Constants,SessionManager,UtilService){	  
	   
	  $scope.ruleData = AnalyticsData.getAnalyticsData();	  
	  $scope.predicate = '-timeStamp'; 
	  
	  var userProfile = SessionManager.getSessionData(Constants.SESS_KEY_USER_PROFILE);
	  var assignmentChannel = UtilService.getChannelNameForAssignment(userProfile.orgId);
	  
	  PubnubService.PUBNUB.subscribe({
		  channel : assignmentChannel,
	        message : function(data){
	        	if(data.msgType === Constants.MSG_TYP_ASSIGN){
	        		var isAgentAssigned = false;
	        		// check in tracker if assignment already exists
	        		 // if agent_id is same as data.msg.agentId ignore as user is same.
	        		var assignmentTracker = UtilService.getAssignmentTracker();
	        		for ( var i = 0; i < assignmentTracker.length; i++) {	        			
						if(assignmentTracker[i].trackingId === data.msg.trackingId && assignmentTracker[i].agentId === data.msg.agentId)
							{
							// data received from same client publish
							isAgentAssigned = true;
							console.log("data received from same client publish");							
							}
						else if (assignmentTracker[i].trackingId === data.msg.trackingId && assignmentTracker[i].agentId != data.msg.agentId){
							// update tracker
							isAgentAssigned = true;
							UtilService.setAssignmentTracker(data.msg.trackingId,data.msg.agentId);
							AnalyticsData.assignRequest(data.msg.trackingId,data.msg.agentId);
							$scope.$apply();
						}
					}
	        		if(!isAgentAssigned){
	        			UtilService.setAssignmentTracker(data.msg.trackingId,data.msg.agentId);
						AnalyticsData.assignRequest(data.msg.trackingId,data.msg.agentId);
						$scope.$apply();
	        		}
	        	}
	        	
	        	if(data.msgType === Constants.MSG_TYP_RELEASE){
	        		// if same user ignore
	        		// else remove from AT and AD
	        		if( userProfile.loginId !== data.msg.agentId){
	        		  AnalyticsData.releaseRequest(data.msg.trackingId,data.msg.agentId);
	      			  UtilService.removeAssignmentData(data.msg.trackingId);
	      			  $scope.$apply();
	        		}
	        	}
	        }
	        /*{
	        	if(data.msgType === Constants.MSG_TYP_RELEASE && data.msg.agentId != userProfile.loginId){
	        		AnalyticsData.releaseRequest(data.msg.trackingId,data.msg.agentId);
	        		UtilService.removeAssignmentData(data.msg.trackingId);
	        		$scope.$apply();
	        	}
	        	else if(data.msgType === Constants.MSG_TYP_RELEASE && data.msg.agentId === userProfile.loginId){
	        		//AnalyticsData.releaseRequest(data.msg.trackingId,data.msg.agentId);
	        		UtilService.removeAssignmentData(data.msg.trackingId);
	        		$scope.$apply();
	        	}
	        	else if(data.msgType === Constants.MSG_TYP_ASSIGN && data.msg.agentId != userProfile.loginId) {
	        		
		        	UtilService.setAssignmentTracker(data.msg.trackingId,data.msg.agentId,AnalyticsData.getAnalyticsData());
		        	// update Analytics data with agent details
		        	AnalyticsData.assignRequest(data.msg.trackingId,data.msg.agentId);
		        	$scope.$apply();
	        	}	        	
	        }*/
	  })
	  
	  $scope.limits = [{
	    value: '1',
	    text: 'Assign to me'
	  }, {
	    value: '2',
	    text: 'Release to Queue'
	  },
	  {
		value: '99',
		text: '---Select---'
	  }];
	  
	  
	  $scope.assign = function(trackingId , selectedLimit){		  
		  
		  if(!selectedLimit || selectedLimit === '99' ){
			  alert("Please select valid option before submitting")
		  }
		  else if(selectedLimit === '1'){// assign to me			  
			  // update status in assignment tracker
			  UtilService.setAssignmentTracker(trackingId,userProfile.loginId);
			  // update data in analyticsData
			  AnalyticsData.assignRequest(trackingId,userProfile.loginId);			  
			 // publish data
			 var msg = {trackingId:trackingId,agentId:userProfile.loginId};		 
			 PubnubService.PUBNUB_PUB(Constants.MSG_TYP_ASSIGN,msg,assignmentChannel);	
		  }
		  else if (selectedLimit === '2'){ // release by me
			  AnalyticsData.releaseRequest(trackingId,userProfile.loginId);
			  UtilService.removeAssignmentData(trackingId);
			  $scope.$apply();
			  var msg = {trackingId:trackingId,agentId:userProfile.loginId};
			  PubnubService.PUBNUB_PUB(Constants.MSG_TYP_RELEASE,msg,assignmentChannel);	
			  // release to Q
		  }
		  
	  }
	  
	  $scope.chat = function(trackingId,index){
		  // change status from new to in progress
		  //ChatService.changeReqStatusAnalytics(trackingId);
		  var modalId = '#moreInfoModal'+index;
		  $(modalId).modal('hide'); // Hide More Info modal.Req if chat clicked from modal		  
		  var clientChannel = ChatService.getClientChannel(trackingId);
		  var agentChannel = ChatService.getAgentChannel(trackingId);
		  var box = ChatService.getWindows(trackingId);// get chat box object
		  var msg = "";		  
		  if(box) {
			  $log.info("box true do nothing");	
			  box.chatbox("option", "boxManager").highlightBox();
		  }
		  else {
			  $log.info("new box");			  
			  box = ChatService.initBox(trackingId);
		  }
          PubnubService.PUBNUB.subscribe({
	        channel : agentChannel,
	        message : function(msg){ 
	          if(msg.msgType != Constants.MSG_TYP_CHAT_CLOSE){
	        	  console.log("inside pubnub subscribe");	
	        	  if(ChatService.getWindows(msg.trackingId)){
	        		  box.chatbox("option", "boxManager").addMsg(trackingId,msg.msg); 
	        	  }
	        	  //** since box object null assume user offline and send a message**//
	        	  else{
	        		  PubnubService.PUBNUB_PUB(Constants.MSG_TYP_CHAT,"Agent Offline",clientChannel);
	        	  }
	          }
	          else if(msg.msgType == Constants.MSG_TYP_CHAT_CLOSE){
	        	  if(ChatService.getWindows(msg.trackingId)){
	        		  box.chatbox("option", "boxManager").addMsg("System Message","User closed chat window");  
	        	  }	        	  
	          }	          
	        }
	     });		          		        
         $('.ui-chatbox-input-box ').keydown(function(event) {
	          console.log("in keydown");		          
	          if (event.keyCode && event.keyCode == $.ui.keyCode.ENTER) {
	              msg = $.trim($(this).val());		              
	              if (msg.length > 0) {
	            	  box.chatbox("option", "boxManager").addMsg("Me", msg);		            	  
	            	  PubnubService.PUBNUB_PUB(Constants.MSG_TYP_CHAT,msg,clientChannel);		                  
              		}
	              $(this).val('');
	              return false;
	          }
	      });
	 };// end scope.chat
	 $scope.push = function(trackingId,msg,index){		 
		 var clientChannel = ChatService.getClientChannel(trackingId);
		 PubnubService.PUBNUB_PUB(Constants.MSG_TYP_PUSH,msg,clientChannel);
		 var pushModalId = '#pushModal'+index;
		  $(pushModalId).modal('hide');
		  var moreInfoModal = '#moreInfoModal'+index;
		  $(moreInfoModal).modal('hide');
	 };
  }]);