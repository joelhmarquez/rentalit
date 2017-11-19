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



@SpringBootApplication
public class RentalitApplication {

	public static void main(String[] args) {

		SpringApplication.run(RentalitApplication.class, args);

		MongoClient mongoClient = new MongoClient();

		MongoDatabase database = mongoClient.getDatabase("dummydb");

		MongoCollection<Document> collection = database.getCollection("mycollection");

		Document doc = new Document("name", "MongoDB")
				.append("type", "database")
				.append("count", 1)
				.append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
				.append("info", new Document("x", 203).append("y", 102));

		collection.insertOne(doc);

		System.out.println(collection.count());

		Document myDoc = collection.find(eq("name", "MongoDB")).first();

		System.out.println(myDoc.toJson());

		collection.deleteOne(eq("name", "MongoDB"));

		System.out.println(collection.count());

	}

}

