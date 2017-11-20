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

		mongo_DB test = new mongo_DB();
		test.setDescription("This is roller blades");
		test.setProduct_Name("RollerBlades");
		test.setType("FUN");
		test.setRented(0);
		test.add_Listing(test.getProduct_Name(),test.getType(),test.getDescription(),test.getRented());

	}

}

