package com.example.guestBook.repository;

import com.example.guestBook.entity.GuestBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepo extends JpaRepository<GuestBook, Long> {
    Page<GuestBook> findAllByOrderByIdDesc(Pageable pageable);
}
