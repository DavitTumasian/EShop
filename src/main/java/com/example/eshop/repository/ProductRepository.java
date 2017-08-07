package com.example.eshop.repository;

import com.example.eshop.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByCategoryId(long id);
    List<ProductEntity> findAllByBrandId(long id);
    @Modifying
    @Transactional
    @Query("update ProductEntity pr set pr.name=:qName, pr.productPic=:qProductPic, pr.price=:qPrice, pr.quantity=:qQuantity," +
            "pr.availability=:qAvailability, pr.condition=:qCondition, pr.categoryId=:qCategoryId, pr.brandId=:qBrandId where pr.id=:qId")
    public void updateProductEntity(@Param("qName") String name, @Param("qProductPic") String productPic,
                           @Param("qPrice") Double price, @Param("qQuantity") Integer quantity,
                                    @Param("qAvailability") String availability, @Param("qCondition") String condition,
                                    @Param("qCategoryId") Long categoryId, @Param("qBrandId") Long brandId, @Param("qId") Long id);
}


