package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DataAccessObject;

@WebServlet(name = "RemoveProduct", urlPatterns = {"/removeProduct"})
public class RemoveProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (!DataAccessObject.removeProduct(Integer.parseInt(request.getParameter("id")))) {

            } else {
                response.sendRedirect("listProduct");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
