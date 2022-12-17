package com.accenture.pocvivoconsumersaveinvoicedata.dominio.adapters.services;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.form.ProductForm;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.product.ProductDto;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.ports.interfaces.ProductServicePorts;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.ports.repositories.ProductRepositories;

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
            ProductForm productForm = new ProductForm(productDTO);
            this.productRepositories.save(productForm);
        }
        catch(Exception ex) {
            System.out.println("Something went wrong." + ex);
        }

    }

    @Override
    public List<ProductDto> findProducts() {
        List<ProductForm> productForms = this.productRepositories.listAll();
        List<ProductDto> productDtos = productForms.stream().map(ProductForm::toProdutoDTO).collect(Collectors.toList());
        return productDtos;
    }
}
