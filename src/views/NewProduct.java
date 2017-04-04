package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import presenters.productconnections;

/**
 * Created by joebuntu on 3/31/17.
 */
public class NewProduct extends JFrame  {
    JPanel mainpanel, fieldspanel, jPanel;
    JTextField datetF,prodID, prodname, prodprice, searchtf, pp, psearch, ppr,bcodetf, sntf, stock;
    JButton back;
    JLabel header;

    public NewProduct()
    {
        header = new JLabel("Add New Product",JLabel.LEFT);
        header.setFont(new Font("Liberation Serif", Font.BOLD,  26));
        header.setForeground(Color.decode("#ffffff"));
        mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout());
        fieldspanel = new JPanel(new GridLayout(6,2,5,5));
        fieldspanel.setBackground(Color.decode("#0288D1"));



        sntf = new JTextField(20); sntf.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        prodID = new JTextField(20); prodID.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        prodname = new JTextField(20); prodname.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        prodprice = new JTextField(20); prodprice.setFont(new Font("mry_kacstQum", Font.BOLD+Font.ITALIC, 15));
        pp = new JTextField(20); pp.setFont(new Font("mry_kacstQum", Font.BOLD+Font.ITALIC, 15));
        ppr = new JTextField(20); ppr.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        datetF = new JTextField(20); datetF.setFont(new Font("mry_kacstQum", Font.BOLD+Font.ITALIC, 15));
        bcodetf = new JTextField(20);bcodetf.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        stock = new JTextField(20);bcodetf.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));


        sntf.setBackground(Color.decode("#ffffff"));
        datetF.setBounds(5,5,15,10);
        JLabel jLabel0 = new JLabel();
        jLabel0.setBackground(new java.awt.Color(51, 51, 51));
        jLabel0.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel0.setForeground(Color.decode("#dcecfc"));
        jLabel0.setText("S/N");
        fieldspanel.add(jLabel0);fieldspanel.add(sntf);

        datetF.setBackground(Color.decode("#ffffff"));
        datetF.setBounds(5,5,15,10);
        JLabel jLabel1 = new JLabel();
        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel1.setForeground(Color.decode("#dcecfc"));
        jLabel1.setText("Date");
        fieldspanel.add(jLabel1);fieldspanel.add(datetF);

        prodID.setBackground(Color.decode("#ffffff"));
        JLabel jLabel2 = new JLabel();
        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel2.setForeground(Color.decode("#dcecfc"));
        jLabel2.setText("ProductID");
        fieldspanel.add(jLabel2);fieldspanel.add(prodID);

        bcodetf.setBackground(Color.decode("#ffffff"));
        JButton bacode = new JButton("Generate Code");
        bacode.setBackground(Color.decode("#303F9F"));
        bacode.setFont(new Font("Serif", 1, 10)); // NOI18N
        bacode.setForeground(Color.WHITE);
        bacode.setBounds(5,5,15,10);
        bacode.setFocusPainted(false);
        bacode.setBorderPainted(false);
        fieldspanel.add(bacode,BorderLayout.CENTER);fieldspanel.add(bcodetf);


        prodname.setBackground(Color.decode("#ffffff"));
        JLabel jLabel3 = new JLabel();
        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        jLabel3.setForeground(Color.decode("#dcecfc"));
        jLabel3.setText("Product");
        fieldspanel.add(jLabel3);fieldspanel.add(prodname);


        prodprice.setBackground(Color.decode("#ffffff"));
        JLabel jLabel4 = new JLabel();
        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new Font("Arial Black", 1, 20)); // NOI18N
        jLabel4.setForeground(Color.decode("#dcecfc"));
        jLabel4.setText("Price");
        fieldspanel.add(jLabel4);fieldspanel.add(prodprice);

        stock.setBackground(Color.decode("#ffffff"));
        JLabel jLabel5 = new JLabel();
        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setFont(new Font("Arial Black", 1, 20)); // NOI18N
        jLabel5.setForeground(Color.decode("#dcecfc"));
        jLabel5.setText("Stock");
        fieldspanel.add(jLabel5);fieldspanel.add(stock);

        jPanel = new JPanel();
        jPanel.setBackground(Color.decode("#0288D1"));
        jPanel.setLayout(new GridLayout(1,1,0,15));

        JButton addbtn = new JButton();
        addbtn.setBackground(Color.decode("#303F9F"));
        addbtn.setFont(new java.awt.Font("Virtual DJ", 1, 19));
        addbtn.setForeground(Color.WHITE);
        addbtn.setText("Add New Product");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (new productconnections().supermarketadd( datetF.getText(), prodID.getText(), bcodetf.getText(), prodname.getText(), prodprice.getText(),stock.getText())) {
                    JOptionPane.showMessageDialog(null, "Successfully Added");

                    sntf.setText("");
                    datetF.setText("");
                    prodID.setText("");
                    bcodetf.setText("");
                    prodprice.setText("");
                    prodname.setText("");
                    stock.setText("");

                    retrieve();
                } else {
                    JOptionPane.showMessageDialog(null, "Not Added");
                }

            }
        });




        back = new JButton("Back");
        jPanel.add(back);


        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(500,100);
        setSize(700,900);
        setLayout(new BorderLayout());
        add(header,BorderLayout.NORTH);
        add(fieldspanel,BorderLayout.CENTER);
    }
    private void retrieve(){
        DefaultTableModel dt  = new productconnections().supermaketDataretrival();
       new Supermarket().costomertable.setModel(dt);
    }
}
