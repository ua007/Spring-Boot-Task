package com.stackroute.trackService;

import com.stackroute.trackService.SeedData.JsonToJavaObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackServiceApplication {

	public static void main(String[] args){
		JsonToJavaObject jsonToJavaObject=new JsonToJavaObject();
		jsonToJavaObject.JsonObject();
		SpringApplication.run(TrackServiceApplication.class, args);

	}

}
