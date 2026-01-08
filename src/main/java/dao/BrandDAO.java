/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Brand;
import utils.DBContext;

/**
 *
 * @author CT
 */
public class BrandDAO extends DBContext {

    public List<Brand> getAllBrand() {
        List<Brand> list = new ArrayList<>();
        String sql = "SELECT * FROM brands";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int brand_id = rs.getInt("brand_id");
                String brand_name = rs.getString("brand_name");
                String logo_url = rs.getString("logo_url");
                Brand brand = new Brand(brand_id, brand_name, logo_url);
                list.add(brand);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Brand getBrandById(int id) {
        String sql = "SELECT * FROM brands WHERE brand_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Brand(
                        rs.getInt("brand_id"),
                        rs.getString("brand_name"),
                        rs.getString("logo_url")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertBrand(Brand b) {
        String sql = "INSERT INTO brands(brand_name, logo_url) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getBrand_name());
            ps.setString(2, b.getLogo_url());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBrand(Brand b) {
        String sql = "UPDATE brands SET brand_name = ?, logo_url = ? WHERE brand_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getBrand_name());
            ps.setString(2, b.getLogo_url());
            ps.setInt(3, b.getBrand_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBrand(int id) {
        String sql = "DELETE FROM brands WHERE brand_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BrandDAO a = new BrandDAO();

        // Delete 
//         a.deleteBrand(3);
        // Insert
//         a.insertBrand(new Brand(5,"Fuju", "fuji_logo.png"));
        // Update
//         a.updateBrand(new Brand(5, "Oppo", "oppo_logo.png"));
        // Get by ID
//         System.out.println(a.getBrandById(1));
        // Get all brand    
        List<Brand> list = a.getAllBrand();
        for (Brand object : list) {
            System.out.println(object);
        }
    }
}
