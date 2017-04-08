package views;

import presenters.OtherConnections;
import presenters.TextHint;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeptClass extends JFrame implements ActionListener{
    JPanel staff,backpanel;
    JTable history_tab;
    JTextField  searchtf;
    JPanel main = new JPanel();
    JButton backbut,print,refresh,searchbtn;
    JComboBox selection;
    JLabel selectionhead;
   private DefaultTableModel dt,search, costomermodel;
    public void retrieve(){
         dt  = new OtherConnections().deptTable();
        history_tab.setModel(dt);
        searchtf.setText("");
    }

    public DeptClass(){
        costomermodel = new OtherConnections().deptTable();
        history_tab = new JTable(costomermodel);
        history_tab.setBackground(Color.decode("#CFD8DC"));
        history_tab.setGridColor(Color.WHITE);

        JScrollPane maintable = new JScrollPane(history_tab);
        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.decode("#607D8B"));
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));


        selection = new JComboBox(new String[] {"Date", "Name","Time","Product"});
        selection.setBackground(Color.decode("#FFFFFF"));
        selection.setFont(new Font("Liberation Serif", Font.BOLD,20));
        selectionhead = new JLabel();
        selectionhead.setText("Sort dept By ");
        selectionhead.setForeground(Color.WHITE);
        selectionhead.setFont(new Font("Virtual DJ", Font.BOLD,20));
        jPanel2.add(selectionhead);
        jPanel2.add(selection);

        searchtf = new TextHint("Enter the Dept id here");
        searchtf.setBackground(Color.WHITE);
        searchtf.setFont(new java.awt.Font("Virtual DJ", 1, 19)); // NOI18N
        searchbtn = new JButton("Find Staff");
        searchbtn.setBackground(Color.decode("#90A4AE"));
        searchbtn.setForeground(Color.WHITE);
        searchbtn.addActionListener(this);
        jPanel2.add(searchbtn);
        jPanel2.add(searchtf);


        backpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backpanel.setBackground(Color.decode("#607D8B"));
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
        setSize(1100,500);
        setTitle("Dept History Table");
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
        }else if (src == searchbtn){
            if (searchtf.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please enter an Id to search");
            }else {
                search = new OtherConnections().searchDept(searchtf.getText());
                history_tab.setModel(search);
            }
        }
    }
}
