/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jakartait.maul.code.server.service;

import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.jakartait.maul.code.entity.Customer;
import org.jakartait.maul.code.server.utils.DatabaseUtilities;
import org.jakartait.maul.code.service.CustomerService;

public class CustomerServiceServer implements CustomerService {
    public CustomerServiceServer() throws RemoteException {
    }

    /**
     *
     * @param customer
     * @return
     * @throws RemoteException
     */
    @Override
    public Customer insert(Customer customer) throws RemoteException {
        System.out.println("Client calling insert process");
    
    PreparedStatement statement = null;
    try {
        statement = DatabaseUtilities.getConnection().prepareStatement(
                "INSERT INTO customers(customerid, name, address, city)"
              + " VALUES (null,'" + customer.getName() + "', '" + customer.getAddress() + "','" + customer.getCity() , Statement.RETURN_GENERATED_KEYS);
        Logger log;
            log = Logger.getLogger("Insert Customer Logger" );
        DatabaseUtilities handler = new DatabaseUtilities();
        log.info("Client calling insert process");
        statement.executeUpdate();
        
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    customer.setCustomerId(resultSet.getLong(1));
                }   }
        return customer;
    } catch (SQLException e) {
    return null;
    } finally {
        if (statement != null) {
            try {statement.close();
    } catch (SQLException e) {
        
      }
     }
   }
 }

    @Override
    public void update(Customer customer) throws RemoteException {
    System.out.println("Client calling update process");
    PreparedStatement statement = null;
    try {
    statement = DatabaseUtilities.getConnection().prepareStatement(
            " UPDATE customers SET name=?"+ ",address=?"+ ",city=?"+ "WHERE customerid=?");
    statement.setString(1, customer.getName());
    statement.setString(2, customer.getAddress());
    statement.setString(3, customer.getCity());
    statement.setLong(4, customer.getCustomerId());
    statement.executeUpdate();
} catch (SQLException e) {
} finally {
    if (statement != null) {
        try {
            statement.close();
} catch (SQLException e) {
           }
        }
     }
  }
    @Override
    public void delete(Long customerid) throws RemoteException {
    System.out.println("Client calling delete process");
    PreparedStatement statement = null;
    try {
        statement = DatabaseUtilities.getConnection().prepareStatement(
                "DELETE FROM customer WHERE customerid=?");
        statement.setLong(1,customerid);
        statement.executeUpdate();
} catch (SQLException e) {
} finally {if (statement != null) {
    try {
        statement.close();
} catch (SQLException e) {
   }
  }
 }
}

    
    @Override
    public List<Customer> getAllCustomer() throws RemoteException {
    System.out.println("Client calling getAllUser process");
    Statement statement = null;
    try {
        statement = DatabaseUtilities.getConnection().createStatement();
        ResultSet resultSet;
        resultSet = statement.executeQuery(
                "SELECT * FROM customers ");
        List<Customer> list = new ArrayList<>();
        while (resultSet.next()) {
            Customer customer = new Customer();
            customer.setCustomerId(resultSet.getLong("customerid"));
            customer.setName(resultSet.getString("name"));
            customer.setAddress(resultSet.getString("Address"));
            customer.setCity(resultSet.getString("City"));
            list.add(customer);
        }
        return list;
        
    }catch (SQLException e) {
        return null;
    } finally {
        if (statement != null) {
            try {statement.close();
            } catch (SQLException e) {
            }
        }
    }
}

    @Override
    public Customer getUser(Long customerid) throws RemoteException {
        System.out.println("Client calling getUser process");
    PreparedStatement statement = null;
    try {
          statement = DatabaseUtilities.getConnection().prepareStatement(
                  "SELECT * FROM customers WHERE customerid= ? ");
    ResultSet resultSet = statement.executeQuery();
    Customer customer= null;
    if (resultSet.next()) {
        customer = new Customer();
        customer.setCustomerId(customerid);
        customer.setName(resultSet.getString("name"));
        customer.setAddress(resultSet.getString("address"));
        customer.setCity(resultSet.getString("city"));
    }return customer;
    } catch(SQLException e) {
        return null;
    } finally {
        if (statement != null) {
            try {
                statement.close();
    } catch (SQLException e) {
    }
        
        }
    }
}
}



        