package com.accenture.pocvivoconsumersaveinvoicedata.dominio.adapters.services;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.Product;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.product.ProductDto;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.ports.interfaces.ProductServicePorts;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.ports.repositories.ProductRepositories;
import com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductServicePorts {

    private final ProductRepositories productRepositories;

    public ProductServiceImpl(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    @Override
    public void createProduct(ProductDto productDTO) {
        try{
            ProductEntity productEntity = new ProductEntity(productDTO);
            this.productRepositories.save(productEntity);
        }
        catch(Exception ex) {
            System.out.println("Something went wrong." + ex);
        }

    }

    @Override
    public List<ProductDto> findProducts() {
        List<Product> produtos = this.productRepositories.listAll();
        List<ProductDto> productDtos = produtos.stream().map(Product::toProdutoDTO).collect(Collectors.toList());
        return productDtos;
    }
}
