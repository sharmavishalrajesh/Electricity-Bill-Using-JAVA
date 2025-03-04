
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
import java.util.*;
import java.awt.event.*;
public class NewCustomer extends JFrame implements ActionListener{
    JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfmobile;
    JButton next,cancel;
    JLabel meter;
    NewCustomer(){
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(Color.GRAY);
        add(p);
        
        JLabel heading =new JLabel("New Customer");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(heading);
        
        JLabel lbname =new JLabel("Customer Name");
        lbname.setBounds(100,80,100,20);
        p.add(lbname);
        
        tfname= new JTextField();
        tfname.setBounds(240,80,100,20);
        p.add(tfname);
        
        
        JLabel meterno =new JLabel("Meter No");
        meterno.setBounds(100,120,100,20);
        p.add(meterno);
        
        meter =new JLabel("");
        meter.setBounds(240,120,100,20);
        p.add(meter);
        
        Random ran=new Random();
        long number=ran.nextLong()%1000000;
        meter.setText(""+Math.abs(number));
        
        JLabel address =new JLabel("Address");
        address.setBounds(100,160,100,20);
        p.add(address);
        
        tfaddress= new JTextField();
        tfaddress.setBounds(240,160,100,20);
        p.add(tfaddress);
        
        JLabel city =new JLabel("City");
        city.setBounds(100,200,100,20);
        p.add(city);
        
        tfcity= new JTextField();
        tfcity.setBounds(240,200,100,20);
        p.add(tfcity);
        
        JLabel state =new JLabel("State");
        state.setBounds(100,240,100,20);
        p.add(state);
        
        tfstate= new JTextField();
        tfstate.setBounds(240,240,100,20);
        p.add(tfstate);
        
        
        JLabel email =new JLabel("Email");
        email.setBounds(100,280,100,20);
        p.add(email);
        
        tfemail= new JTextField();
        tfemail.setBounds(240,280,100,20);
        p.add(tfemail);
        
        JLabel mobile =new JLabel("Mobile no");
        mobile.setBounds(100,320,100,20);
        p.add(mobile);
        
        tfmobile= new JTextField();
        tfmobile.setBounds(240,320,100,20);
        p.add(tfmobile);
        
        next=new JButton("Next");
        next.setBounds(120,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(250,390,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout());
        add(p,"Center");
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/icon/hicon1.jpg"));
        Image i2=i1.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add (image,"West");
        
        getContentPane().setBackground(Color.WHITE);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){
            String name=tfname.getText();
            String metero=meter.getText();
            String address=tfaddress.getText();
            String city=tfcity.getText();
            String state=tfstate.getText();
            String email=tfemail.getText();
            String phone=tfmobile.getText();
            
            String query1="insert into customer values('"+name+"','"+metero+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
            
            String query2="insert into login values('"+metero+"','','"+name+"','','')";
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Customer Details Added Successfully");
                setVisible(false);
                
                new MeterInfo(metero);
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
    }else{
    setVisible(false);
}
}
        
    
    public static void main(String[] args){
        
        new NewCustomer();
        
    }
    
}
