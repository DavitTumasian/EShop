package com.example.eshop.model;

import javax.persistence.*;

@Entity
@Table(name = "product_entity")
public class ProductEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "product_pic")
    private String productPic;
    @Column(name = "price")
    private double price;
    @Column(name = "product_quantity")
    private int quantity;
    @Column(name = "product_availability")
    private String availability;
    @Column(name = "product_condition")
    private String condition;
    @Column(name = "category_id")
    private long categoryId;
    @Column(name = "brand_id")
    private long brandId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productPic='" + productPic + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", availability='" + availability + '\'' +
                ", condition='" + condition + '\'' +
                ", categoryId=" + categoryId +
                ", bradId=" + brandId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;

        ProductEntity that = (ProductEntity) o;

        if (getId() != that.getId()) return false;
        if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
        if (getQuantity() != that.getQuantity()) return false;
        if (getCategoryId() != that.getCategoryId()) return false;
        if (getBrandId() != that.getBrandId()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getProductPic() != null ? !getProductPic().equals(that.getProductPic()) : that.getProductPic() != null)
            return false;
        if (getAvailability() != null ? !getAvailability().equals(that.getAvailability()) : that.getAvailability() != null)
            return false;
        return getCondition() != null ? getCondition().equals(that.getCondition()) : that.getCondition() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getProductPic() != null ? getProductPic().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getQuantity();
        result = 31 * result + (getAvailability() != null ? getAvailability().hashCode() : 0);
        result = 31 * result + (getCondition() != null ? getCondition().hashCode() : 0);
        result = 31 * result + (int) (getCategoryId() ^ (getCategoryId() >>> 32));
        result = 31 * result + (int) (getBrandId() ^ (getBrandId() >>> 32));
        return result;
    }
}
