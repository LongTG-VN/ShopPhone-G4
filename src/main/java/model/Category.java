/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LE HOANG NHAN
 */
public class Category {

    private int category_id;
    private String category_Name;
    private String slug;

    public Category() {
    }

    public Category(int category_id, String category_Name, String slug) {
        this.category_id = category_id;
        this.category_Name = category_Name;
        this.slug = slug;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_Name() {
        return category_Name;
    }

    public void setCategory_Name(String category_Name) {
        this.category_Name = category_Name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Category{" + "category_id=" + category_id + ", category_Name=" + category_Name + ", slug=" + slug + '}';
    }

}
