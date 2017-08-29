package com.ameya.mongodb;

import java.io.*;
import java.util.*;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerStarter {

	public static void main(String[] args) {

		//Freemarker configuration object
		Configuration cfg = new Configuration();
		try {
			//Load template from source folder
			Template template = cfg.getTemplate("M101J/src/main/java/index.ftl");

			// Build the data-model
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("message", "Hello World!");

			//List parsing 
			List<String> countries = new ArrayList<String>();
			countries.add("India");
			countries.add("United States");
			countries.add("Germany");
			countries.add("France");

			data.put("countries", countries);


			// Console output
			Writer out = new OutputStreamWriter(System.out);
			template.process(data, out);
			out.flush();

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}



	//	public static void main(String[] args) {
	//		Configuration config = new Configuration();
	//		config.setClassForTemplateLoading(FreemarkerStarter.class, "/");
	//		
	//		try {
	////			FileTemplateLoader templateLoader = new FileTemplateLoader(new File("resources"));
	////			config.setTemplateLoader(templateLoader);
	//			Template template = config.getTemplate("src/index.ftl");
	//			StringWriter writer = new StringWriter();
	//			Map<String, Object> map = new HashMap<>();
	//			map.put("name", "Ameya");
	//			
	//			template.process(map, writer);
	//			System.out.println(writer);
	//			
	//		}
	//		catch (Exception e) {
	//			System.out.println(e.getMessage());
	//		}
	//	}

}
