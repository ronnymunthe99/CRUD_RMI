/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jakartait.maul.code.client.model;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.jakartait.maul.code.entity.Customer;


/**
 *
 * @author Ronny
 */
public class TableModelCustomer extends AbstractTableModel {
    private List<Customer> list =new ArrayList<>();

    public TableModelCustomer() {
    }
    
    public Customer get(int row) {
        return list.get(row);
    }
    
    public void insert(Customer customer) {
        list.add(customer);
        fireTableDataChanged();
    }
    
    public void update(int row, Customer customer) {
        list.set(row, customer);
        fireTableDataChanged();
    
    }public void delete(int row) {
        list.remove(row);
        fireTableDataChanged();
    }
    
    public void setData(List<Customer> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return list.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 4; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "CustomerId";
            case 1:
                return "Name";
            case 2:
                return "Address";
            case 3:
                return "City";
             default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getCustomerId();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getAddress();
            case 3:
                return list.get(rowIndex).getCity();
            default:
                return null;
        }
    }
}
