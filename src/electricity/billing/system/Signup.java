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
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    Choice accounttype;
    JTextField metertf ,usernametf,nametf,passwordtf;
    Signup(){
        super("Sign up");
        //setSize(640,300);
        //setLocation(400,200);
        setBounds(400,200,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel=new JPanel();
        panel.setBounds(30,30,650,300);
        panel.setBorder(new TitledBorder(new LineBorder(Color.BLACK),"Create Account",TitledBorder.LEADING,TitledBorder.TOP));
        panel.setLayout(null);
        panel.setForeground(Color.BLUE);
        JLabel heading=new JLabel("Create Account");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(heading);
        
        accounttype=new Choice();
        accounttype.add("admin");
        accounttype.add("customer");
        accounttype.setBounds(260,50,150,20);
        panel.add(accounttype);
        
        JLabel meter=new JLabel("Meter Number");
        meter.setBounds(100,90,140,20);
        meter.setForeground(Color.GRAY);
        meter.setFont(new Font("Tahoma",Font.BOLD,14));
        meter.setVisible(false);
        panel.add(meter);
        
        metertf=new JTextField();
        metertf.setBounds(260,90,140,20);
        metertf.setVisible(false);
        panel.add(metertf);
        
        
        
        
        JLabel username=new JLabel("Username");
        username.setBounds(100,130,140,20);
        username.setForeground(Color.GRAY);
        username.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(username);
        
        usernametf=new JTextField();
        usernametf.setBounds(260,130,140,20);
        panel.add(usernametf);
        
        JLabel name=new JLabel("Name");
        name.setBounds(100,170,140,20);
        name.setForeground(Color.GRAY);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);
        
        nametf=new JTextField();
        nametf.setBounds(260,170,140,20);
        panel.add(nametf);
        
        metertf.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent fe) {}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try {
                    Conn c  = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '"+metertf.getText()+"'");
                    while(rs.next()) {
                        nametf.setText(rs.getString("name"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        JLabel password=new JLabel("Password");
        password.setBounds(100,210,140,20);
        password.setForeground(Color.GRAY);
        password.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(password);
        
        passwordtf=new JTextField();
        passwordtf.setBounds(260,210,140,20);
        panel.add(passwordtf);
        
        accounttype.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                String user = accounttype.getSelectedItem();
                if (user.equals("customer")) {
                    meter.setVisible(true);
                    metertf.setVisible(true);
                    nametf.setEditable(false);
                } else {
                    meter.setVisible(false);
                    metertf.setVisible(false);
                    nametf.setEditable(true);
                }
            }
        });
        
        create=new JButton("Create");
        create.setBounds(140,260,120,25);
        create.addActionListener(this);
        panel.add(create);
        
        back=new JButton("Back");
        back.setBounds(320,260,120,25);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/icon/signupimage.png"));
        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(420,30,250,250);
        panel.add(image);
        
        
        
        add(panel);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==create){
            String usertype=accounttype.getSelectedItem();
            String susername=usernametf.getText();
            String sname=nametf.getText();
            String spassword=passwordtf.getText();
            String smeter=metertf.getText();
            
            try{
                Conn c=new Conn();
                String query = null;
                if (usertype.equals("Admin")) {
                    query = "insert into login values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+usertype+"')";
                } else {
                    query = "update login set username = '"+susername+"', password = '"+spassword+"', usertype = '"+usertype+"' where meter_no = '"+smeter+"'";
                }
                
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account created succesfully");
                setVisible(false);
                new Login();
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
                    
    }else if (ae.getSource()==back){
        setVisible(false);
        new Login();
    }
    }
    public static void main(String[] args){
        new Signup();
        
    }
}
