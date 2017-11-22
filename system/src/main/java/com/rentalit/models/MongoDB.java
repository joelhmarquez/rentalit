package com.rentalit.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import com.mongodb.DBCursor;

import com.rentalit.error.InvalidListingException;
import com.rentalit.resources.Validator;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.type.NullType;
import javax.print.Doc;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


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

        //Document myDoc = collection.find(eq("product_name", product_Name)).first();

        //System.out.println(myDoc.toJson());

		//collection.deleteOne(eq("name", "MongoDB")); //delete after insert

    }
    
    public void updateListing(Listing listing) {
    		// TODO write code to update listing (The isRented property should be changed)
    }

    public Document mongo_Query(Listing listing){
        Document doc = new Document("product_Name", listing.getProductName()) //document to insert
                .append("condition", listing.getCondition().toString())
                .append("description", listing.getDescription())
                .append("isRented", 0)
                .append("startDate", "")
                .append("endDate","");
        return doc;
    }

	public List<Listing> search_Item(Document query){

        MongoClient mongoClient = new MongoClient();

        MongoDatabase database = mongoClient.getDatabase("dummydb"); //connect db

        MongoCollection<Document> collection = database.getCollection("mycollection");
        FindIterable<Document> doc = collection.find(query);
        List<Listing> results = new ArrayList<>();

//        if (doc == ) {
//            log.error("NO ITEMS");
//        }

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
        return results;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

