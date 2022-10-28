package com.haden.prjforstd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.Configuration;
import java.sql.*;

@Component
public class ProductTempRepository {

    private final String dbUrl="";
    private final String dbId="";
    private final String dbPassword="";

    public void createProduct(Product product) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement("select max(id) as id from product");
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            product.setId(rs.getLong("id") + 1);
        }else{
            throw new SQLException("error");
        }

        ps = connection.prepareStatement("insert into product(id, title, image, link, lprice, myprice) values(?, ?, ?, ?, ?, ?)");
        ps.setLong(1, product.getId());
        ps.setString(2, product.getTitle());
        ps.setString(3, product.getImage());
        ps.setString(4, product.getLink());
        ps.setInt(5, product.getPrice());

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbId, dbPassword);
    }

}
