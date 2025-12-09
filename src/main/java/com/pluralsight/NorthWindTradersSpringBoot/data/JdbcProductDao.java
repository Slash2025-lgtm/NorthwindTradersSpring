package com.pluralsight.NorthWindTradersSpringBoot.data;

import com.pluralsight.NorthWindTradersSpringBoot.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    private List<Product> products;
    private DataSource dataSource;

    @Autowired
    public JdbcProductDao(DataSource dataSource) {
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        this.products.clear();
        String sql = "SELECT P.ProductID, P.ProductName, C.CategoryName, P.UnitPrice " +
                "FROM Products AS P JOIN " +
                "Categories AS C ON (P.CategoryID = C.CategoryID) ";

        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                this.products.add(new Product(result.getInt(1), result.getString(2), result.getString(3),result.getDouble(4)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
        System.out.println(product);
    }
}
