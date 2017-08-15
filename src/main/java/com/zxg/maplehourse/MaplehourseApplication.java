package com.zxg.maplehourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MaplehourseApplication {


//	@RequestMapping(value = "/user")
//	public String name(){
//
//		return "Hello world!";
//	}
	public static void main(String[] args) {
		SpringApplication.run(MaplehourseApplication.class, args);
	}


}
