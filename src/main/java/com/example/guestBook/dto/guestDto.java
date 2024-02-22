package com.example.guestBook.dto;

import com.example.guestBook.entity.Guest;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class GuestDto {
    private Long id;

    @NotEmpty(message="작성자를 입력하세요")
    private String writer;
    @NotEmpty(message="내용을입력하세요")
    private String content;
    private LocalDateTime writeDate;

    private static ModelMapper mapper=new ModelMapper();
    public Guest of(){
        this.writeDate=LocalDateTime.now();
        return mapper.map(this, Guest.class);
    }
}