package com.ionia.alivee.service;

import com.ionia.alivee.model.Link;

public interface LinkService {
	
	public Link saveLink(Link link);

	public String getUrl(String linkId) throws LinkServiceException;
	
	public boolean doesLinkExist(String linkId);
}
