package com.example.guestBook.entity;


import com.example.guestBook.dto.GuestDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class GuestBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false , length = 50)
    private String name;
    @Column
    private String content;
    @Column
    private LocalDateTime regDate;

    private static ModelMapper modelMapper=new ModelMapper();

    public static GuestBook of(GuestDto guestDto){
        guestDto.setRegDate(LocalDateTime.now());
        return modelMapper.map(guestDto, GuestBook.class);
    }
}
