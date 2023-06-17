package com.example.accessingdatamysql.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accessingdatamysql.Entity.Owner;
import com.example.accessingdatamysql.Repository.OwnerRepository;

@Service
public class OwnerService {
    
    @Autowired
    private OwnerRepository ownerRepository;

    public String addOwner(Owner owner) {

        ownerRepository.save(owner);
        return "Owner has been added";
    }

    public String updateOwner(Owner ownerRequest, Integer id) {
        Owner ownerToUpdate = ownerRepository.findById(id).get();
        ownerToUpdate.setEmail(ownerRequest.getEmail());
        ownerToUpdate.setName(ownerRequest.getName());
        ownerRepository.save(ownerToUpdate);
        return "Owner's information has been updated";
    }

    public List<Owner> getAllOwner() {
        return ownerRepository.findAll();
    }
}
