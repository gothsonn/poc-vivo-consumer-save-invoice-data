package com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.repositories;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.form.ProductForm;
import com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringProductRepositories extends MongoRepository<ProductEntity, String> {
    public List<ProductForm> listAll();
    public void saveProduct(ProductForm productForm);
}
