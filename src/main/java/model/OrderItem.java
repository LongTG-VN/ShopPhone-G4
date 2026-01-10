/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class OrderItem {
       private int orderItemId;
       private Order order;
       private ProductVariants productVariants;
       private int quantity;
       private double price;

    public OrderItem() {
    }

    public OrderItem(int orderItemId, Order order, ProductVariants productVariants, int quantity, double price) {
        this.orderItemId = orderItemId;
        this.order = order;
        this.productVariants = productVariants;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ProductVariants getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(ProductVariants productVariants) {
        this.productVariants = productVariants;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "orderItemId=" + orderItemId + ", order=" + order + ", productVariants=" + productVariants + ", quantity=" + quantity + ", price=" + price + '}';
    }
       
       
}
