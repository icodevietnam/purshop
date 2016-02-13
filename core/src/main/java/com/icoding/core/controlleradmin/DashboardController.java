package com.icoding.core.controlleradmin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.icoding.core.config.UrlMapping;
import com.icoding.core.config.ViewMapping;

@Controller
public class DashboardController {

	@RequestMapping(value = { UrlMapping.DASHBOARD_PAGE_URL }, method = { RequestMethod.GET })
	public String displayDashboardPage(Model model) {
		return ViewMapping.DASHBOARD_PAGE_VIEW;
	}
}
