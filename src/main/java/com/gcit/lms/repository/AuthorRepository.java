package com.gcit.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

	Author findByAuthorId(Integer authorId);
	List<Author> findAllByAuthorName(String authorName);
	
	
}
