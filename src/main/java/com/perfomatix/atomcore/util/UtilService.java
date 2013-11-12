package com.perfomatix.atomcore.util;

public class UtilService {
	
	public static String generateCollectionName(String collectionBase , String orgId){	
		//String collectionBase = Constants.RULE_PROFILE_COLLECTION;
		System.out.println("collection name -- >" + Constants.RULE_PROFILE_COLLECTION.concat(orgId));
		return collectionBase.concat(orgId);		
	}

}
