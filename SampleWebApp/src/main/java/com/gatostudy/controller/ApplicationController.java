package com.gatostudy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
@RequestMapping("/")
public class ApplicationController {

	@RequestMapping(value = "/getSession", method = RequestMethod.GET)
	public String getSession(ModelMap model) {

		// get session id create automatically by load balancer
		String sessionId = RequestContextHolder.currentRequestAttributes()
				.getSessionId();
		// get date, month, year, hour, minute, second, and millisecond
		String currDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS")
				.format(new Date());
		model.addAttribute("msgArgument",
				"Maven Java Web Application Project:Session id is "
						+ sessionId + " current date is " + currDate);

		return "index";
	}

	@RequestMapping(value = "/Test", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("msgArgument",
				"Maven Java Web Application Project: Success!");

		return "index";
	}

	@RequestMapping(value = "/Print/{arg}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String arg, ModelMap model) {
		model.addAttribute("msgArgument",
				"Maven Java Web Application Project, input variable: " + arg);

		return "index";
	}
}
