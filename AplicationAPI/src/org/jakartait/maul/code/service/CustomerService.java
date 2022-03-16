/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jakartait.maul.code.service;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import org.jakartait.maul.code.entity.Customer;

public interface CustomerService extends Remote {
    Customer insert(Customer customer) throws RemoteException;
    void update(Customer customer) throws RemoteException;
    void delete(Long customerid) throws RemoteException;
    Customer getUser(Long customerid) throws RemoteException;
    List<Customer> getAllCustomer() throws RemoteException;
}
