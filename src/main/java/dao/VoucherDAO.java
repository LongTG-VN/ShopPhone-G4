/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Voucher;
import utils.DBContext;

/**
 *
 * @author WIN11
 */
public class VoucherDAO extends DBContext {

    // ===== GET ALL =====
    public List<Voucher> getAllVoucher() {
        List<Voucher> list = new ArrayList<>();
        String sql = "SELECT * FROM vouchers";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Voucher(
                        rs.getInt("voucher_id"),
                        rs.getString("code"),
                        rs.getInt("discount_percent"),
                        rs.getDouble("max_discount_amount"),
                        rs.getDouble("min_order_value"),
                        rs.getTimestamp("valid_from"),
                        rs.getTimestamp("valid_to"),
                        rs.getBoolean("is_active")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ===== GET BY ID =====
    public Voucher getVoucherById(int id) {
        String sql = "SELECT * FROM vouchers WHERE voucher_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Voucher(
                        rs.getInt("voucher_id"),
                        rs.getString("code"),
                        rs.getInt("discount_percent"),
                        rs.getDouble("max_discount_amount"),
                        rs.getDouble("min_order_value"),
                        rs.getTimestamp("valid_from"),
                        rs.getTimestamp("valid_to"),
                        rs.getBoolean("is_active")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ===== INSERT =====
    public void insertVoucher(Voucher v) {
        String sql = """
            INSERT INTO vouchers
            (code, discount_percent, max_discount_amount,
             min_order_value, valid_from, valid_to, is_active)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, v.getCode());
            ps.setInt(2, v.getDiscountPercent());
            ps.setDouble(3, v.getMaxDiscountAmount());
            ps.setDouble(4, v.getMinOrderValue());
            ps.setTimestamp(5, v.getValidFrom());
            ps.setTimestamp(6, v.getValidTo());
            ps.setBoolean(7, v.isIsActive());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateVoucher(Voucher v) {
        String sql = """
            UPDATE vouchers
            SET code=?, discount_percent=?, max_discount_amount=?,
                min_order_value=?, valid_from=?, valid_to=?, is_active=?
            WHERE voucher_id=?
        """;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, v.getCode());
            ps.setInt(2, v.getDiscountPercent());
            ps.setDouble(3, v.getMaxDiscountAmount());
            ps.setDouble(4, v.getMinOrderValue());
            ps.setTimestamp(5, v.getValidFrom());
            ps.setTimestamp(6, v.getValidTo());
            ps.setBoolean(7, v.isIsActive());
            ps.setInt(8, v.getVoucherId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===== DELETE =====
    public void deleteVoucher(int id) {
        String sql = "DELETE FROM vouchers WHERE voucher_id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ===== TEST  =====
    private static final String VOUCHER_FORMAT
            = "%-4d | %-10s | %-9s | %-14.2f | %-10.2f | %-23s | %-23s | %-7s%n";

    public static void main(String[] args) {
        VoucherDAO a = new VoucherDAO();
        System.out.printf(
                "%-4s | %-10s | %-9s | %-14s | %-10s | %-23s | %-23s | %-7s%n",
                "ID", "CODE", "DISCOUNT", "MAX_DISCOUNT",
                "MIN_ORDER", "VALID_FROM", "VALID_TO", "ACTIVE"
        );

        // GetAll
        List<Voucher> list = a.getAllVoucher();
        for (Voucher v : list) {
            System.out.printf(
                    "%-4d | %-10s | %-9s | %-14.2f | %-10.2f | %-23s | %-23s | %-7s%n",
                    v.getVoucherId(),
                    v.getCode(),
                    v.getDiscountPercent() + "%",
                    v.getMaxDiscountAmount(),
                    v.getMinOrderValue(),
                    v.getValidFrom(),
                    v.getValidTo(),
                    v.isIsActive()
            );
        }
//         //Insert
//        a.insertVoucher(new Voucher(
//                0, "SALE101", 10, 50000, 200000,
//                Timestamp.valueOf("2025-01-20 00:00:00"),
//                Timestamp.valueOf("2025-12-31 23:59:59"),
//                true
//        ));

        // Update
//        a.updateVoucher(new Voucher(
//                2, "SALE30", 20, 100000, 300000,
//                Timestamp.valueOf("2025-01-01 00:00:00"),
//                Timestamp.valueOf("2025-12-31 23:59:59"),
//                true
//        ));
//        
//  //Delete
//        a.deleteVoucher(3);
//        // Get by ID
//        Voucher v = a.getVoucherById(2);
//        if (v != null) {
//            System.out.printf(
//                    VOUCHER_FORMAT,
//                    v.getVoucherId(),
//                    v.getCode(),
//                    v.getDiscountPercent() + "%",
//                    v.getMaxDiscountAmount(),
//                    v.getMinOrderValue(),
//                    v.getValidFrom(),
//                    v.getValidTo(),
//                    v.isIsActive()
//            );
//        }
    }
}
