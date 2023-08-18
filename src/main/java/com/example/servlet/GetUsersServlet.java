package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Warehouse warehouse = Warehouse.getInstance();
        Set<User> users = warehouse.getUsers();

        request.setAttribute("users", users);

        try {
            request.getRequestDispatcher("/jsp/users.jsp").forward(request, response);
        } catch (ServletException | IOException exception) {
            Logger.getGlobal().severe(exception.getMessage());
        }
    }
}
