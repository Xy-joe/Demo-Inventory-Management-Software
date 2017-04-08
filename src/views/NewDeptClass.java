package views;

import presenters.OtherConnections;
import presenters.SQLDate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by joebuntu on 4/5/17.
 */
public class NewDeptClass extends JFrame implements ActionListener {
    JPanel panel1, panel2,panel3,panel4, panel5;
    SQLDate sql,date2;
   JLabel headl,amount, discount, namount,name,did,date,prod,produID,qty,paid,balance,duedate,phone,stat,addre;
    JTextField amounttf, discounttf, nettf,nametf,didtf,datetf,prodtf,produIDtf,qtytf,paidtf,balancetf,duedatetf,phonetf,stattf,addretf;
JButton create,bacck, cancel, print;String dd = null;
    public NewDeptClass() {
        sql = new SQLDate();
        date2 = new SQLDate();
        headl = new JLabel("NEW DEPT",JLabel.CENTER);
        headl.setForeground(Color.WHITE);
        headl.setFont(new Font("Virtual DJ", Font.BOLD, 20));
        panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel4.setBackground(Color.decode("#90CAF9"));
        create = new JButton("Create Dept");
        create.setBackground(Color.decode("#1565C0"));
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.decode("#1565C0"));
        cancel.setToolTipText("Refreshes all Field");
        cancel.addActionListener(this);
        bacck = new JButton("Back");
        bacck.setForeground(Color.WHITE);
        bacck.setBackground(Color.decode("#1565C0"));
        bacck.addActionListener(this);
        print = new JButton("Print");
        print.setBackground(Color.decode("#1565C0"));
        print.addActionListener(this);
        print.setForeground(Color.WHITE);
        print.setToolTipText("Print the dept details");
        panel4.add(create);
        panel4.add(cancel);
        panel4.add(bacck);
        panel4.add(print);
        panel1 = new JPanel(new GridLayout(13,2,0,5));
        panel1.setBorder(BorderFactory.createTitledBorder("Details:"));
        panel1.setBackground(Color.decode("#BBDEFB"));

        did  = new JLabel();
        did.setText("Dept ID:");
        did.setForeground(Color.black);
        did.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        didtf = new JTextField(30);
        didtf.setBackground(Color.WHITE);
        didtf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        panel1.add(did);
        panel1.add(didtf);

        name  = new JLabel();
        name.setText("Customers's Name:");
        name.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        name.setForeground(Color.black);
        nametf = new JTextField(30);
        nametf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        nametf.setBackground(Color.WHITE);
        panel1.add(name);
        panel1.add(nametf);

        date  = new JLabel();
        date.setText("Date:");
        date.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        date.setForeground(Color.black);
        datetf = new JTextField(30);
        datetf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        datetf.setBackground(Color.WHITE);
        panel1.add(date);
        panel1.add(sql);

        prod  = new JLabel();
        prod.setText("Product:");
        prod.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        prod.setForeground(Color.black);
        prodtf = new JTextField(30);
        prodtf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        prodtf.setBackground(Color.WHITE);
        panel1.add(prod);
        panel1.add(prodtf);

        produID  = new JLabel();
        produID.setText("Product ID:");
        produID.setForeground(Color.black);
        produID.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        produIDtf = new JTextField(30);
        produIDtf.setBackground(Color.WHITE);
        produIDtf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        panel1.add( produID);
        panel1.add( produIDtf);

        qty  = new JLabel();
        qty.setText("Quantity:");
        qty.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        qty.setForeground(Color.black);
        qtytf = new JTextField(30);
        qtytf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        qtytf.setBackground(Color.WHITE);
        panel1.add( qty);
        panel1.add( qtytf);

        paid  = new JLabel();
        paid.setText("Amount Paid:");
        paid.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        paid.setForeground(Color.black);
        paidtf = new JTextField(30);
        paidtf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        paidtf.setBackground(Color.WHITE);
        panel1.add( paid);
        panel1.add( paidtf);

        balance  = new JLabel();
        balance.setText("Balance Cash:");
        balance.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        balance.setForeground(Color.black);
        balancetf = new JTextField(30);
        balancetf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        balancetf.setBackground(Color.WHITE);
        panel1.add( balance);
        panel1.add( balancetf);

