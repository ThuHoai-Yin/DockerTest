package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DataAccessObject;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddProduct", urlPatterns = {"/addProduct"})
public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("CATEGORIES", DataAccessObject.getListCategory());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String unit = request.getParameter("unit");
        String categoryName = request.getParameter("categoryName");
        String price = request.getParameter("price");

        for (int i = 0; i < price.length(); i++) {
            if (price.charAt(i) < 48 || price.charAt(i) > 57) {
                // báo lỗi giá chứ chữ cái và giữ nguyên giá trị của product đang add
                request.setAttribute("errorMessage", "Price only contain numberic");
                request.setAttribute("name", name);
                request.setAttribute("unit", unit);
                request.setAttribute("categoryName", categoryName);
                request.setAttribute("price", price);
                try {
                    request.setAttribute("CATEGORIES", DataAccessObject.getListCategory());
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
                return;
            }

        }
        int priceInt = Integer.parseInt(price);
        try {
            if (!DataAccessObject.addProduct(name, unit, categoryName, priceInt)) {

            } else {
                response.sendRedirect("listProduct");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
