package com.rentalit;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;


public class MongoDB {
	
    public void addListing(Listing listing){

        MongoClient mongoClient = new MongoClient();
        
        MongoDatabase database = mongoClient.getDatabase("dummydb"); //connect db

        MongoCollection<Document> collection = database.getCollection("mycollection"); //get collection

        Document doc = new Document("product_Name", listing.getProductName()) //document to insert
                .append("condition", listing.getCondition())
                .append("description", listing.getDescription())
                .append("isRented", listing.getRented());

        collection.insertOne(doc); //insert into collection

        System.out.println(collection.count());

        //Document myDoc = collection.find(eq("product_name", product_Name)).first();

        //System.out.println(myDoc.toJson());

		//collection.deleteOne(eq("name", "MongoDB")); //delete after insert

		System.out.println(collection.count());
    }
    @Override
    public String toString() {
        return super.toString();
    }
}

