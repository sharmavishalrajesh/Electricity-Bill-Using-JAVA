/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;

/**
 *
 * @author visha
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    
    String usertype,meter;
    Project(String usertype, String meter){
        this.usertype=usertype;
        this.meter=meter;
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/icon/elect1.jpg"));
        Image i2=i1.getImage().getScaledInstance(1550,850,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);
        setVisible(true);
        
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        
        JMenu master=new JMenu("Master");
        master.setForeground(Color.BLUE);
        
        
        JMenuItem newcustomer= new JMenuItem("New Customer");
        newcustomer.setMnemonic('D');
        newcustomer.addActionListener(this);
        newcustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
        master.add(newcustomer);
        
        JMenuItem customerdetail= new JMenuItem("Customer Details");
        customerdetail.setMnemonic('M');
        customerdetail.addActionListener(this);
        customerdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
        master.add(customerdetail);
        
        JMenuItem depositdetail= new JMenuItem("Deposit Details");
        depositdetail.setMnemonic('N');
        depositdetail.addActionListener(this);
        depositdetail.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        master.add(depositdetail);
        
        JMenuItem calculatebill= new JMenuItem("Calculate Bill");
        calculatebill.setMnemonic('B');
        calculatebill.addActionListener(this);
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        master.add(calculatebill);
        
        
        JMenu information=new JMenu("Information");
        information.setForeground(Color.RED);
        
        
        JMenuItem updateinformation= new JMenuItem("Update Information");
        updateinformation.setMnemonic('U');
        updateinformation.addActionListener(this);
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        information.add(updateinformation);
        
        JMenuItem viewinformation= new JMenuItem("View Information");
        viewinformation.setMnemonic('V');
        viewinformation.addActionListener(this);
        viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        information.add(viewinformation);
        
        JMenu user=new JMenu("User");
        user.setForeground(Color.BLUE);
        
        
        JMenuItem Paybill= new JMenuItem("Pay Bills");
        Paybill.setMnemonic('R');
        Paybill.addActionListener(this);
        Paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
        user.add(Paybill);
        
        JMenuItem billdetails= new JMenuItem("Bill Details");
        billdetails.setMnemonic('K');
        billdetails.addActionListener(this);
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
        user.add(billdetails);
        
        JMenu report=new JMenu("Report");
        report.setForeground(Color.RED);
        
        
        JMenuItem generatebill= new JMenuItem("Generate Bill");
        generatebill.setMnemonic('G');
        generatebill.addActionListener(this);
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
        report.add(generatebill);
        
        
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        
        
        JMenuItem notepad= new JMenuItem("Notepad");
        notepad.setMnemonic('N');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        utility.add(notepad);
        
        JMenuItem Calculator= new JMenuItem("Calculator");
        Calculator.setMnemonic('C');
        Calculator.addActionListener(this);
        Calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        utility.add(Calculator);
        
        
        JMenu Exit=new JMenu("Exit");
        Exit.setForeground(Color.RED);
        
        
        JMenuItem exit= new JMenuItem("EXIT");
        exit.setMnemonic('W');
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        Exit.add(exit);
        
        if(usertype.equals("Admin")){
        mb.add(master);}
        else{
        mb.add(information);
        mb.add(report);
        mb.add(user);
        
        }
        mb.add(utility);
        mb.add(Exit);
        
        setLayout(new FlowLayout());
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg=ae.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
            
        }else if(msg.equals("Customer Details")){
            new CustomerDetails();
        }else if(msg.equals("Deposit Details")){
            new DepositDetails();
            
    }else if(msg.equals("Calculate Bill")){
        new CalculateBill();
    }else if (msg.equals("View Information")){
        new ViewInformation(meter);
    }else if(msg.equals("Update Information")){
        new UpdateInformation(meter);
    }else if(msg.equals("Bill Details")){
        new BillDetails(meter);
    }else if(msg.equals("Notepad")){
        try{
            Runtime.getRuntime().exec("notepad.exe");
        }catch (Exception e){
            e.printStackTrace();
        }
    }else if(msg.equals("Calculator")){
        try{
            Runtime.getRuntime().exec("calc.exe");
        }catch (Exception e){
            e.printStackTrace();
        }
    }else if(msg.equals("EXIT")){
        setVisible(false);
        new Login();
    }else if(msg.equals("Pay Bills")){
        
        new PayBill(meter);
        
        
    }else if(msg.equals("Generate Bill")){
        
        new GenerateBill(meter);
        
        
    }
    }
    
    
    public static void main(String[] args){
        new Project("","");
    }
    
}
