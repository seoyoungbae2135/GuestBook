package com.example.guestBook.repository;

import com.example.guestBook.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestImpl extends JpaRepository<Guest,Long> {

    List<Guest> findAllByOrderByIdDesc();
}