package com.nexmatches.web.api;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Arrays;

@WebListener
public class Scopes implements ServletContextListener {


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		live.page.web.api.Scopes.scopes.addAll(Arrays.asList(
				"email",
				"pm",
				"threads",
				"forums",
				"accounts"
		));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}
}
