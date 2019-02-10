package com.ionia.alivee.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ionia.alivee.model.Link;
import com.ionia.alivee.repository.LinkRepository;

@Service("linkService")
public class LinkServiceImpl implements LinkService {

	private LinkRepository linkRepository;

	@Override
	public Link saveLink(Link link) {
		return linkRepository.save(link);
	}

	@Override
	public String getUrl(String linkId) throws LinkServiceException {
		try {
			Link link = linkRepository.getOne(linkId);
			return link.getUrl();
		} catch (EntityNotFoundException ex) {
			throw new LinkServiceException();
		}
	}

	@Override
	public boolean doesLinkExist(String linkId) {
		return linkRepository.existsById(linkId);
	}

	@Autowired
	@Qualifier("linkRepository")
	public void setLinkRepository(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}
}
