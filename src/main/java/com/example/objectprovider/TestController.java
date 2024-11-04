package com.example.objectprovider;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

	private final ObjectProvider<List<BeanInterface>> objectProvider;

	private List<BeanInterface> beansCache;

	public TestController(ObjectProvider<List<BeanInterface>> objectProvider) {
		this.objectProvider = objectProvider;
	}

	@GetMapping("/cached-beans")
	public String cachedBeans() {
		List<BeanInterface> beans = getCachedBeans();
		return "Hello you beautiful " + beans.size() + " beans";
	}

	@GetMapping("/beans")
	public String beans() {
		List<BeanInterface> beans = objectProvider.getIfAvailable();
		return "Hello you beautiful " + beans.size() + " beans";
	}


	private List<BeanInterface> getCachedBeans() {
		if (beansCache == null) {
			beansCache = objectProvider.getIfAvailable();
		}
		return beansCache;
	}

}
