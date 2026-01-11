/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.Brand;
import model.Product;
import model.Specification;
import utils.DBContext;

/**
 *
 * @author ASUS
 */
public class SpecificationDAO extends DBContext {

    private ProductDAO productDAO = new ProductDAO();

    // 1. Lấy tất cả thông số (Ít dùng, thường chỉ dùng để backup/report)
    public List<Specification> getAllSpecifications() {
        List<Specification> list = new ArrayList<>();
        String sql = "SELECT * FROM specifications";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRowToSpecification(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. Lấy thông số theo Product ID (QUAN TRỌNG: Dùng cho trang Product Detail)
    // Vì quan hệ là 1-1 (Mỗi SP chỉ có 1 bộ thông số), nên trả về 1 Object thay vì List
    public Specification getSpecByProductId(int productId) {
        String sql = "SELECT * FROM specifications WHERE product_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapRowToSpecification(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Trả về null nếu sản phẩm này chưa được nhập thông số
    }

    // 3. Thêm thông số mới (Dùng khi tạo sản phẩm mới)
    public boolean addSpecification(Specification spec) {
        String sql = "INSERT INTO [specifications] ([product_id], [screen], [cpu], [ram], [camera], [battery], [os]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // Giả định object Specification có chứa Product object bên trong
            ps.setInt(1, spec.getProduct().getProductId());
            ps.setString(2, spec.getScreen());
            ps.setString(3, spec.getCpu());
            ps.setString(4, spec.getRam());
            ps.setString(5, spec.getCamera());
            ps.setString(6, spec.getBattery());
            ps.setString(7, spec.getOs());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 4. Cập nhật thông số (Dùng khi sửa sản phẩm)
    public boolean updateSpecification(Specification spec) {
        String sql = "UPDATE [specifications] SET "
                + "[screen] = ?, "
                + "[cpu] = ?, "
                + "[ram] = ?, "
                + "[camera] = ?, "
                + "[battery] = ?, "
                + "[os] = ? "
                + "WHERE [spec_id] = ?"; // Update theo ID của bảng Specification
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, spec.getScreen());
            ps.setString(2, spec.getCpu());
            ps.setString(3, spec.getRam());
            ps.setString(4, spec.getCamera());
            ps.setString(5, spec.getBattery());
            ps.setString(6, spec.getOs());
            ps.setInt(7, spec.getSpecificationId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 5. Xóa thông số (Thường ít dùng lẻ, sẽ xóa kèm khi xóa Product)
    public boolean deleteSpecification(int specId) {
        String sql = "DELETE FROM specifications WHERE spec_id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, specId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Helper: Map dữ liệu để tránh lặp code và tránh sai sót
    private Specification mapRowToSpecification(ResultSet rs) throws SQLException {
        int specId = rs.getInt("spec_id");
        int productId = rs.getInt("product_id");

        String screen = rs.getString("screen");
        String cpu = rs.getString("cpu");
        String ram = rs.getString("ram");     // Đã tách riêng RAM
        String camera = rs.getString("camera");
        String battery = rs.getString("battery");
        String os = rs.getString("os");

        // Gọi ProductDAO để lấy object Product đầy đủ
        Product product = productDAO.getProductById(productId);

        // Đảm bảo thứ tự Constructor trong Model khớp với dòng này
        return new Specification(specId, product, screen, cpu, ram, camera, battery, os);
    }

    // ================= TEST CASE =================
    public static void main(String[] args) {
        SpecificationDAO dao = new SpecificationDAO();
        ProductDAO pDao = new ProductDAO(); // Cần để lấy Product khi thêm mới
        CategoryDAO a = new CategoryDAO();
        BrandDAO b = new BrandDAO();

        // 1. Hiển thị tất cả (List All)
//        for (Specification allSpecification : dao.getAllSpecifications()) {
//            System.out.println(allSpecification);
//       }
        // Chú ý nhé do 1 sản phẩm chỉ có 1 loại specification thôi nên ko chèn 2 cái trùng product id dc phải tạo ra thêm hoặc kiếm 1 product ko có specification
//        pDao.insertProduct(new product(0,a.getCategoryById(1) , b.getBrandById(1), "cafe sang", "ngon", 12,(byte) 1, LocalDateTime.now()));
//        
//         product p = pDao.getProductById(12); 
//         dao.addSpecification(new Specification(0, p, "6.1 OLED", "A15 Bionic", "6GB", "12MP", "3279 mAh", "iOS 16"));
//        System.out.println("them thanh cong");
//         3. Update - Sửa RAM của Product ID 2
        Specification s = dao.getSpecByProductId(2); // Lấy thông số cũ lên trước
        if (s != null) {
            s.setRam("8GB (Upgraded)"); // Sửa dữ liệu
            dao.updateSpecification(s); // Đẩy xuống DB
        }

        // 4. Get by Product ID (Xem chi tiết thông số 1 SP)
//        System.out.println(dao.getSpecByProductId(2));
        // 5. Xóa (Delete) - Lưu ý: Xóa theo spec_id (Khóa chính của bảng Spec)
//         Specification delSpec = dao.getSpecByProductId(10);
//         boolean c = dao.deleteSpecification(delSpec.getSpecificationId());
//         if (c) {
//              System.out.println("xoa thanh cong");
//         } else {
//             System.out.println("tạch");
//         }
    }
}
