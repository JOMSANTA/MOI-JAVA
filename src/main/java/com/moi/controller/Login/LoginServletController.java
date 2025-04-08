package com.moi.controller.Login;


import com.moi.model.UserModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/login")
public class LoginServletController extends HttpServlet {
    private static final String JDBC_URL = System.getenv("MYSQL_JDBC_URL");
    private static final String JDBC_USER =System.getenv("MYSQL_JDBC_USER");
    private static final String JDBC_PASSWORD = System.getenv("MYSQL_JDBC_PASSWORD");

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("falla en el jbdc driver");
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



            String username = request.getParameter("username");
            String password = request.getParameter("password");




            String query = "SELECT * FROM moi.user WHERE username = ? AND password = ?";


            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement= connection.prepareStatement(query)){



                preparedStatement.setString(1, username);
                preparedStatement.setString(2,password);

                ResultSet resultSet= preparedStatement.executeQuery();


                if (resultSet.next()){
                    request.setAttribute("loginMessage", "acceso valido");
                    request.getRequestDispatcher("/WEB-INF/views/adviserOptions/adviserOption.jsp").forward(request, response);

                }else {
                    request.setAttribute("loginMessage", "acceso invalido");
                    request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
                }


            }catch (SQLException e){
                System.err.println("error "+ e.getMessage());
                request.setAttribute("loginMessage","error de conexion");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }


        }


    }




