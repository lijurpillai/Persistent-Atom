'use strict';

var dataModule = angular.module('myApp.DBServices', []);

dataModule.factory('AnalyticsDBService',['$log','$http','Constants'
                                       ,function($log,$http,Constants){
	
	return {
		updateData : function(data){
			$log.info("Inside logIn service--");
			if(data.isRule){
				//** add data rule data to master data **//
				data.ruleName = data.ruleDetails.ruleName;
				data.ruleDesc = data.ruleDetails.ruleDesc;
				//** remove rule details from obkj **//
				delete data["ruleDetails"];
			}
			if(data != null){
				$http.post('/AtomCore/api/analyticsData', data)
				    .success(function(response){
				    	console.log(response);
				    	})
				    .error(function(response){
					      // Error: authentication failed
					      console.log("ERROR IN ANALYTICS DATA UPLOAD");
					      console.log(response);
					    })
			}
			else{
				console.log("ANALYTICS DATA NULL");
			}
		}
	}
}]);