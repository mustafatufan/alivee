package com.ionia.alivee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ionia.alivee.model.Link;

@Repository("linkRepository")
public interface LinkRepository extends JpaRepository<Link, String> {

}
