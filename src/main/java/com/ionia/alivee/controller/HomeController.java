package com.ionia.alivee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ionia.alivee.service.LinkService;
import com.ionia.alivee.service.LinkServiceException;

@Controller
public class HomeController {

	private LinkService linkService;

	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@GetMapping(value = "/{linkId}")
	public String homeOrRedirect(HttpServletRequest request, @PathVariable("linkId") String linkId, ModelMap model) {
		if (linkId == null || linkId.isEmpty()) {
			return welcome();
		}
		
		String url;
		try {
			url = linkService.getUrl(linkId);
			url = "redirect:".concat(url);
		} catch (LinkServiceException ex) {
			url = "index";
		}
		return url;
	}

	@Autowired
	@Qualifier("linkService")
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}
}
