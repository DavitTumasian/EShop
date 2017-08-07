package com.example.eshop.service;

import com.example.eshop.model.BrandEntity;
import com.example.eshop.model.CategoryEntity;
import com.example.eshop.model.ProductEntity;
import com.example.eshop.repository.BrandRepository;
import com.example.eshop.repository.CategoryRepository;
import com.example.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    public List<CategoryEntity> getAllCategoryEntities() {
        return categoryRepository.findAll();
    }
    public List<BrandEntity> getAllBrandEntities() {
        return brandRepository.findAll();
    }
    public List<ProductEntity> getAllProductEntities() {
        return productRepository.findAll();
    }

    public List<ProductEntity> getProductEntityListByCategoryId(long id) {
        return productRepository.findAllByCategoryId(id);
    }

    public List<ProductEntity> getProductEntityListByBrandId(long id) {
        return productRepository.findAllByBrandId(id);
    }


}
