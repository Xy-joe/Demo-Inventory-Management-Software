package views;

import presenters.TextHint;
import presenters.TimeandDateClass;
import presenters.pgscalculator;
import presenters.productconnections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

/**
 * Created by joebuntu on 3/31/17.
 */
public class CashierClass extends JFrame implements ActionListener {

    JPanel prodf;
    JTable tab;
    JButton  backmenu2;
    JTextArea ta = new JTextArea();
    JPanel orderpane = new JPanel();

    JTextField amount, balance, pp, psearch, ppr, pq,  bartf;

    public CashierClass() {
        final JButton calc1 = new JButton("Calculate"), removeorder = new JButton("Remove Order"), calc = new JButton("Balance"), order = new JButton("Order"), purchase = new JButton("purchase"), searchl = new JButton("Find Product");

        pp = new JTextField(20);
        pp.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        ppr = new JTextField(20);
        ppr.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        amount = new JTextField(20);
        amount.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        balance = new JTextField(20);
        balance.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        pq = new JTextField(20);
        pq.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
        bartf = new JTextField(20);
        bartf.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));


        //          RECEPTIONIST TABLE
        prodf = new JPanel();
        prodf.setLayout(new BorderLayout());
        DefaultTableModel protable = new productconnections().supermarketreception();
        tab = new JTable(protable);
        tab.setFont(new Font("Arial Black", 1, 12));
        tab.setBackground(Color.decode("#dcecfc"));
        tab.setForeground(Color.decode("#202020"));
        JScrollPane main = new JScrollPane(tab);
        tab.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    int row = tab.getSelectedRow();
                    String onclick = (tab.getModel().getValueAt(row, 0).toString());
                    String sql = "SELECT * FROM Supermarket.Products  Where S_N = '" + onclick + "' ";
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/views.Supermarket", "root", "joe9ty");
                    Statement stmt = con.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        String add2 = rs.getString("ProductID");
                        bartf.setText(add2);
                        String add3 = rs.getString("Product");
                        pp.setText(add3);
                        String add4 = rs.getString("Price");
                        ppr.setText(add4);
                        pq.setText("1");
                        amount.setText(null);
                        balance.setText(null);

                    }
                } catch (SQLException esp) {
                    JOptionPane.showMessageDialog(null, "Something Went wrong");

                }

            }
        });
        JPanel prodtextpanel = new JPanel();
        prodtextpanel.setLayout(new FlowLayout());
        prodtextpanel.setBackground(Color.BLACK);
        JPanel prodbtn = new JPanel();
        prodbtn.setLayout(new GridLayout(6, 2, 8, 8));
        prodbtn.setBackground(Color.decode("#202020"));
        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());

        JLabel bar = new JLabel("ProductID");
        bar.setFont(new Font("Virtual DJ", 1, 18));
        bar.setForeground(Color.decode("#ffffff"));
        bartf.setBackground(Color.white);
        prodbtn.add(bar);
        prodbtn.add(bartf);
        // Product Name

        JLabel lprod = new JLabel("Product");
        lprod.setFont(new Font("Virtual DJ", 1, 18));
        lprod.setForeground(Color.decode("#ffffff"));
        pp.setBackground(Color.white);
        prodbtn.add(lprod);
        prodbtn.add(pp);


        // Quantity
        JLabel pql = new JLabel("Quantity");
        pql.setFont(new Font("Virtual DJ", 1, 18));
        pql.setForeground(Color.decode("#ffffff"));
        pq.setBackground(Color.white);
        prodbtn.add(pql);
        prodbtn.add(pq);

        // Price
        JLabel pprl = new JLabel("Price");
        pprl.setFont(new Font("Virtual DJ", 1, 18));
        pprl.setForeground(Color.decode("#ffffff"));
        prodbtn.add(pprl);
        prodbtn.add(ppr);

        // Amount paid
        JLabel aml = new JLabel("Paid ");
        aml.setFont(new Font("Virtual DJ", 1, 18));
        aml.setForeground(Color.decode("#ffffff"));
        amount.setBackground(Color.white);
        prodbtn.add(aml);
        prodbtn.add(amount);

        // Balance
        JLabel ball = new JLabel("Balance");
        ball.setFont(new Font("Virtual DJ", 1, 18));
        ball.setForeground(Color.decode("#ffffff"));
        prodbtn.add(ball);
        prodbtn.add(balance);

        JPanel lasp = new JPanel();
        lasp.setLayout(new FlowLayout(10, 10, 10));
        lasp.setBackground(Color.black.decode("#202020"));

        backmenu2 = new JButton("Back");
        prodbtn.add(backmenu2);
        backmenu2.addActionListener(this);

        // Search
        psearch = new TextHint("Product naame or product id");
        psearch.setFont(new Font("mry_kacstQum", Font.PLAIN + Font.ITALIC, 15));
        psearch.setBackground(Color.white);
        //psearch.setFont(new java.awt.Font("Virtual DJ", 1, 18)); // NOI18N
        searchl.setFont(new Font("Virtual DJ", 1, 20));
        lasp.add(searchl);
        lasp.add(psearch);
        searchl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String val = psearch.getText();
                String prp = psearch.getText();
                String sql = "SELECT *  FROM Supermarket.Products WHERE ProductID = '" + val + "' OR Product = '" + prp + "'";
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/views.Supermarket", "root", "joe9ty");
                    Statement stmt = con.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery(sql);


                    if (rs.first()) {
                        String add0 = rs.getString("ProductID");
                        String add1 = rs.getString("Product");
                        String add5 = rs.getString("Price");

                        bartf.setText(add0);
                        pp.setText(add1);
                        ppr.setText(add5);
                        amount.setText("0.0");
                        balance.setText("0.0");
                        pq.setText("1");


                    }


                } catch (SQLException es) {
                    JOptionPane.showMessageDialog(null, "Search Connection Problem");
                    es.printStackTrace();

                }

            }
        });

        JTextPane time = new JTextPane();
        time.setFont(new Font("Virtual DJ", 1, 18));
        time.setBackground(Color.black);
        time.setForeground(Color.white);
        time.setText(new TimeandDateClass().output);
        JTextPane datee = new JTextPane();
        datee.setFont(new Font("Virtual DJ", 1, 18));
        datee.setBackground(Color.black);
        datee.setForeground(Color.white);
        datee.setText(new TimeandDateClass().date);
        lasp.add(time);
        lasp.add(datee);


        //ORDER PANEL
        ta.setText("\t Order View for Pegasus views.Supermarket \t\nPegasus views.Supermarket Order Receipt:");
        ta.setFont(new Font("BitStream Charter", 1, 15));
        JScrollPane ord = new JScrollPane(ta);
        orderpane.setLayout(new BorderLayout());
        orderpane.setBackground(Color.decode("#ffffff"));
        orderpane.add(ord, BorderLayout.CENTER);
        orderpane.add(removeorder, BorderLayout.SOUTH);


        //PRINTER PANEL
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(calc1);
        panel.add(calc);
        panel.add(order);
        panel.add(purchase);


        JButton print = new JButton("Print");
        print.setFont(new Font("Virtual DJ", 1, 20));
        print.setBackground(Color.decode("#3652a3"));


        JPanel las = new JPanel();
        las.setLayout(new BorderLayout());
        las.setBackground(Color.decode("#60a0df"));
        las.add(prodbtn, BorderLayout.WEST);
        las.add(panel, BorderLayout.CENTER);
        las.add(print, BorderLayout.EAST);
        las.add(backmenu2, BorderLayout.SOUTH);
        prodf.add(lasp, BorderLayout.NORTH);
        prodf.add(main, BorderLayout.CENTER);
        prodf.add(orderpane, BorderLayout.EAST);
        prodf.add(las, BorderLayout.SOUTH);
        setLayout(new BorderLayout());
        setSize(1100, 900);
        setMinimumSize(new Dimension(1100, 600));
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        add(prodf, BorderLayout.CENTER);

        //Register Listener

        calc1.setBackground(Color.decode("#99b286"));
        calc1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        String pr = pq.getText();
                                        int quatf = Integer.parseInt(pr);
                                        double total = 0;
                                        String price = ppr.getText();
                                        double prrr = Double.parseDouble(price);


                                        if (new pgscalculator().quantityPrice(total, quatf, prrr)) {
                                            total = quatf * prrr;
                                            String ok = Double.toString(total);
                                            ppr.setText(ok);
                                            amount.setText("0.0");
                                            balance.setText("0.0");
                                            return;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Amount Please");

                                        }
                                    }
                                }

        );

        calc.setBackground(Color.decode("#99b286"));
        calc.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent actionEvent) {
                                       try {
                                           String payed = amount.getText();
                                           double pay = Double.parseDouble(payed);
                                           double ba = 0;
                                           String bal = ppr.getText();
                                           double finbal = Double.parseDouble(bal);
                                           if (new pgscalculator().balanceprice(pay, finbal)) {
                                               ba = pay - finbal;
                                               String oko = Double.toString(ba);
                                               balance.setText(oko);
                                               return;
                                           } else {
                                               JOptionPane.showMessageDialog(null, "Please input the amount paid");
                                           }
                                       } catch (Exception js) {
                                           JOptionPane.showMessageDialog(null, "How much is He/She Paying ?");
                                           js.printStackTrace();
                                       }


                                   }
                               }
        );


        order.setBackground(Color.decode("#99b286"));
        order.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String product = pp.getText();
                    String quantity = pq.getText();
                    double price = Double.parseDouble(ppr.getText());

                    ta.append("\n\t" + product + ":\t" +
                            " " + quantity + "\t" + price + "\n");

                } catch (Exception js) {
                    JOptionPane.showMessageDialog(null, "Check Here");
                    js.printStackTrace();

                }

            }
        });
        removeorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    ta.removeAll();
                } catch (Exception js) {
                    js.printStackTrace();

                }
            }
        });
        purchase.setBackground(Color.decode("#99b286"));
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Boolean complete = ta.print();
                    if (complete) {
                        JOptionPane.showMessageDialog(null, "Done Printing");
                    } else {
                        JOptionPane.showMessageDialog(null, "Printing...");

                    }
                } catch (Exception js) {
                    js.printStackTrace();
                }


            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
       if (src == backmenu2){
            dispose();
        }
    }
}
