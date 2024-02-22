package com.example.guestBook.control;

import com.example.guestBook.dto.GuestDto;
import com.example.guestBook.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class VisitController {
    @Autowired
    private VisitService visitService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute( "list",visitService.findAll());
        model.addAttribute("guestDto",new GuestDto());
        return "index";
    }

    @PostMapping("/write")
    public String write(@Valid GuestDto guestDto, BindingResult bindingResult,
                        Model model){
        if(bindingResult.hasErrors()){
            return "index";
        }
        visitService.write(guestDto);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        visitService.delete(id);
        return "redirect:/";
    }
}
