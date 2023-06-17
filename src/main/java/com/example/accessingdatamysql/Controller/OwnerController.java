package com.example.accessingdatamysql.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.Entity.Owner;
import com.example.accessingdatamysql.Repository.OwnerRepository;

import com.example.accessingdatamysql.Service.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/register")
    public String addNewOwner(@RequestBody Owner owner) {
            return ownerService.addOwner(owner);
    }

    @PutMapping("/update/{id}")
    public String updateOwner(@RequestBody Owner ownerRequest, @PathVariable Integer id ) {
        return ownerService.updateOwner(ownerRequest, id);
    }

    @GetMapping("/all")
    public List<Owner> getAllOwner() {
        return ownerService.getAllOwner();
    }

}
