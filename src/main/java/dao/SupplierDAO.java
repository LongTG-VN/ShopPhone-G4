/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Supplier;
import utils.DBContext;

/**
 *
 * @author LE HOANG NHAN
 */
public class SupplierDAO extends DBContext {

    // READ ALL
    public List<Supplier> getAllSuppliers() {
        List<Supplier> list = new ArrayList<>();
        String sql = "SELECT * FROM suppliers";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Supplier s = new Supplier(
                        rs.getInt("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("contact_email"),
                        rs.getString("address")
                );
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // GET BY ID 
    public Supplier getSupplierById(int id) {
        String sql = "SELECT * FROM suppliers WHERE supplier_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Supplier(
                        rs.getInt("supplier_id"),
                        rs.getString("supplier_name"),
                        rs.getString("contact_email"),
                        rs.getString("address")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // CREATE
    public void insertSupplier(Supplier s) {
        String sql = "INSERT INTO suppliers (supplier_name, contact_email, address) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getSupplier_name());
            ps.setString(2, s.getContact_email());
            ps.setString(3, s.getAddress());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE (EDIT)
    public void updateSupplier(Supplier s) {
        String sql = "UPDATE suppliers SET supplier_name = ?, contact_email = ?, address = ? WHERE supplier_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getSupplier_name());
            ps.setString(2, s.getContact_email());
            ps.setString(3, s.getAddress());
            ps.setInt(4, s.getSupplier_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteSupplier(int id) {
        String sql = "DELETE FROM suppliers WHERE supplier_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TEST
    public static void main(String[] args) {
        SupplierDAO dao = new SupplierDAO();

        // INSERT
//        dao.insertSupplier(new Supplier(0, "Test Supplier", "test@mail.com", "HCM"));
        // UPDATE
//        dao.updateSupplier(new Supplier(1, "Supplier Updated", "update@mail.com", "Ha Noi"));
        // GET BY ID
//        System.out.println(dao.getSupplierById(1));
        // DELETE
//        dao.deleteSupplier(3);
        // GET ALL
        List<Supplier> list = dao.getAllSuppliers();
        for (Supplier s : list) {
            System.out.println(s);
        }

    }
}
