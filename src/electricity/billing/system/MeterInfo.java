
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
public class MeterInfo extends JFrame implements ActionListener{
    JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfmobile;
    JButton next,cancel;
    JLabel meter;
    Choice meterlocation,metertype,phasecode,billtype;
    String meternumber;
    MeterInfo(String meternumber){
        this.meternumber=meternumber;
        setSize(700,500);
        setLocation(400,200);
        
        JPanel p=new JPanel();
        p.setLayout(null);
        p.setBackground(Color.GRAY);
        add(p);
        
        JLabel heading =new JLabel("Meter Information");
        heading.setBounds(180,10,200,25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        p.add(heading);
        
        JLabel lbname =new JLabel("Meter no");
        lbname.setBounds(100,80,100,20);
        p.add(lbname);
        
        JLabel lblmeternumber= new JLabel(meternumber);
        lblmeternumber.setBounds(240,80,100,20);
        p.add(lblmeternumber);
        
        JLabel lblmeterlocation= new JLabel("MeterLocation");
        lblmeterlocation.setBounds(100,120,100,20);
        p.add(lblmeterlocation);
        
        
        meterlocation =new Choice();
        meterlocation.add("Outside");
        meterlocation.add("inside");
        meterlocation.setBounds(240,120,100,20);
        p.add(meterlocation);
       
        
        JLabel address =new JLabel("MeterType");
        address.setBounds(100,160,100,20);
        p.add(address);
        
        metertype =new Choice();
        metertype.add("Electric meter");
        metertype.add("Solar meter");
        metertype.add("Smart meter");
        metertype.setBounds(240,160,100,20);
        p.add(metertype);
        
        JLabel city =new JLabel("Phase code");
        city.setBounds(100,200,100,20);
        p.add(city);
        
        phasecode =new Choice();
        phasecode.add("011");
        phasecode.add("022");
        phasecode.add("033");
         phasecode.add("044");
        phasecode.add("055");
        phasecode.add("066");
         phasecode.add("077");
        phasecode.add("088");
        phasecode.add("099");
        
        phasecode.setBounds(240,200,100,20);
        p.add(phasecode);
        
        JLabel state =new JLabel("Bill Type");
        state.setBounds(100,240,100,20);
        p.add(state);
        
        billtype =new Choice();
        billtype.add("Normal");
        billtype.add("Commercial");
        billtype.setBounds(240,240,100,20);
        p.add(billtype);
        
        
        JLabel email =new JLabel("Days");
        email.setBounds(100,280,100,20);
        p.add(email);
        
        JLabel emails =new JLabel("30 Days");
        emails.setBounds(240,280,100,20);
        p.add(emails);
        
       
        
        JLabel mobile =new JLabel("note");
        mobile.setBounds(100,320,100,20);
        p.add(mobile);
        
        JLabel mobiles =new JLabel("By Default Bill is calculated for 30 days only");
        mobiles.setBounds(240,320,1000,20);
        p.add(mobiles);
        
        
        
        next=new JButton("Submit");
        next.setBounds(220,390,100,25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);
        
        
        
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
            String meter=meternumber;
            String location=meterlocation.getSelectedItem();
            String type=metertype.getSelectedItem();
            String code=phasecode.getSelectedItem();
            String typebill=billtype.getSelectedItem();
            String days="30";
            
            String query1="insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+typebill+"','"+days+"')";
           
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query1);
                
                JOptionPane.showMessageDialog(null,"New meter information added Successfully");
                setVisible(false);
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
    }else{
    setVisible(false);
}
}
        
    
    public static void main(String[] args){
        
        new MeterInfo("");
        
    }
    
}
