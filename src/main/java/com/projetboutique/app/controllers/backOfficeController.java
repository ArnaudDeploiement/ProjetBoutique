package com.projetboutique.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class backOfficeController {


    @GetMapping
    public String viewBackOffice() {
        return "backoffice";
    }


}
