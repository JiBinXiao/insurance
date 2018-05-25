package com.cr.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class InsuranceApplication {

	   public static void main(String[] args) {
		   SpringApplication.run(InsuranceApplication.class, args);
	    }
}
