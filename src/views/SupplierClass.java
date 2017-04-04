package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import presenters.TextHint;
import presenters.supplierconnections;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SupplierClass extends JFrame implements ActionListener {
    JPanel staff,backpanel;
    JTable suppliertable;
    JTextField sntf, fnametf, stafID, gentf, postf, phon, addre, searchtf;
    JPanel main = new JPanel();
    JButton backbut,print,refresh;

    public void retrieve(){
        DefaultTableModel dt  = new supplierconnections().refreshSupplier();
        suppliertable.setModel(dt);
    }
    public SupplierClass() {

        final DefaultTableModel costomermodel = new supplierconnections().supplieradminconnect();
        suppliertable = new JTable(costomermodel);
        suppliertable.setBackground(Color.decode("#FFCCBC"));
        suppliertable.setGridColor(Color.WHITE);
        staff = new JPanel();
        sntf = new JTextField(25);
        fnametf = new JTextField(25);
        stafID = new JTextField();
        gentf = new JTextField(10);
        postf = new JTextField(25);
        phon = new JTextField(18);
        addre = new JTextField(50);
        searchtf = new JTextField(25);

        JScrollPane maintable = new JScrollPane(suppliertable);
        JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.decode("#FF5722"));
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        final JPanel admintextfpanel = new JPanel();
        admintextfpanel.setLayout(new GridLayout(7, 2));
        admintextfpanel.setBackground(Color.decode("#ffecb3"));
        final JButton backmenu, Searchbtn;

        searchtf = new TextHint("Enter the name or code of  the Supplier here");
        searchtf.setBackground(Color.white);
        searchtf.setFont(new java.awt.Font("Virtual DJ", 1, 19)); // NOI18N
        Searchbtn = new JButton("Find Supplier");
        Searchbtn.setBackground(Color.decode("#BF360C"));
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

        backpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backpanel.setBackground(Color.decode("#D84315"));
        backbut = new JButton("Back");
        refresh = new JButton("Refresh");
        refresh.addActionListener(this);
        refresh.setForeground(Color.WHITE);
        refresh.setFont(new Font("Virtual DJ", 1, 19));
        refresh.setBackground(Color.decode("#BF360C"));
        backpanel.add(refresh);
        print = new JButton("Print");
        print.addActionListener(this);
        print.setBackground(Color.decode("#BF360C"));
        print.setFont(new Font("Virtual DJ", 1, 19));
        print.setForeground(Color.WHITE);
        backpanel.add(print);
        backbut.addActionListener(this);
        backbut.setForeground(Color.WHITE);
        backbut.setFont(new Font("Virtual DJ", 1, 19));
        backbut.setBackground(Color.decode("#BF360C"));
        backpanel.add(backbut);

        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(200, 100);
        setResizable(true);
        setMinimumSize(new Dimension(1000,500));
        setSize(1200,700);
        setTitle("Supplier Table");
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

