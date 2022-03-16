/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jakartait.maul.code.server1;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.jakartait.maul.code.server.service.CustomerServiceServer;
import org.jakartait.maul.code.server.utils.DatabaseUtilities;
/**** 
 * @author Achmad Maulana
 */
public class MainClass {
    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        // TODO code application logic here
        Registry server = LocateRegistry.createRegistry(2302);
        CustomerServiceServer customerService = new CustomerServiceServer();
        server.rebind("service", customerService);
        System.out.println("Server berjalan");
    }
}