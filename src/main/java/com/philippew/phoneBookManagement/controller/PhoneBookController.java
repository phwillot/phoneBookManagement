package com.philippew.phoneBookManagement.controller;

import com.philippew.phoneBookManagement.pojo.Person;
import com.philippew.phoneBookManagement.service.PhoneBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PhoneBookController {

    @Autowired
    PhoneBookService phoneBookService;

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("person", phoneBookService.getPersonById(id));
        return "form";
    }

    @GetMapping("/phonebook")
    public String getPhoneBook(Model model) {
        model.addAttribute("phonebook", phoneBookService.getWholePhoneBook());
        return "phonebook";
    }

    @PostMapping("/submitForm")
    public String handleSubmit(@Valid Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        phoneBookService.submitPerson(person);
        return "redirect:/phonebook";
    }
}
