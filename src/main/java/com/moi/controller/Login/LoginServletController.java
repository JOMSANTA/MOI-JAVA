package com.moi.controller.Login;


import com.moi.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/login")
public class LoginServletController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if (username.equalsIgnoreCase("santa") && password.equals("1234")) {
            request.setAttribute("loginMessage", "acceso valido");

        }else {
            request.setAttribute("loginMessage","acceso invalido");
        }
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);



        }


    }




