package com.stackroute.userService;

import com.stackroute.userService.SeedData.JsonToJavaObject;
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
