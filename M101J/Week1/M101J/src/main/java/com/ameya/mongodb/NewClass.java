package com.ameya.mongodb;

import spark.Spark;
import spark.Request;
import spark.Response;
import spark.Route;

public class NewClass {
	public static void main(String[] args) {
		
		Spark.get("/", new Route() {
			public Object handle(Request request, Response response) throws Exception {
				return "Hello World from Spark";
			}
		});
	}

}
