/*
 * Copyright 2019 Laurent PAGE, Apache Licence 2.0
 */
package com.nexmatches.web.template;

import live.page.web.system.cosmetic.tmpl.BaseTemplate;

import javax.servlet.annotation.WebListener;

@WebListener
public class MatchesTemplate extends BaseTemplate {

	public MatchesTemplate() {
		setTemplate(this);
	}

	@Override
	public Class[] getUserDirective() {
		return new Class[]{};
	}

	@Override
	public Class getUserFx() {
		return FxTemplate.class;
	}

}
