package com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.form.ProductForm;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Product")
public class ProductEntity {
    @Id
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

    public ProductEntity(ProductForm productForm) {
        this.id = productForm.getId();
        this.name = productForm.getName();;
        this.description = productForm.getDescription();
    }

    public void update(ProductForm productForm) {
        this.id = productForm.getId();
        this.name = productForm.getName();;
        this.description = productForm.getDescription();
    }



    public ProductForm toProduto() {
        return new ProductForm(this.id, this.name, this.description);
    }

}
