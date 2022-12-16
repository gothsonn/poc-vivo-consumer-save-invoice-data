package com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.Product;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.product.ProductDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Entity
@Document(collection="Product")
public class ProductEntity {

    @Id
    private String id;

    private String name;

    private String description;

    public ProductEntity() {
    }

    public ProductEntity(ProductDto productDto) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ProductEntity(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Product toProduto() {
        return new Product(this.id, this.name, this.description);
    }

}
