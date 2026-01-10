/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ImportDetail;
import model.ImportReceipts; // Import model này
import model.ProductVariants; // Import model này
import utils.DBContext;

/**
 *
 * @author ASUS
 */
public class ImportDetailDAO extends DBContext {
    
    // Các DAO phụ thuộc để lấy thông tin Receipt và Variant
    private ImportReceiptsDAO importReceiptsDAO = new ImportReceiptsDAO();
    private ProductVariantDAO productVariantsDAO = new ProductVariantDAO();
    
    // 1. READ: Lấy tất cả (Ít dùng, chỉ để admin soi data)
    public List<ImportDetail> getAllImportDetail() {
        List<ImportDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM import_details";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRowToDetail(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. READ: Lấy chi tiết của MỘT phiếu nhập cụ thể (Quan trọng)
    // Dùng để hiển thị bảng chi tiết khi bấm vào một phiếu nhập
    public List<ImportDetail> getDetailsByReceiptId(int receiptId) {
        List<ImportDetail> list = new ArrayList<>();
        String sql = "SELECT * FROM import_details WHERE receipt_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, receiptId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRowToDetail(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 3. CREATE: Thêm chi tiết nhập (Thêm sản phẩm vào phiếu)
    public boolean addImportDetail(ImportDetail detail) {
        String sql = "INSERT INTO [import_details] ([receipt_id], [variant_id], [quantity], [import_price]) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            // Giả sử model ImportDetail có chứa object Receipt và Variant
            ps.setInt(1, detail.getImportReceipts().getReceiptId());
            ps.setInt(2, detail.getProductVariants().getVariantId());
            ps.setInt(3, detail.getQuantity());
            ps.setDouble(4, detail.getImportPrice());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. UPDATE: Sửa chi tiết (Ví dụ nhập sai số lượng hoặc giá)
    public boolean updateImportDetail(ImportDetail detail) {
        String sql = "UPDATE [import_details] SET [quantity] = ?, [import_price] = ? WHERE [import_detail_id] = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, detail.getQuantity());
            ps.setDouble(2, detail.getImportPrice());
            ps.setInt(3, detail.getImportDetailId());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5. DELETE: Xóa chi tiết nhập
    public boolean deleteImportDetail(int detailId) {
        String sql = "DELETE FROM [import_details] WHERE [import_detail_id] = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, detailId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Helper: Map ResultSet sang Object
    private ImportDetail mapRowToDetail(ResultSet rs) throws SQLException {
        int importDetailId = rs.getInt("import_detail_id");
        int receiptId = rs.getInt("receipt_id");
        int variantId = rs.getInt("variant_id");
        int quantity = rs.getInt("quantity");
        double importPrice = rs.getDouble("import_price");

        // Lấy object đầy đủ từ các DAO khác
        ImportReceipts receipt = importReceiptsDAO.getImportReceiptById(receiptId);
        ProductVariants variant = productVariantsDAO.getVariantById(variantId);

        return new ImportDetail(importDetailId, receipt, variant, quantity, importPrice);
    }
    
    // ================= MAIN TEST CASE =================
    public static void main(String[] args) {
        ImportDetailDAO dao = new ImportDetailDAO();
        
        // Cần các DAO phụ để lấy dữ liệu giả lập test
        ImportReceiptsDAO receiptDao = new ImportReceiptsDAO();
        ProductVariantDAO variantDao = new ProductVariantDAO();

        System.out.println("--- 1. GET DETAILS BY RECEIPT ID (Ví dụ Receipt ID 1) ---");
        int testReceiptId = 1;
        List<ImportDetail> details = dao.getDetailsByReceiptId(testReceiptId);
        for (ImportDetail d : details) {
            System.out.println("SP: " + d.getProductVariants().getProduct().getProductName()
                             + " [" + d.getProductVariants().getColor() + "] "
                             + "- SL: " + d.getQuantity() 
                             + "- Giá nhập: " + d.getImportPrice());
        }

//        System.out.println("\n--- 2. ADD NEW IMPORT DETAIL ---");
        // Giả sử thêm vào Receipt 1, Sản phẩm Variant ID 4 (MacBook Air), SL 5, Giá 20tr
        ImportReceipts r = receiptDao.getImportReceiptById(1);
        ProductVariants v = variantDao.getVariantById(4); // MacBook Air M2
        
        if (r != null && v != null) {
            ImportDetail newDetail = new ImportDetail(0, r, v, 5, 20000000);
//            boolean isAdded = dao.addImportDetail(newDetail);
//            System.out.println("Insert Result: " + isAdded);
            
            // Check lại
            List<ImportDetail> newList = dao.getDetailsByReceiptId(1);
            ImportDetail lastItem = newList.get(newList.size() - 1);
//            System.out.println("Vừa thêm: " + lastItem.getProductVariants().getProduct().getProductName());

//            System.out.println("\n--- 3. UPDATE DETAIL ---");
//            lastItem.setQuantity(10); // Tăng số lượng lên 10
//            boolean isUpdated = dao.updateImportDetail(lastItem);
//            System.out.println("Update Result: " + isUpdated);

            // System.out.println("\n--- 4. DELETE DETAIL ---");
             boolean isDeleted = dao.deleteImportDetail(lastItem.getImportDetailId());
             System.out.println("Delete Result: " + isDeleted);
        } else {
            System.out.println("Không tìm thấy Receipt ID 1 hoặc Variant ID 4 để test.");
        }
    }
}