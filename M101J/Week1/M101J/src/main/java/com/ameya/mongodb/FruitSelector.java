package com.ameya.mongodb;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class FruitSelector {

	public static void main(String[] args) {
		final Configuration config = new Configuration();
		config.setClassForTemplateLoading(FruitSelector.class, "/");


		Spark.get("/", new Route() {
			public Object handle(final Request request, final Response response) throws Exception {
				try {
					Map<String, Object> map = new HashMap<>();
					map.put("fruits", Arrays.asList("Apple", "Orange", "Mango", "Banana"));
					
					Template template = config.getTemplate("Picker.ftl");
					StringWriter writer = new StringWriter();
					template.process(map, writer);
					
					return writer;
				}
				catch (Exception e) {
					e.getMessage();
					return null;
				}
			}
		});
		
		Spark.post("/favFruit", new Route() {
			public Object handle(Request request, Response response) throws Exception {
				final String fruit = request.queryParams("fruit");
				if (fruit == null) {
					return "Y U NO PICK SOMETHING??";
				}
				else {
					return "Your favorite fruit is " + fruit;
				}			}
		});
	}
}