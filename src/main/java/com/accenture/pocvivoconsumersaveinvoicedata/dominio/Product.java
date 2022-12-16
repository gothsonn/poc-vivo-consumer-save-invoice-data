package com.accenture.pocvivoconsumersaveinvoicedata.dominio;


import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.product.ProductDto;

public class Product {

    private String id;
    private String name;
    private String description;

    public Product() {
    }

    public Product(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Product(ProductDto productDto) {
        this.id = productDto.getId();
        this.name = productDto.getName();
        this.description = productDto.getDescription();
    }

    public ProductDto toProdutoDTO() {
        return new ProductDto(this.id, this.name, this.description);
    }
}
