package com.ameya.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MDBC {

	public static void main(String[] args) {
		MongoClient client = new MongoClient("localhost", 27017);
		
		MongoDatabase db = client.getDatabase("testDB");
		MongoCollection coll = db.getCollection("movies");
		
		
		
		
	}

}
