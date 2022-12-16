package com.accenture.pocvivoconsumersaveinvoicedata.dominio.ports.repositories;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.Product;
import com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity.ProductEntity;

import java.util.List;

public interface ProductRepositories {

    List<Product> listAll();

    void save(ProductEntity productEntity);


}
