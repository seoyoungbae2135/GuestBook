package com.example.guestBook.service;

import com.example.guestBook.dto.GuestDto;
import com.example.guestBook.entity.Guest;
import com.example.guestBook.repository.GuestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class VisitService {
    @Autowired
    private GuestImpl guestImpl;

    public void write(GuestDto guestDto){
        Guest guest= guestDto.of();
        guestImpl.save(guest);
    }

    public void delete(Long id){
        guestImpl.deleteById(id);
    }

    public List<GuestDto> findAll(){

        List<GuestDto> guestDtos = new ArrayList<>();
        List<Guest> guests= guestImpl.findAllByOrderByIdDesc();
        Iterator<Guest> it = guests.iterator();
        while(it.hasNext()){
            guestDtos.add( it.next().of());
        }
        return guestDtos;
    }
}
