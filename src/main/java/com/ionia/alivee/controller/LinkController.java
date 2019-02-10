package com.ionia.alivee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ionia.alivee.model.Link;
import com.ionia.alivee.service.LinkService;
import com.ionia.alivee.util.URLUtil;

@Controller
@RequestMapping("/api")
public class LinkController {

	private LinkService linkService;

	@RequestMapping(value = "/createLink", method = RequestMethod.GET, produces = { "application/json" })
	public @ResponseBody Link createLink(@RequestParam(value = "linkId", required = true) String linkId,
			@RequestParam(value = "url", required = true) String url) {

		if (URLUtil.isURLValid(url)) {
			return null;
		}

		if (linkService.doesLinkExist(linkId)) {
			return null;
			
		}
		
		return linkService.saveLink(new Link(linkId, url));
	}
	
	@RequestMapping(value = "/doesLinkExist", method = RequestMethod.GET)
	public @ResponseBody boolean doesLinkExist(@RequestParam(value = "linkId", required = true) String linkId) {
		return linkService.doesLinkExist(linkId);
	}
	
	@RequestMapping(value = "/isUrlValid", method = RequestMethod.GET)
	public @ResponseBody boolean isUrlValid(@RequestParam(value = "url", required = true) String url) {
		return URLUtil.isURLValid(url);
	}

	@Autowired
	@Qualifier("linkService")
	public void setLinkService(LinkService linkService) {
		this.linkService = linkService;
	}

}
