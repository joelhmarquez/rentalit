package com.rentalit.models;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MongoDB {
	static Logger log = LoggerFactory.getLogger(MongoDB.class);
	
    public void addListing(Listing listing) throws InvalidListingException{
    		log.info("Adding post to database: ", listing);

        MongoClient mongoClient = new MongoClient();
        
        MongoDatabase database = mongoClient.getDatabase("dummydb"); //connect db

        MongoCollection<Document> collection = database.getCollection("mycollection"); //get collection

        Document doc = new Document("product_Name", listing.getProductName()) //document to insert
                .append("condition", listing.getCondition().toString())
                .append("description", listing.getDescription())
                .append("isRented", listing.getRented());

        Validator.validate(listing.getProductName(),listing.getDescription(),listing.getCondition().toString());
        collection.insertOne(doc);//insert into collection

        //Document myDoc = collection.find(eq("product_name", product_Name)).first();

        //System.out.println(myDoc.toJson());

		//collection.deleteOne(eq("name", "MongoDB")); //delete after insert

    }
    public List<Document> search_Item(Document query){

        MongoClient mongoClient = new MongoClient();

        MongoDatabase database = mongoClient.getDatabase("dummydb"); //connect db

        MongoCollection<Document> collection = database.getCollection("mycollection");
        FindIterable<Document> doc = collection.find(query);
        List<Document> results = new ArrayList<>();

//        if (doc == ) {
//            log.error("NO ITEMS");
//        }

        for(Document docs : doc) {
            results.add(docs);
        }
        if(results.isEmpty()) {
            log.error("FUCK");
        }
        return results;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

