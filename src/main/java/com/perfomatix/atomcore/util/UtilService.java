package com.perfomatix.atomcore.util;

import java.io.IOException;
import java.io.OutputStream;

import com.perfomatix.atomcore.security.spring.wrapper.GenericResponseWrapper;

public class UtilService {
	
	static final byte[] jsonpstart = new String("(").getBytes();
	static final byte[] jsonpclose = new String(");").getBytes();

	
	public static String generateCollectionName(String collectionBase , String orgId){	
		//String collectionBase = Constants.RULE_PROFILE_COLLECTION;
		System.out.println("collection name -- >" + Constants.RULE_PROFILE_COLLECTION.concat(orgId));
		return collectionBase.concat(orgId);		
	}

	/**
	 * 
	 * @param wrapper
	 * @param callback
	 * @param out
	 * @throws IOException
	 */
	public static void createjsonp(GenericResponseWrapper wrapper, String callback, OutputStream out) throws IOException {

		out.write(new String(callback).getBytes());
		out.write(jsonpstart);
		out.write(wrapper.getData());
		out.write(jsonpclose);
		wrapper.setContentType("text/javascript;charset=UTF-8");
		out.close();
	}

}
