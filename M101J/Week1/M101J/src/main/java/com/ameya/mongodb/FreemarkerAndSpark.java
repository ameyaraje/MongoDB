package com.ameya.mongodb;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class FreemarkerAndSpark {

	public static void main(String[] args) {

		final Configuration config = new Configuration();
		config.setClassForTemplateLoading(FreemarkerAndSpark.class, "/");

		Spark.get("/", new Route() {
			public Object handle(final Request request, final Response response) throws Exception {
				StringWriter writer = new StringWriter();
				try {
					Template template = config.getTemplate("index.ftl");
					Map<String, Object> map = new HashMap<>();
					map.put("name", "Ameya");

					template.process(map, writer);
					System.out.println(writer);

				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
				return writer;
			}
		});
	}

}
