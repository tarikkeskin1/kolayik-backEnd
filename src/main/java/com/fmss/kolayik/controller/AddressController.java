package com.fmss.kolayik.controller;

import com.fmss.kolayik.service.abstracts.AddressService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AddressController {
    private final AddressService addressService;


    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
}
