package views;

import presenters.StaffConnection;
import presenters.productconnections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Staffclass extends JFrame implements ActionListener{
    JPanel staff,backpanel;
    JTable staftab;
    JTextField sntf, fnametf, stafID, gentf, postf, phon, addre, searchtf;
    JPanel main = new JPanel();
    JButton backbut;

    public void retrieve(){
        DefaultTableModel dt  = new StaffConnection().staffDataretrival();
        staftab.setModel(dt);
    }

    public  Staffclass(){
        final DefaultTableModel costomermodel = new StaffConnection().adminStaff();
        staftab = new JTable(costomermodel);
        staff = new JPanel();
        sntf = new JTextField(25);
        fnametf = new JTextField(25);
        stafID = new JTextField();
        gentf = new JTextField(10);
                postf = new JTextField(25);
                phon = new JTextField(18);
                addre = new JTextField(50);
        searchtf = new JTextField(25);

        JScrollPane maintable = new JScrollPane(staftab);
        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.decode("#2a334f"));
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        final JPanel admintextfpanel = new JPanel();
        admintextfpanel.setLayout(new GridLayout(7, 2));
        admintextfpanel.setBackground(Color.decode("#2a334f"));
        final JButton backmenu, Searchbtn;
        JButton addrow2btn = new JButton();
        addrow2btn.setBackground(Color.decode("#fd9901"));
        addrow2btn.setFont(new java.awt.Font("Virtual DJ", 1, 19));
        addrow2btn.setForeground(Color.WHITE);
        addrow2btn.setText("Add New Staff");


        JButton save2btn = new JButton();
        save2btn.setBackground(Color.decode("#fd9901"));
        save2btn.setFont(new java.awt.Font("Virtual DJ", 1, 19));
        save2btn.setForeground(Color.WHITE);
        save2btn.setText("Update ");
        save2btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int index = staftab.getSelectedRow();
                String date = staftab.getValueAt(index, 0).toString();
                if (new StaffConnection().staffUpdate(sntf.getText(),sntf.getText(), fnametf.getText(), stafID.getText(), gentf.getText(), postf.getText(), phon.getText(), addre.getText(),addre.getText())) {
                    JOptionPane.showMessageDialog(null, "Successfully Updated");



                    sntf.setText("");
                    fnametf.setText("");
                    stafID.setText("");
                    gentf.setText("");
                    postf.setText("");
                    phon.setText("");
                    addre.setText("");

                    retrieve();

                } else {
                    JOptionPane.showMessageDialog(null, "Not Updated");
                }


            }
        });
        JButton delete2btn = new JButton();
        delete2btn.setBackground(Color.decode("#fd9901"));
        delete2btn.setFont(new java.awt.Font("Virtual DJ", 1, 19));
        delete2btn.setForeground(Color.WHITE);
        delete2btn.setText("Remove Staff");
        delete2btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String[] op = {"Yes", "No"};
                int ans = JOptionPane.showOptionDialog(null, "Sure to delete", "Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[1]);

                if (ans == 0) {

                    int index = staftab.getSelectedRow();
                    String date = staftab.getValueAt(index, 0).toString();

                    if (new productconnections().supermarketdelete(date))
                        JOptionPane.showMessageDialog(null, "Deleted Successfully ");

                    sntf.setText("");
                    fnametf.setText("");
                    stafID.setText("");
                    gentf.setText("");
                    postf.setText("");
                    phon.setText("");
                    addre.setText("");


                    retrieve();
                }else {
                    JOptionPane.showMessageDialog(null, "Not Deleted");
                }
            }

        });
        searchtf = new JTextField(10);
        searchtf.setBackground(Color.white);
        searchtf.setFont(new java.awt.Font("Virtual DJ", 1, 19)); // NOI18N
        Searchbtn = new JButton("Find Staff");
        Searchbtn.setBackground(Color.decode("#fd9901"));
        Searchbtn.setFont(new Font("Virtual DJ", 1, 19));
        Searchbtn.setForeground(Color.WHITE);
        jPanel2.add(Searchbtn);
        jPanel2.add(searchtf);
        Searchbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {



            }
        });

        JPanel backpa = new JPanel();
        backmenu = new JButton("Back");
        backpa.add(backmenu);
        sntf.setBackground(Color.decode("#ffffff"));
        JLabel jLabel0 = new JLabel();
        jLabel0.setBackground(new java.awt.Color(51, 51, 51));
        jLabel0.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel0.setForeground(Color.decode("#dcecfc"));
        jLabel0.setText("SURNAME");
        admintextfpanel.add(jLabel0);admintextfpanel.add(sntf);

        fnametf.setBackground(Color.decode("#ffffff"));
        fnametf.setBounds(10, 10, 25, 5);
        JLabel jLabel1 = new JLabel();
        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(Color.decode("#dcecfc"));
        jLabel1.setText("FIRST NAME");
        admintextfpanel.add(jLabel1);admintextfpanel.add(fnametf);

        stafID.setBackground(Color.decode("#ffffff"));
        JLabel jLabel2 = new JLabel();
        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabel2.setForeground(Color.decode("#dcecfc"));
        jLabel2.setText("STAFFID");
        admintextfpanel.add(jLabel2);
        admintextfpanel.add(stafID);

        gentf.setBackground(Color.decode("#ffffff"));
        JButton bacode = new JButton();
        bacode.setBackground(Color.decode("#ffaa00"));
        bacode.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        bacode.setForeground(Color.decode("#dcecfc"));
        bacode.setText("Gender");
        admintextfpanel.add(bacode);admintextfpanel.add(gentf);


        postf.setBackground(Color.decode("#ffffff"));
        JLabel jLabel3 = new JLabel();
        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabel3.setForeground(Color.decode("#dcecfc"));
        jLabel3.setText("Position");
        admintextfpanel.add(jLabel3);admintextfpanel.add(postf);


        phon.setBackground(Color.decode("#ffffff"));
        JLabel jLabel4 = new JLabel();
        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabel4.setForeground(Color.decode("#dcecfc"));
        jLabel4.setText("Phone Number");
        admintextfpanel.add(jLabel4);admintextfpanel.add(phon);

        addre.setBackground(Color.decode("#ffffff"));
        JLabel jLabel5 = new JLabel();
        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabel4.setForeground(Color.decode("#dcecfc"));
        jLabel4.setText("Address");
        admintextfpanel.add(jLabel5);admintextfpanel.add(addre);

        backpanel = new JPanel(new BorderLayout());
        backbut = new JButton("Back");
        backbut.addActionListener(this);
        backpanel.add(backbut,BorderLayout.CENTER);

        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800,500);
        setTitle("Staff Table");
       add(jPanel2, BorderLayout.NORTH);
        add(maintable, BorderLayout.CENTER);
        add(backpanel, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == backbut){
            new Supermarket().mainadmin.getContentPane().add(new Supermarket().cost).setVisible(true);
            new Supermarket().welcome.setVisible(false);
            setVisible(false);
        }
    }
}
