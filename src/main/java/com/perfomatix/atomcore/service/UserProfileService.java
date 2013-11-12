package com.perfomatix.atomcore.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import com.mongodb.WriteConcern;
import com.perfomatix.atomcore.model.db.UserProfileModelDb;
import com.perfomatix.atomcore.util.Constants;

@Repository
public class UserProfileService {
	private static final Logger logger = Logger.getLogger(UserProfileService.class);
		@Autowired
		private MongoTemplate mongoTemplate;		
		public boolean addPerson(UserProfileModelDb userProfileModelDb) {
			logger.debug("inside add person");
			mongoTemplate.setWriteConcern(WriteConcern.SAFE);
			//mongoTemplate.indexOps(UserProfileModelDb.class).ensureIndex(new Index().on("userId",Direction.DESC).unique());
			//mongoTemplate.indexOps(UserProfileModelDb.class).ensureIndex(new Index("userId",Direction.DESC).unique());
			boolean status = true;
			
			if (!mongoTemplate.collectionExists(Constants.USER_PROFILE_COLLECTION_NAME)) {
				logger.debug("creating new collection");
				mongoTemplate.createCollection(Constants.USER_PROFILE_COLLECTION_NAME);
			}		
			//userProfileModelDb.setId(UUID.randomUUID().toString());			
			
			try {
				logger.debug("insert to mDB");
				mongoTemplate.insert(userProfileModelDb,Constants.USER_PROFILE_COLLECTION_NAME);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				status = false;
				e.printStackTrace();
			}
			return status;
		}
		public UserProfileModelDb findUser(String userName, String password){
			//Query searchUserQuery = new Query(Criteria.where("loginId").is(userName));
			logger.debug("find if user exists with pwd/userId combo");
			return mongoTemplate.findOne(query(where("loginId").is(userName).and("password").is(password)),UserProfileModelDb.class,Constants.USER_PROFILE_COLLECTION_NAME);
		}
		
		public List<UserProfileModelDb> listPerson() {
			return mongoTemplate.findAll(UserProfileModelDb.class);
		}
		public void updatePerson(UserProfileModelDb userProfileModelDb ) {
			mongoTemplate.insert(userProfileModelDb);		
		}
}
