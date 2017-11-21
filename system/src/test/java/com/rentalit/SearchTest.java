package com.rentalit;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rentalit.models.Listing;
import com.rentalit.models.MongoDB;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchTest{

    //for normal addition
    @Test
    public void testSearch()
    {
        MongoDB mongo = new MongoDB();
        Document query = new Document();
        query.put("product_Name","Computer");
        query.put("description","This is a computer");
        query.put("condition","GOOD");
        query.put("isRented",0);

        List<Listing> results = mongo.search_Item(query);

        assertEquals(2, results.size());
    }

}