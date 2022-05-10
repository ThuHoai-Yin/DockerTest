package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.DataAccessObject;

/**
 *
 * @author nezumi
 */
@WebServlet(name = "ListCategory", urlPatterns = {"/listCategory"})
public class ListCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("CATEGORIES", DataAccessObject.getListCategory());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        request.getRequestDispatcher("ListCategory.jsp").forward(request, response);
    }
}
