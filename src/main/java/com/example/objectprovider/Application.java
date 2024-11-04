package com.example.objectprovider;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		for (int i = 0; i < 100; i++) {
			beanFactory.registerSingleton("testbean" + i, new BeanInterface() {});
		}
	}

}
