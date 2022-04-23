package com.f1distributedsystem.f1clientapp;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class F1ClientAppApplication {

	public static void main(String[] args) {
		Application.launch(ApplicationUi.class,args);
	}

}
