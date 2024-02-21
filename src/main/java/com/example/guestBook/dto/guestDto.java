package com.example.guestBook.dto;

import com.example.guestBook.entity.GuestBook;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Data
public class GuestDto {
    private Long id;
    private String name;
    private String content;
    private LocalDateTime regDate;

    private static ModelMapper mapper = new ModelMapper();

    public static GuestDto of(GuestBook guest){
        return mapper.map(guest , GuestDto.class);
    }
}
