import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class PinChange extends JFrame implements ActionListener{

    JButton change,back;
    JPasswordField pin,rpin;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);

    JLabel text=new JLabel("CHANGE YOUR PIN");
    text.setBounds(250,280,500,35);
    text.setForeground(Color.white);
    text.setFont(new Font("System",Font.BOLD,16));
    image.add(text);

    JLabel ptext=new JLabel("New PIN:");
    ptext.setBounds(165,320,180,25);
    ptext.setForeground(Color.white);
    ptext.setFont(new Font("System",Font.BOLD,16));
    image.add(ptext);

    pin=new JPasswordField();
    pin.setFont(new Font("Raleway",Font.BOLD,25));
    pin.setBounds(330,320,180,25);
    image.add(pin);

    JLabel reptext=new JLabel("Re-Enter New PIN:");
    reptext.setBounds(165,360,180,25);
    reptext.setForeground(Color.white);
    reptext.setFont(new Font("System",Font.BOLD,16));
    image.add(reptext);

    rpin=new JPasswordField();
    rpin.setFont(new Font("Raleway",Font.BOLD,25));
    rpin.setBounds(330,360,180,25);
    image.add(rpin);

    change=new JButton("CHANGE");
    change.setBounds(355,485,150,30);
    change.addActionListener(this);
    image.add(change);

    back=new JButton("BACK");
    back.setBounds(355,485,150,30);
    back.addActionListener(this);
    image.add(back);



    setSize(900,900);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    }
public static void main(String[] args) {
    new PinChange("").setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
 
    if(ae.getSource()==change){
        try {
    String npin=pin.getText();
    String repin=rpin.getText();
    if(!npin.equals(repin)){
        JOptionPane.showMessageDialog(null, "Entered PIN does not match");
        return;
    }
    if(npin.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter new PIN");
        return;
    }
    if(repin.equals("")){
        JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
        return;
    }

    Conn c=new Conn();
    String q1="update bank set pin='"+npin+"' where pin ='"+pinnumber+"'"; 
    String q2="update login set pin='"+npin+"' where pin ='"+pinnumber+"'"; 
    String q3="update signupthree set pin='"+npin+"' where pin ='"+pinnumber+"'";
    c.s.executeUpdate(q1);
    c.s.executeUpdate(q2); 
    c.s.executeUpdate(q3); 
    JOptionPane.showMessageDialog(null, "PIN changed successfully");
     
    setVisible(false);
    new Transactions(repin).setVisible(true);
    
 } catch (Exception e) {
    System.out.println(e);
 }

}else{
    setVisible(false);
    new Transactions(pinnumber).setVisible(true);
}
}


}
