package com.nexmatches.utils;

import com.mongodb.client.model.Sorts;
import live.page.web.admin.utils.Scrapper;
import live.page.web.system.db.Db;
import live.page.web.system.json.Json;
import live.page.web.utils.Fx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ScrapperCron {

	private final static ExecutorService services = Executors.newSingleThreadExecutor();

	static {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> Fx.shutdownService(services)));
	}

	public static void scrap() {
		services.submit(() -> {
			while (true) {
				List<Json> scraps = Db.find("Scraps").sort(Sorts.ascending("last")).limit(100).into(new ArrayList<>());
				for (Json scrap : scraps) {
					if (services.isTerminated() || services.isShutdown()) {
						throw new InterruptedException("");
					}
					Fx.log("Scrap " + scrap.getString("url"));
					Scrapper.scrapAndPost(scrap);
				}
				Fx.log("Scrap sleep " + new Date().toString());

				Thread.sleep(10L * 60L * 1000L);

			}
		});
	}
}
