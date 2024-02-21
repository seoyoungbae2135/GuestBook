package com.example.guestBook.service;

import com.example.guestBook.entity.GuestBook;
import com.example.guestBook.repository.GuestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    @Autowired
    private GuestRepo guestRepo;

    public GuestBook detail(Long id){
        return guestRepo.findById(id).get();
    }

    public Page<GuestBook> allList(Pageable pageable) {

        return guestRepo.findAllByOrderByIdDesc(pageable);
    }
}
