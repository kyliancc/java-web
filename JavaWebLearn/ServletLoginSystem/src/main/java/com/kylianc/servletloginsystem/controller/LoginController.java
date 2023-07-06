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
 * Process login request that is sends by login.jsp.
 */
@WebServlet(value = "/login_service")
public class LoginController extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -2437229569625806060L;

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

        if (!service.isAccountExists(username)) {
            // If inputted username is not exists, let user try again.
            response.sendRedirect("./login.jsp?loginFailed=true");
            return;
        }

        if (!service.loginAccount(username, password)) {
            // If inputted password and correct password are not matched, let user try again.
            response.sendRedirect("./login.jsp?loginFailed=true");
            return;
        }

        // Login success! Save account infos in session.
        request.getSession().setAttribute("username", username);
        // Redirect to login_success.jsp
        response.sendRedirect("./login_success.jsp?username=" + username);
    }
}
