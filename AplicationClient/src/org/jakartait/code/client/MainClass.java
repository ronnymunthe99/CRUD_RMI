/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jakartait.code.client;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.SwingUtilities;
import org.jakartait.maul.code.client.view.FrameCustomer;
import org.jakartait.maul.code.service.CustomerService;

/***
 * @author Achmad Maulana
 */
public class MainClass{
    public static void main(String[] args) throws RemoteException, NotBoundException {       
        try{
        //port yang digunakan
        int port = 2302;
        
        //getRegistry, Menghubungkan interface client dengan server yg telah dibuat
        Registry client = LocateRegistry.getRegistry("127.0.0.1", port);
        //membuat objek 'Remote Object' MahasiswaService yang ada di Program API
        CustomerService service = (CustomerService) client.lookup("service");
        
        //Menjalankan JFrame client yang telah dibuat
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FrameCustomer frameCustomer= new FrameCustomer(service);
                frameCustomer.setVisible(true); 
            }
        });
        
        //Feedback ketika client berhasil dijalnkan
        System.out.println("[Client] Client berhasil berjalan........");
        }catch(RemoteException e){
            //Feedback ketika client gagal dijalankan
            System.out.println("[Client] Client gagal dijalankan..\n\t "+e);
        }
    
    }
}
