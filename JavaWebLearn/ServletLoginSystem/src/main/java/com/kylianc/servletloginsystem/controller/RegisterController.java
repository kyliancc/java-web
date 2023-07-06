package com.kylianc.servletloginsystem.controller;


import com.kylianc.servletloginsystem.service.AccountService;
import com.kylianc.servletloginsystem.service.AccountServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

/**
 * Process login request that is sends by register.jsp.
 */
@WebServlet(value = "/register_service")
public class RegisterController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 6489595241503038993L;

    private AccountService service;

    // Initialize
    @Override
    public void init() {
        service = AccountServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Get user's inputs.
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (service.isAccountExists(username)) {
            // Let user try again if inputted username is already exists.
            response.sendRedirect("./register.jsp?nameExists=true");
        }
        else {
            // Register success!
            // Add new user info to database
            service.insertAccount(username, password);
            // Redirect to register_success.html
            response.sendRedirect("./register_success.html");
        }
    }
}
