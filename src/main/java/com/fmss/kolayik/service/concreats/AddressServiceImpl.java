package com.fmss.kolayik.service.concreats;
import com.fmss.kolayik.repository.AddressRepository;

import com.fmss.kolayik.service.abstracts.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}

