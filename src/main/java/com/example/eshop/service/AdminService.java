package com.example.eshop.service;


import com.example.eshop.model.BrandEntity;
import com.example.eshop.model.CategoryEntity;
import com.example.eshop.model.ProductEntity;
import com.example.eshop.repository.BrandRepository;
import com.example.eshop.repository.CategoryRepository;
import com.example.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.soap.SAAJResult;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    ProductRepository productRepository;

    public List<CategoryEntity> getAllCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        return categoryEntities;
    }

    public List<BrandEntity> getAllBrands() {
        List<BrandEntity> brandEntities = brandRepository.findAll();
        return brandEntities;
    }

    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities;
    }

    public void addCategory(CategoryEntity categoryEntity) {
        categoryRepository.saveAndFlush(categoryEntity);
    }

    public void addBrand(BrandEntity brandEntity) {
        brandRepository.saveAndFlush(brandEntity);
    }

    public void addProduct(ProductEntity productEntity) {
        productRepository.saveAndFlush(productEntity);
    }

    public void deleteCategory(CategoryEntity categoryEntity) {
        categoryRepository.delete(categoryEntity);
    }

    public void deleteBrand(BrandEntity brandEntity) {
        brandRepository.delete(brandEntity);
    }

    public void deleteProduct(ProductEntity productEntity) {
        productRepository.delete(productEntity);
    }

    public ProductEntity getProductEntityById(Long id) {
        return productRepository.getOne(id);
    }

    public void updateProduct(Long id, String name, String productPic, Double price, Integer quantity, String avilability, String condition,
                              Long categoriId, Long brandId) {
        productRepository.updateProductEntity(name, productPic, price, quantity, avilability, condition, categoriId, brandId, id);
    }
}
