package views;

import presenters.OtherConnections;
import presenters.StaffConnection;
import presenters.productconnections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryClass extends JFrame implements ActionListener{
    JPanel staff,backpanel;
    JTable history_tab;
    JTextField sntf, fnametf, stafID, gentf, postf, phon, addre, searchtf;
    JPanel main = new JPanel();
    JButton backbut,print,refresh;
    JComboBox selection;
    JLabel selectionhead;

    public void retrieve(){
        DefaultTableModel dt  = new OtherConnections().purchaseTable();
        history_tab.setModel(dt);
    }

    public HistoryClass(){
        final DefaultTableModel costomermodel = new OtherConnections().purchaseTable();
        history_tab = new JTable(costomermodel);
        history_tab.setFont(new Font("Liberation Serif", Font.BOLD,  18));
                history_tab.setBackground(Color.decode("#FFCCBC"));
        history_tab.setGridColor(Color.WHITE);

        staff = new JPanel();
        sntf = new JTextField(25);
        fnametf = new JTextField(25);
        stafID = new JTextField();
        gentf = new JTextField(10);
                postf = new JTextField(25);
                phon = new JTextField(18);
                addre = new JTextField(50);
        searchtf = new JTextField(25);

        JScrollPane maintable = new JScrollPane(history_tab);
        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.decode("#FF5722"));
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        final JPanel admintextfpanel = new JPanel();
        admintextfpanel.setLayout(new GridLayout(7, 2));
        admintextfpanel.setBackground(Color.decode("#2a334f"));
        final JButton backmenu, Searchbtn;
        JButton addrow2btn = new JButton();
        addrow2btn.setBackground(Color.decode("#fd9901"));
        addrow2btn.setFont(new Font("Virtual DJ", 1, 19));
        addrow2btn.setForeground(Color.WHITE);
        addrow2btn.setText("Add New Staff");

        selection = new JComboBox(new String[] {"Date", "Name","Time","Product"});
        selection.setBackground(Color.decode("#FFFFFF"));
        selection.setFont(new Font("Liberation Serif", Font.BOLD,20));
        selectionhead = new JLabel();
        selectionhead.setText("Order History By ");
        selectionhead.setForeground(Color.WHITE);
        selectionhead.setFont(new Font("Virtual DJ", Font.BOLD,20));


        jPanel2.add(selectionhead);
        jPanel2.add(selection);



        backpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backpanel.setBackground(Color.decode("#D84315"));
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
        setTitle("History Table");
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
        }
    }
}
