package com.example.accessingdatamysql.Controller;

import com.example.accessingdatamysql.DTO.Product;
//import com.javatechie.entity.UserInfo;
import com.example.accessingdatamysql.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Room management App!";
    }

//    @PostMapping("/new")
//    public String addNewUser(@RequestBody UserInfo userInfo){
//        return service.addUser(userInfo);
//    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Product> getAllTheProducts() {
        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getProductById(@PathVariable int id) {
        return service.getProduct(id);
    }
}
