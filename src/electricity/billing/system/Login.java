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
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton Login,Cancel,Signup;
    JTextField usernametf,Password;
    Choice Loginastf;
    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel username= new JLabel("Username");
        username.setBounds(300,20,100,20);
        add(username);
        
        usernametf= new JTextField("Username");
        usernametf.setBounds(400,20,100,20);
        add(usernametf);
        
        Password= new JTextField("Password");
        Password.setBounds(400,60,100,20);
        add(Password);
        
        JLabel Passwordtf= new JLabel("Password");
        Passwordtf.setBounds(300,60,100,20);
        add(Passwordtf);
        
        JLabel Loginas= new JLabel("Loginas");
        Loginas.setBounds(300,100,100,20);
        add(Loginas);
        
        Loginastf =new Choice();
        Loginastf.add("Admin");
        Loginastf.add("Customer");
        Loginastf.setBounds(400,100,100,20);
        add(Loginastf);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/icon/login.png"));
        Image i2=i1.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        Login=new JButton("Login",new ImageIcon(i2));
        Login.setBounds(350,140,100,20);
        Login.addActionListener(this);
        add(Login);
        
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/icon/cancel.jpg"));
        Image i4=i3.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        Cancel=new JButton("Cancel",new ImageIcon(i4));
        Cancel.addActionListener(this);
        Cancel.setBounds(480,140,100,20);
        add(Cancel);
        
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/icon/signup.png"));
        Image i6=i5.getImage().getScaledInstance(16,16,Image.SCALE_DEFAULT);
        Signup=new JButton("Signup",new ImageIcon(i6));
        Signup.setBounds(400,180,100,20);
        Signup.addActionListener(this);
        add(Signup);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/icon/second.jpg"));
        Image i8=i7.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i9=new ImageIcon(i8);
        JLabel image=new JLabel(i9);
        image.setBounds(0,0,250,250);
        add(image);
        
        
        
        
        
        
        
        setSize(640,300);
        setLocation(400,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==Login){
            String susername=usernametf.getText();
            String spassword=Password.getText();
            String user=Loginastf.getSelectedItem();
            
            
            try{
                Conn c=new Conn();
                String query="select * from login where username='"+susername+"' and password='"+spassword+"' and usertype ='"+user+"'";
               ResultSet rs= c.s.executeQuery(query);
               
               if(rs.next()){
                   String meter=rs.getString("meter_no");
                   setVisible(false);
                   new Project(user,meter);
               }
                   
               else{
                   JOptionPane.showMessageDialog(null,"Invalid Login");
                   usernametf.setText("");
                   Password.setText("");
                
                
                
                
            }
}catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==Signup){
            setVisible(false);
              new Signup();
            
        }else if(ae.getSource()==Cancel){
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args){
        new Login();
    }
    
    
    
}
