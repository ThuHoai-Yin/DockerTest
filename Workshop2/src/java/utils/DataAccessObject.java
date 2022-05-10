package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

public class DataAccessObject {

    public static List<Category> getListCategory() throws SQLException {
        Connection con = DBContext.getConnection();
        String query = "select * from category";
        PreparedStatement sta = con.prepareStatement(query);
        List<Category> result = new ArrayList<>();
        ResultSet resset = sta.executeQuery();
        while (resset.next()) {
            result.add(new Category(resset.getInt(1),resset.getString(2), resset.getString(3)));
        }

   
        return result;
    }

    public static Product getProduct(int id) throws SQLException {
        Connection con = DBContext.getConnection();
        String query = "select * from product where productId = ?";
        PreparedStatement sta = con.prepareStatement(query);
        sta.setInt(1, id);
        Product result = null;
        ResultSet resset = sta.executeQuery();
        if (!resset.next()) {
            return null;
        }
        result = new Product(resset.getInt(1), resset.getString(2), resset.getString(3), resset.getString(4), resset.getInt(5));


        return result;
    }

    public static boolean updateProduct(int productID, String productName, String unit, String categoryName, int price) throws SQLException {
        Connection con = DBContext.getConnection();
        String query = "update product set productName=?,unit=?, categoryName=?, price=? where productID=?";
        PreparedStatement sta = con.prepareStatement(query);
        sta.setString(1, productName);
        sta.setString(2, unit);
        sta.setString(3, categoryName);
        sta.setInt(4, price);
        sta.setInt(5, productID);
        boolean res = sta.executeUpdate() > 0;   
        return res;
    }

    public static boolean addProduct(String productName, String unit, String categoryName, int price) throws SQLException {
        Connection con = DBContext.getConnection();
        String query = "insert into product (productName, unit, categoryName, price) values(?,?,?,?)";
        PreparedStatement sta = con.prepareStatement(query);
        sta.setString(1, productName);
        sta.setString(2, unit);
        sta.setString(3, categoryName);
        sta.setInt(4, price);
        boolean res = sta.executeUpdate() > 0;
        return res;
    }

    public static List<Product> getListProduct() throws SQLException {
        Connection con = DBContext.getConnection();
        String query = "select * from product";
        PreparedStatement sta = con.prepareStatement(query);
        List<Product> result = new ArrayList<>();
        ResultSet resset = sta.executeQuery();
        while (resset.next()) {
            result.add(new Product(resset.getInt(1), resset.getString(2), resset.getString(3), resset.getString(4), resset.getInt(5)));
        }


        return result;
    }

    public static boolean addCategory(String name, String description) throws SQLException {
        Connection con = DBContext.getConnection();
        String query = "insert into category (name,description) values(?,?)";
        PreparedStatement sta = con.prepareStatement(query);
        sta.setString(1, name);
        sta.setString(2, description);
        boolean res = sta.executeUpdate() > 0;


        return res;
    }
    public static boolean removeProduct(int id) throws SQLException{
        Connection con = DBContext.getConnection();
        String query = "delete FROM product where productId=?";
         PreparedStatement sta = con.prepareStatement(query);
        sta.setInt(1, id);
          boolean res = sta.executeUpdate() > 0;
          return res;
    }
}
