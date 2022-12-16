package com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.repositories;

import com.accenture.pocvivoconsumersaveinvoicedata.dominio.Product;
import com.accenture.pocvivoconsumersaveinvoicedata.infrastructure.adapters.entity.ProductEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProductRepositories implements SpringProductRepositories {

    private final SpringProductRepositories springProductRepositories;

    public ProductRepositories(SpringProductRepositories springProductRepositories) {
        this.springProductRepositories = springProductRepositories;
    }

    @Override
    public List<Product> listAll() {
        List<ProductEntity> produtoEntities = this.springProductRepositories.findAll();
        return produtoEntities.stream().map(ProductEntity::toProduto).collect(Collectors.toList());
    }

    @Override
    public void saveProduct(Product product) {
        ProductEntity productEntity;
        if (Objects.isNull(product.getId()))
            productEntity = new ProductEntity(product);
        else {
            productEntity = this.springProductRepositories.findById(product.getId()).get();
            productEntity.update(product);
        }

        this.springProductRepositories.save(productEntity);
    }

    @Override
    public <S extends ProductEntity> S save(S entity) {
        return null;
    }

    @Override
    public List<ProductEntity> findAll() {
        return null;
    }

    @Override
    public <S extends ProductEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ProductEntity> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<ProductEntity> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(ProductEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProductEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<ProductEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProductEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductEntity> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends ProductEntity> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends ProductEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProductEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends ProductEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ProductEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProductEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends ProductEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ProductEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
