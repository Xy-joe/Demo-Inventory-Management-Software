package views;

import presenters.StaffConnection;
import presenters.TextHint;
import presenters.productconnections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.*;

public class Staffclass extends JFrame implements ActionListener{
    JPanel staff,backpanel;
    JTable staftab;
    JLabel selectionhead;
    JTextField sntf, fnametf, stafID, gentf, postf, phon, addre, searchtf;
    JComboBox selection;
    JButton backbut,print,refresh, backmenu, Searchbtn;
   private DefaultTableModel costomermodel,dt,search;
    String[] sortcategories =  {"Serial No","Sort by date", "Alphabetically by name","Alphabetically by job office "};


    public void retrieve(){
         dt  = new StaffConnection().staffDataretrival();
        staftab.setModel(dt);
        searchtf.setText("");
    }

    public  Staffclass(){
         costomermodel = new StaffConnection().adminStaff();
        staftab = new JTable(costomermodel);
        staftab.setBackground(Color.decode("#CFD8DC"));
        staftab.setGridColor(Color.WHITE);
        staftab.setAutoCreateRowSorter(false);
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
        jPanel2.setBackground(Color.decode("#607D8B"));
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        final JPanel admintextfpanel = new JPanel();
        admintextfpanel.setLayout(new GridLayout(7, 2));
        admintextfpanel.setBackground(Color.decode("#2a334f"));



        selection = new JComboBox(sortcategories);
        selection.setBackground(Color.decode("#FFFFFF"));
        selection.setFont(new Font("Liberation Serif", Font.BOLD,20));
        selection.addActionListener(this);
        selectionhead = new JLabel();
        selectionhead.setText("Sort Categories ");
        selectionhead.setForeground(Color.WHITE);
        selectionhead.setFont(new Font("Virtual DJ", Font.BOLD,20));
        jPanel2.add(selectionhead);
        jPanel2.add(selection);

        searchtf = new TextHint("Enter the staff id here");
        searchtf.setBackground(Color.WHITE);
        searchtf.setFont(new java.awt.Font("Virtual DJ", 1, 19)); // NOI18N
        Searchbtn = new JButton("Find Staff");
        Searchbtn.setBackground(Color.decode("#90A4AE"));
        Searchbtn.setForeground(Color.WHITE);
        Searchbtn.addActionListener(this);
        jPanel2.add(Searchbtn);
        jPanel2.add(searchtf);


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

        backpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backpanel.setBackground(Color.decode("#90A4AE"));
        backbut = new JButton("Back");
        refresh = new JButton("Refresh");
        refresh.addActionListener(this);
        refresh.setBackground(Color.WHITE);
        backpanel.add(refresh);
        print = new JButton("Print");
       print.addActionListener(this);
        print.setBackground(Color.WHITE);
        backpanel.add(print);
        backbut.addActionListener(this);
        backbut.setBackground(Color.WHITE);
        backpanel.add(backbut);

        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(200, 100);
        setResizable(false);
        setSize(1000,500);
        setTitle("Staff Table");
       add(jPanel2, BorderLayout.NORTH);
        add(maintable, BorderLayout.CENTER);
        add(backpanel, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == backbut){
            dispose();
            setVisible(false);
        }else if (src == refresh){
            retrieve();
        }else if(src == selection) {
            String item = (String)selection.getSelectedItem();
            int datecolumn = 8;
            int serialnocolumn = 0;
            int officecolumn = 5;
            int namecolumn = 1;
            if (item.equals("Sort by date")){
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(staftab.getModel());
                staftab.setRowSorter(sorter);
                staftab.setAutoCreateRowSorter(false);
                ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
                sortKeys.add(new RowSorter.SortKey(datecolumn, SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
                sorter.sort();

            }else if (item.equals("Serial No")){
               TableRowSorter<TableModel> sorter = new TableRowSorter<>(staftab.getModel());
                staftab.setRowSorter(sorter);
                staftab.setAutoCreateRowSorter(false);
                ArrayList<RowSorter.SortKey> keys = new ArrayList<>();
                keys.add(new RowSorter.SortKey(serialnocolumn,SortOrder.ASCENDING));
                sorter.setSortKeys(keys);
                sorter.sort();


            }else if (item.equals("Alphabetically by job office")) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(staftab.getModel());
                staftab.setRowSorter(sorter);
                staftab.setAutoCreateRowSorter(false);
                ArrayList<RowSorter.SortKey> keys = new ArrayList<>();
                keys.add(new RowSorter.SortKey(officecolumn, SortOrder.ASCENDING));
                sorter.setSortKeys(keys);
                sorter.sort();


            }else if (item.equals("Alphabetically by name")) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<>(staftab.getModel());
                staftab.setRowSorter(sorter);
                staftab.setAutoCreateRowSorter(false);
                ArrayList<RowSorter.SortKey> keys = new ArrayList<>();
                keys.add(new RowSorter.SortKey(namecolumn, SortOrder.ASCENDING));
                sorter.setSortKeys(keys);
                sorter.sort();

            }
            }else if (src == Searchbtn){
            if (searchtf.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please enter an Id to search");
            }else {
                search = new StaffConnection().staffsearch(searchtf.getText());
                staftab.setModel(search);
            }
        }
    }
}
