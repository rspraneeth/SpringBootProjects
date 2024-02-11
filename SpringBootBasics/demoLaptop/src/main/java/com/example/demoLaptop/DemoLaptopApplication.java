package com.example.demoLaptop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoLaptopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoLaptopApplication.class, args);

		Alien a = context.getBean(Alien.class); // even if we comment out this line, spring boot will still create an object and keep it ready
		a.show();

//		Alien a1	 = context.getBean(Alien.class); // object gets created only once, spring framework uses singleton design pattern. to create another object we use prototype scope
//		a1.show();

		//if we comment out both objects a and a1, and since the scope is of prototype(annotation set in alien class), object won't be created, but if scope is not set to prototype(default is singleton) then object will be created once even if we don't create an object
	}

}
