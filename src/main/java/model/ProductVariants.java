/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class ProductVariants {

    private int variantId;
    private product product;
    private String color;
    private String storage_capacity;
    private String sku;
    private double original_price;
    private double price;
    private String imgURL;
    private int stock_quantity;
    private byte is_active;
    private LocalDateTime created_at;

    public ProductVariants() {
    }

    public ProductVariants(int variantId, product product, String color, String storage_capacity, String sku, double original_price, double price, String imgURL, int stock_quantity, byte is_active, LocalDateTime created_at) {
        this.variantId = variantId;
        this.product = product;
        this.color = color;
        this.storage_capacity = storage_capacity;
        this.sku = sku;
        this.original_price = original_price;
        this.price = price;
        this.imgURL = imgURL;
        this.stock_quantity = stock_quantity;
        this.is_active = is_active;
        this.created_at = created_at;
    }

    public int getVariantId() {
        return variantId;
    }

    public void setVariantId(int variantId) {
        this.variantId = variantId;
    }

    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStorage_capacity() {
        return storage_capacity;
    }

    public void setStorage_capacity(String storage_capacity) {
        this.storage_capacity = storage_capacity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getOriginal_price() {
        return original_price;
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(int stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public byte getIs_active() {
        return is_active;
    }

    public void setIs_active(byte is_active) {
        this.is_active = is_active;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "ProductVariants{" + "variantId=" + variantId + ", product=" + product + ", color=" + color + ", storage_capacity=" + storage_capacity + ", sku=" + sku + ", original_price=" + original_price + ", price=" + price + ", imgURL=" + imgURL + ", stock_quantity=" + stock_quantity + ", is_active=" + is_active + ", created_at=" + created_at + '}';
    }
    
    
    
}
