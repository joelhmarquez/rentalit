package com.rentalit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class mongo_DB {

    public void add_Listing(String product_Name, String condition, String description, Integer rented){
        MongoClient mongoClient = new MongoClient();


        MongoDatabase database = mongoClient.getDatabase("dummydb"); //connect db

        MongoCollection<Document> collection = database.getCollection("mycollection"); //get collection

        Document doc = new Document("product_Name", product_Name) //document to insert
                .append("condition", condition)
                .append("description", description)
                .append("isRented", rented);

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

