/*
 * Copyright 2019 Laurent PAGE, Apache Licence 2.0
 */
package com.nexmatches.web;

import com.mongodb.client.model.Filters;
import live.page.web.content.pages.PagesAggregator;
import live.page.web.content.posts.utils.ThreadsAggregator;
import live.page.web.system.servlet.HttpServlet;
import live.page.web.system.servlet.wrapper.WebServletRequest;
import live.page.web.system.servlet.wrapper.WebServletResponse;
import live.page.web.system.Settings;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = {"/answered"}, displayName = "answered")
public class AnsweredServlet extends HttpServlet {
	@Override
	public void doGetPublic(WebServletRequest req, WebServletResponse resp) throws IOException {

		req.setAttribute("active", "answered");


		resp.setStatus(200);
		req.setRobotsIndex(req.getQueryString() == null, true);
		req.setCanonical("/answered", "paging");

		req.setAttribute("pages", PagesAggregator.getPages(Filters.eq("lng", Settings.getLang(req.getServerName())), 40, null));
		req.setAttribute("threads", ThreadsAggregator.getThreads(
				Filters.and(
						Filters.gt("replies", 0),
						Filters.eq("lng", Settings.getLang(req.getServerName())),
						Filters.exists("remove", false),
						Filters.regex("parents", Pattern.compile("^Forums\\("))
				),
				req.getString("paging", null), false)
		);

		resp.sendTemplate(req, "/index.html");

	}

}
