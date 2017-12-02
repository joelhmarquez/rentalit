package com.rentalit.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import com.mongodb.DBCursor;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.rentalit.error.InvalidListingException;
import com.rentalit.resources.Condition;
import com.rentalit.resources.Validator;
import org.bson.Document;
import org.bson.BSON;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.type.NullType;
import javax.print.Doc;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;


public class MongoDB {
	static Logger log = LoggerFactory.getLogger(MongoDB.class);
	ObjectMapper objectMapper = new ObjectMapper();
	
    public void addListing(Listing listing) throws InvalidListingException {
    		log.info("Adding post to database: ", listing);

        MongoClient mongoClient = new MongoClient();
        
        MongoDatabase database = mongoClient.getDatabase("dummydb"); //connect db

        MongoCollection<Document> collection = database.getCollection("mycollection"); //get collection

        Document doc = mongo_Query(listing);

        Validator.validate(listing.getProductName(),listing.getDescription(),listing.getCondition().toString());
        collection.insertOne(doc);//insert into collection

    }
    
    public void updateListing(Listing listing) {
    		log.info("updating listing: " + listing.getProductName());
        MongoClient mongo = new MongoClient();
        MongoDatabase database = mongo.getDatabase("dummydb"); //connect db
        MongoCollection<Document> collection = database.getCollection("mycollection");
    		Document updatedDoc = query_builder(listing);
    		Document searchQuery = query_builder(listing);
    		searchQuery.remove("calendar");
    		searchQuery.remove("rented");
    		
    		collection.replaceOne(searchQuery, updatedDoc);
    }

    public Document mongo_Query(Listing listing){
		try {
    			Document doc = new Document("product_Name", listing.getProductName()) //document to insert
    	                .append("condition", listing.getCondition().toString())
    	                .append("description", listing.getDescription())
                        .append("url",listing.getUrl())
    	                .append("rented", 0)
    	                .append("calendar", new Document("startDate", " ").append("endDate", " "));

    	        return doc;	
    		} catch (Exception e) {
    			log.error("Unable to create document: ", e);
    		}
    		return new Document();
    }
    
    public Document query_builder(Listing listing) {
    		Document doc = new Document();
		
		if(!listing.getProductName().isEmpty()) doc.append("product_Name", Pattern.compile(listing.getProductName(), Pattern.CASE_INSENSITIVE));
		if(!listing.getDescription().isEmpty()) doc.append("description", Pattern.compile(listing.getDescription(), Pattern.CASE_INSENSITIVE));
		if(listing.getRented() != 2) doc.append("rented", listing.getRented());
		if(listing.getCalendar() != null) doc.append("calendar", new Document("startDate", listing.getCalendar().getStartDate()).append("endDate", listing.getCalendar().getEndDate()));
		if(listing.getCondition() != Condition.ANY) doc.append("condition", listing.getCondition().toString());
		
		return doc;
    }

	public List<Listing> search_Item(Document query){

        MongoClient mongoClient = new MongoClient();

        MongoDatabase database = mongoClient.getDatabase("dummydb"); //connect db

        MongoCollection<Document> collection = database.getCollection("mycollection");
        
        /* Query Mongodb */
        FindIterable<Document> doc;
        if(query != null) {
        		doc = collection.find(query);
        } else {
        		doc = collection.find();
        }
       
        
        List<Listing> results = new ArrayList<>();
        for(Document docs : doc) {
        		try {
        			results.add(objectMapper.readValue(docs.toJson(), Listing.class));
        		} catch(Exception e) {
        			log.error("Unable to deserialize listing json", e);
        		}
        }
        if(results.isEmpty()) {
            log.error("results are empty");
        }
        else{
            log.info("Found results in mongo, length is: " + results.size());
        }
        return results;
    }
	
    @Override
    public String toString() {
        return super.toString();
    }
}

