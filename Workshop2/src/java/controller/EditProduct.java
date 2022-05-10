package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DataAccessObject;

@WebServlet(name = "EditProduct", urlPatterns = {"/editProduct"})
public class EditProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("PRODUCT", DataAccessObject.getProduct(Integer.parseInt(request.getParameter("id"))));
            request.setAttribute("CATEGORIES", DataAccessObject.getListCategory());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        String categoryName = request.getParameter("categoryName");
        String price = request.getParameter("price");
        int idInt = Integer.parseInt(id);
        for (int i = 0; i < price.length(); i++) {
            if (price.charAt(i) < 48 || price.charAt(i) > 57) {
                // báo lỗi và giữ data của product đang edit
                request.setAttribute("errorMessage", "Price only contain numberic");
                try {
                    request.setAttribute("PRODUCT", DataAccessObject.getProduct(Integer.parseInt(request.getParameter("id"))));
                    request.setAttribute("CATEGORIES", DataAccessObject.getListCategory());
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
            }

        }
        int priceInt = Integer.parseInt(price);
        try {
            if (!DataAccessObject.updateProduct(idInt, name, unit, categoryName, priceInt)) {

            } else {
                response.sendRedirect("listProduct");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
