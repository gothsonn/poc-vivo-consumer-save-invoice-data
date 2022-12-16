package com.accenture.pocvivoconsumersaveinvoicedata.dominio.ports.repositories;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.form.ProductForm;

import java.util.List;

public interface ProductRepositories {

    List<ProductForm> listAll();
    void save(ProductForm productForm);

}
