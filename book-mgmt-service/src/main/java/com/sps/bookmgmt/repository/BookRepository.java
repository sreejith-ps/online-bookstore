package com.sps.bookmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sps.bookmgmt.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

}
