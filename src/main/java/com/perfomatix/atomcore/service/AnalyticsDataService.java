package com.perfomatix.atomcore.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.perfomatix.atomcore.model.db.AnalyticsDataModelDb;
import com.perfomatix.atomcore.model.db.MasterAnalyticsData;

@Repository
public class AnalyticsDataService {
	private static final Logger logger = Logger.getLogger(AnalyticsDataService.class);
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void addAnalyticsData( MasterAnalyticsData masterAnalyticsData, String collection){
		
		logger.debug("indside addRUle");
		if(collection != null && !collection.isEmpty()){
			if (!mongoTemplate.collectionExists(collection)) {
				logger.debug("Collection does not exist, creating collection ->" + collection);
				mongoTemplate.createCollection(collection);
			}	
			logger.debug("collection exists calling insert");
			masterAnalyticsData.setId(UUID.randomUUID().toString());
			mongoTemplate.insert(masterAnalyticsData,collection);
		}
	}
	
	public boolean isNewTrackingId(String collection,String trackingId){
		 logger.debug("inside isNewTrackingId");
		 MasterAnalyticsData masterAnalyticsData = new MasterAnalyticsData();
		 logger.debug("calling findOne to query for trackingId");
		 masterAnalyticsData = mongoTemplate.findOne(query(where("trackingId").is(trackingId)),MasterAnalyticsData.class,collection);
		 if(masterAnalyticsData != null && masterAnalyticsData.getTrackingId().equals(trackingId)){
			 logger.debug("Existing tracking id");
			 return false;
		 }
		 		
		 else{
			 logger.debug("NewTrackingId");
			 return true;
		 }
	}

	public void updateAnalyticsData(String collectionName,AnalyticsDataModelDb analyticsDataModelDb, String trackingId) {
		logger.debug("update Analytucs data");
		Query query = new Query(Criteria.where("trackingId").is(trackingId));
		Update update = new Update().push("analyticsData", analyticsDataModelDb);	
		logger.debug("mongoTempate.updateFirst");
		mongoTemplate.updateFirst(query, update,collectionName);
		
	}
	
}
