import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class Fastcash extends JFrame implements ActionListener {

    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    Fastcash(String pinnumber){
    this.pinnumber=pinnumber;
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
    text.setBounds(210,300,700,35);
    text.setForeground(Color.white);
    text.setFont(new Font("System",Font.BOLD,16));
    image.add(text);

    deposit=new JButton("RS. 100");
    deposit.setBounds(170,415,150,30);
    deposit.addActionListener(this);
    image.add(deposit);

    withdrawl=new JButton("RS. 500");
    withdrawl.setBounds(355,415,150,30);
    withdrawl.addActionListener(this);
    image.add(withdrawl);

    fastcash=new JButton("RS. 1000");
    fastcash.setBounds(170,450,150,30);
    fastcash.addActionListener(this);
    image.add(fastcash);

    ministatement=new JButton("RS. 2000");
    ministatement.setBounds(355,450,150,30);
    ministatement.addActionListener(this);
    image.add(ministatement);

    pinchange=new JButton("RS. 5000");
    pinchange.setBounds(170,485,150,30);
    pinchange.addActionListener(this);
    image.add(pinchange);

    balanceenquiry=new JButton("RS. 10000");
    balanceenquiry.setBounds(355,485,150,30);
    balanceenquiry.addActionListener(this);
    image.add(balanceenquiry);

    exit=new JButton("BACK");
    exit.setBounds(335,520,150,30);
    exit.addActionListener(this);
    image.add(exit);

    setSize(900,900);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    

    }

    public static void main(String[] args) {
        new Fastcash("");
    }


    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else {
            String amount=((JButton)ae.getSource()).getText().substring(4);//RS. 500 --> 500
            Conn conn=new Conn();
            try {
                ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while (rs.next()) {
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }

                    if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }
                    Date date =new Date();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS."+amount+" Debited Successfully");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e);
            }

        }

}}
