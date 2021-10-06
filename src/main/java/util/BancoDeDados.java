package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {


    private static Connection conn;

    public static Connection getConection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sys";
        String username="root";
        String password ="‘@12345’";
        conn = DriverManager.getConnection(jdbcUrl,username,password);
        return conn;
    }
}

/*
    docker run -d \
        --name mysql-8.0.26 \
        -p 3306:3306 \
        -v ~/mysql_data:/var/lib/mysql \
        -e MYSQL_ROOT_PASSWORD=‘@12345’ \
        mysql:8.0.26

 */