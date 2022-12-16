package com.accenture.pocvivoconsumersaveinvoicedata.adapters.controllers;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.product.ProductDto;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.ports.interfaces.ProductServicePorts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProductController {

    @Autowired
    private ProductServicePorts productServicePorts;

    @PostMapping
    public void createProducts(@RequestBody ProductDto productDto) {
        productServicePorts.createProduct(productDto);
    }

    @GetMapping
    List<ProductDto> getProducts() {
        return (List<ProductDto>) productServicePorts.findProducts();
    }

}
