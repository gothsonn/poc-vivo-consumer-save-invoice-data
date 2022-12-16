package com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.Product;
import com.accenture.pocvivoconsumersaveinvoicedata.dominio.dtos.product.ProductDto;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Document(collection="Product")
public class ProductEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String name;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductEntity() {
    }

    public ProductEntity(Product product) {
        this.id = product.getId();
        this.name = product.getName();;
        this.description = product.getDescription();
    }

    public void update(Product product) {
        this.id = product.getId();
        this.name = product.getName();;
        this.description = product.getDescription();
    }



    public Product toProduto() {
        return new Product(this.id, this.name, this.description);
    }

}
