import java.awt.Font;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;

public class SignUpThree extends JFrame implements ActionListener{

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;//global
    SignUpThree(String formno){
        this.formno=formno;//global<--local
        setLayout(null);
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22)); 
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22)); 
        type.setBounds(100,140,200,30);
        add(type);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16)); 
        r1.setBackground(Color.white);
        r1.setBounds(100,180,150,20);
        add(r1);

        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16)); 
        r2.setBackground(Color.white);
        r2.setBounds(350,180,200,20);
        add(r2);

        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16)); 
        r3.setBackground(Color.white);
        r3.setBounds(100,220,150,20);
        add(r3);

        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16)); 
        r4.setBackground(Color.white);
        r4.setBounds(350,220,230,20);
        add(r4);

        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card=new JLabel("Card No");
        card.setFont(new Font("Raleway",Font.BOLD,22)); 
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22)); 
        number.setBounds(330,300,300,30);
        add(number);

        JLabel cardDetails=new JLabel("** Your 16 Digit Card Number");
        cardDetails.setFont(new Font("Raleway",Font.BOLD,12)); 
        cardDetails.setBounds(100,330,300,20);
        add(cardDetails);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22)); 
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22)); 
        pnumber.setBounds(330,370,300,30);
        add(pnumber);

        JLabel pinDetails=new JLabel("** Your 4 Digit Pin Number");
        pinDetails.setFont(new Font("Raleway",Font.BOLD,12)); 
        pinDetails.setBounds(100,400,300,20);
        add(pinDetails);

        JLabel service=new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,22)); 
        service.setBounds(100,450,300,30);
        add(service);
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Ralewway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
           
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Ralewway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);   

        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Ralewway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
           
        c4=new JCheckBox("EMAIL & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Ralewway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
           
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Ralewway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
           
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Ralewway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
           
        c7=new JCheckBox("I hereby declares that the above enter details are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Ralewway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        
      if(ae.getSource()==submit){
         String accountType=null;
         if(r1.isSelected()) accountType="Saving Account";
         else if(r2.isSelected())  accountType="Fixed Deposit Account";
        else if(r3.isSelected())  accountType="Current Account";
        else if(r4.isSelected())  accountType="Recurring Deposit Account";
         Random random= new Random();
         String cardnumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
         String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
         String facility="";
         if(c1.isSelected()) facility="ATM Card"+facility;
         else if(c2.isSelected()) facility=facility+"Internet Banking";
         else if(c3.isSelected()) facility=facility+"Mobile Banking";
         else if(c4.isSelected()) facility=facility+"EMAIL & SMS Alerts";
         else if(c5.isSelected()) facility=facility+"Cheque Book";
         else if(c6.isSelected()) facility=facility+"E-Statement";
          try{
            if(accountType.equals(null)) JOptionPane.showMessageDialog(null, "Account Type is Required");
            else if(facility.equals(null)) JOptionPane.showMessageDialog(null, "Services is Required");
            else if(!c7.isSelected())  JOptionPane.showMessageDialog(null, "tick the declaration checkbox");
            else{
                Conn conn=new Conn();
                String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Card Number: "+cardnumber+"\nPin Number: "+pinnumber+"\n **note the cardnumber and pinnumber for login");
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            }
          }catch(Exception e){
            System.out.println(e);
          }

      }else if(ae.getSource()==cancel){
           setVisible(false);
           new Login().setVisible(true);
      }
    }
public static void main(String[] args) {
    new SignUpThree("");
}


}