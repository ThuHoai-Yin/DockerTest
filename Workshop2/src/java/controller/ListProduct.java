package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DataAccessObject;

@WebServlet(name = "ListProduct", urlPatterns = {"/listProduct"})
public class ListProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("PRODUCTS", DataAccessObject.getListProduct());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("ListProduct.jsp").forward(request, response);
    }
}
