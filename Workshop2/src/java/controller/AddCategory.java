package controller;

import java.io.IOException;
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
@WebServlet(name = "AddCategory", urlPatterns = {"/addCategory"})
public class AddCategory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("AddCategory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("categoryName");
        String description = request.getParameter("description");
        if (name.isEmpty() || description.isEmpty()) {
            //báo lỗi tại trang add
            request.setAttribute("errorMessage", "Input category name or description");
            request.getRequestDispatcher("AddCategory.jsp").forward(request, response);
            return;
        }
        try {
            if (!DataAccessObject.addCategory(name, description)) {

            } else {
                response.sendRedirect("listCategory");
            }
        } catch (Exception ex) {
             //báo lỗi tại trang add
            request.setAttribute("errorMessage", "Name of category is existed!");
            request.getRequestDispatcher("AddCategory.jsp").forward(request, response);
        }
    }
}
