/*
 * Copyright 2019 Laurent PAGE, Apache Licence 2.0
 */
package com.nexmatches;

import com.nexmatches.utils.ScrapperCron;
import live.page.notice.Notices;

public class Cron {

	public static void main(String[] args) {
		ScrapperCron.scrap();
		Notices.cron();
	}
}
