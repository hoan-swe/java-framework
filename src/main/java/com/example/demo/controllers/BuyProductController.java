package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class BuyProductController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/buyProduct")
    public String buyNow(@RequestParam("productID") int pId){
        ProductService pService = context.getBean(ProductServiceImpl.class);
        Product p = pService.findById(pId);

        if(p.getInv() > 0){
            p.setInv(p.getInv() - 1);
            pService.save(p);
            return "buysuccess";
        }
        else{
            return "buyfailure";
        }
    }
}
