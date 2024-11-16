package com.moi.dao;


import com.moi.model.EmployeeAuthorizedModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class EmployeeAuthorizedDAOImpl implements  EmployeeAuthorizedDAO{

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/moi";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root123";

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
    public void insertUser(EmployeeAuthorizedModel model) {


    }

    @Override
    public EmployeeAuthorizedModel getUserById(int id) {
        return null;
    }

    @Override
    public List<EmployeeAuthorizedModel> getAllUser() {
        return List.of();
    }

    @Override
    public void updateUser(int id, EmployeeAuthorizedModel model) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
