package com.perfomatix.atomcore.service;


import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import com.perfomatix.atomcore.model.db.RuleProfileModelDb;



@Repository
public class RuleProfileService {
	private static final Logger logger = Logger.getLogger(RuleProfileService.class);
	@Autowired
	private MongoTemplate mongoTemplate;	
	
	public void addRule(RuleProfileModelDb ruleProfileModelDb, String collection){
		
		logger.debug("indside addRUle" + collection);
		if(collection != null && !collection.isEmpty()){
			if (!mongoTemplate.collectionExists(collection)) {
				mongoTemplate.createCollection(collection);
				logger.debug("indside addRUle" + collection);
			}		
			ruleProfileModelDb.setId(UUID.randomUUID().toString());
			mongoTemplate.insert(ruleProfileModelDb,collection);
		}
			
		
	}
	
	public List<RuleProfileModelDb> getRuleList(String collection){				
		return  mongoTemplate.findAll(RuleProfileModelDb.class, collection);
	}
}