        duedate  = new JLabel();
        duedate.setText("Due Date:");
        duedate.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        duedate.setForeground(Color.black);
        duedatetf = new JTextField(30);
        duedatetf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        duedatetf.setBackground(Color.WHITE);
        panel1.add(duedate);
        panel1.add(date2);


        phone  = new JLabel();
        phone.setText("Phone Number:");
        phone.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        phone.setForeground(Color.black);
        phonetf = new JTextField(30);
       phonetf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        phonetf.setBackground(Color.WHITE);
        panel1.add(phone);
        panel1.add(phonetf);

        stat  = new JLabel();
        stat .setText("Payment Status:");
        stat.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stat.setForeground(Color.black);
        stattf = new JTextField(30);
        stattf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stattf.setBackground(Color.WHITE);
        panel1.add(stat );
        panel1.add(stattf);

        addre  = new JLabel();
        addre .setText("Address:");
        addre.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        addre.setForeground(Color.black);
        addretf = new JTextField(30);
        addretf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        addretf.setBackground(Color.WHITE);
        panel1.add(addre );
        panel1.add(addretf);

        panel3 = new JPanel(new BorderLayout(0,10));
        panel3.setBackground(Color.decode("#64B5F6"));
        panel3.add(headl,BorderLayout.NORTH);
        panel3.add(panel1,BorderLayout.CENTER);
        panel3.add(panel4,BorderLayout.SOUTH);

        panel2 = new JPanel(new GridLayout(3,2,0,7));
        panel2.setBackground(Color.decode("#BBDEFB"));
        panel2.setBorder(BorderFactory.createLineBorder(Color.black));

        amount  = new JLabel();
        amount.setText("Amount");
       amount.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        amount.setForeground(Color.black);
        amounttf = new JTextField(30);
        amounttf.setFont(new Font("Liberation Serif", Font.BOLD,  13));
        amounttf.setBackground(Color.WHITE);
        panel2.add(amount);
        panel2.add(amounttf);

        discount  = new JLabel();
        discount.setText("Discount");
        discount.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        discount.setForeground(Color.black);
        discounttf = new JTextField(30);
        discounttf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        discounttf.setBackground(Color.WHITE);
        panel2.add(discount);
        panel2.add(discounttf);

        namount  = new JLabel();
        namount.setText("Net Amount");
        namount.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        namount.setForeground(Color.black);
        nettf = new JTextField(30);
        nettf.setBackground(Color.WHITE);
        nettf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        panel2.add(namount);
        panel2.add(nettf);


        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("New Dept");
        setSize(500,700);
        setLocationRelativeTo(null);
        setResizable(false);
        setBackground(Color.decode("#E3F2FD"));
        add(panel3, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object src = e.getSource();
        if (src == create){
           checkfornull();
            if (new OtherConnections().addDept(nametf.getText(),didtf.getText(),sql.datePicker.getJFormattedTextField().getText(),prodtf.getText(),produIDtf.getText(),
                    qtytf.getText(),date2.datePicker.getJFormattedTextField().getText(),stattf.getText(),paidtf.getText(),balancetf.getText(),phonetf.getText(),addretf.getText())){
                JOptionPane.showMessageDialog(null,"Bill Created Suuceessfully");

                nametf.setText("");
                didtf.setText("");
                sql.datePicker.getJFormattedTextField().setText("");
                prodtf.setText("");
                produIDtf.setText("");
                qtytf.setText("");
                date2.datePicker.getJFormattedTextField().setText("");
                stattf.setText("");
                paidtf.setText("");
                balancetf.setText("");
                phonetf.setText("");
                balancetf.setText("");
                phonetf.setText("");
                addretf.setText("");

            }

        }
    }

    public void checkfornull(){
        if (nametf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Customer's name field is empty");
            return;
        }
        if (paidtf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"How much are they paying");
            return;
        }
        if (qtytf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Empty Fields");
            return ;
        }
        if (addretf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Empty Fields");
            return;
        }

        if (produIDtf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Empty Fields");
            return;
        }

        if (phonetf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Phone number Field is empty");
            return;
        }
        if (didtf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Dept ID Field is empty");
            return;
        }
        if (stattf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Payment Status Field is empty");
            return;
        }
        if (balancetf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Balance Field is empty");
        }
    }
}
