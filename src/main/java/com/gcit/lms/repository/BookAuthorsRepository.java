package com.gcit.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gcit.lms.entity.BookAuthors;
import com.gcit.lms.entity.BookCopies;

@Repository
public interface BookAuthorsRepository extends JpaRepository<BookAuthors, Integer>{

}
