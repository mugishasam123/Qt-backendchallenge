package com.samuel.invoice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samuel.invoice.service.UserService;

@RestController
public class HomeController {
	
	


    @GetMapping("/customers")
    public ResponseEntity<String> HomeController() {


        return new ResponseEntity<>("Welcome to customer Service", HttpStatus.OK);

    }
}
