/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

/**
 *
 * @author visha
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
public class CustomerDetails extends JFrame implements ActionListener{
    Choice meternumber,cmonth;
    JTable table;
    JButton search, print;
    CustomerDetails(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(200,150);
        
      
        
        table=new JTable();
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select *from customer");
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp=new JScrollPane(table);
        add(sp);
        
        
        print=new JButton("print");
        print.addActionListener(this);
        add(print,"South");
        
        
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
       
            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    
    public static void main(String[] args){
        
        new CustomerDetails();
    }
}
