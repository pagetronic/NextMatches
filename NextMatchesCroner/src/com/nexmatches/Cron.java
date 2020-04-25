/*
 * Copyright 2019 Laurent PAGE, Apache Licence 2.0
 */
package com.nexmatches;

import live.page.web.admin.utils.Scrapper;
import live.page.notice.Notices;

public class Cron {

	public static void main(String[] args) {
		Scrapper.scrap();
		Notices.cron();
	}
}
