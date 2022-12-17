package com.accenture.pocvivoconsumersaveinvoicedata.dominio.ports.interfaces;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.product.ProductDto;

public interface ProductServicePorts {

    Object findProducts();
    void createProduct(ProductDto productDto);
}
