import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Supermarket {
    JTabbedPane tpane;
  JPanel cost;
    final JPanel staff = new Staffclass().main;
  JPanel prodf;
    JFrame fame;
  JTable costomertable;
     JTable tab;
    double price = 0;

    public static void main(String[] joe) {
  EventQueue.invokeLater(new Runnable() {
     @Override
     public void run() {
        try{
           Supermarket window = new Supermarket();
           window.fame.setVisible(true);
        }
        catch (Exception evt){
           evt.printStackTrace();
        }
     }
  });

    }

        JTextArea ta = new JTextArea();
    JPanel orderpane = new JPanel();

    ImageIcon img = new ImageIcon(getClass().getResource("resource/pg.jpg"));
    ImageIcon img1 = new ImageIcon(getClass().getResource("pgg.jpg"));

    private void retrieve(){
        DefaultTableModel dt  = new pgsConnect().supermaketDataretrival();
        costomertable.setModel(dt);
    }
    JTextField datetF,prodID, prodname, prodprice, amount, balance, searchtf, pp, psearch, ppr,bcodetf, pq, sntf, bartf;
   public Supermarket() {
       fame = new JFrame();
        fame.setBounds(400,400,1100,700);
      fame.setLocationRelativeTo(null);
       fame.setTitle("PEGASUS SOFTWARE");
        fame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       fame.setLayout(new CardLayout(0,0));
       cost = new JPanel();
 final JTable jtab1;
       cost.setLayout(new BorderLayout());
       cost.setVisible(false);


       final JButton calc1 = new JButton("Calculate"),removeorder = new JButton("Remove Order"), calc = new JButton("Balance"), order = new JButton("Order"), purchase = new JButton("purchase"), searchl = new JButton("Find Product");
          // WELCOME SCREEN
       JPanel imgpane = new JPanel();
       imgpane.setLayout(new BorderLayout());
       JLabel pg = new JLabel(img);
       imgpane.add(pg);
          final JPanel welcome = new JPanel();
          welcome.setLayout(new BorderLayout());
         welcome.setBackground(Color.decode("#2a334f"));
          welcome.setVisible(true);
      JPanel menubtn = new JPanel();
       menubtn.setLayout(new FlowLayout());

      menubtn.setBackground(Color.decode("#c3cad1"));
          JButton pro = new JButton(" The Administrator");
      pro.setBounds(79,100,100,79);

      JButton pri = new JButton(" The Cashier");
       JLabel supname = new JLabel("PGS",JLabel.CENTER);
       JLabel comme = new JLabel("licenced to everyday Supermarket",JLabel.RIGHT);
       comme.setFont(new Font("URW Chancery L", Font.ITALIC, 15));
       comme.setForeground(Color.decode("#ffffff"));
       supname.setFont(new Font("Liberation Serif", Font.BOLD,  55));
       supname.setForeground(Color.decode("#ffffff"));
       supname.setBackground(Color.decode("#ffffff"));


      pri.setBounds(79,79,100,79);
       menubtn.add(pro);
      menubtn.add(pri);
       imgpane.add(pg, BorderLayout.CENTER);
       imgpane.add(menubtn, BorderLayout.SOUTH);
       welcome.add(supname, BorderLayout.NORTH);
      welcome.add(imgpane, BorderLayout.CENTER);
       welcome.add(comme, BorderLayout.SOUTH);




       sntf = new JTextField(20); sntf.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
       prodID = new JTextField(20); prodID.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
       prodname = new JTextField(20); prodname.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
       prodprice = new JTextField(20); prodprice.setFont(new Font("mry_kacstQum", Font.BOLD+Font.ITALIC, 15));
       pp = new JTextField(20); pp.setFont(new Font("mry_kacstQum", Font.BOLD+Font.ITALIC, 15));
       ppr = new JTextField(20); ppr.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
       psearch = new JTextField(20); psearch.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
       amount = new JTextField(20); amount.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
       balance = new JTextField(20); balance.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
       datetF = new JTextField(20); datetF.setFont(new Font("mry_kacstQum", Font.BOLD+Font.ITALIC, 15));
       pq = new JTextField(20); pq.setFont(new Font("mry_kacstQum", Font.BOLD+Font.ITALIC, 15));
       bcodetf = new JTextField(20);bcodetf.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));
       bartf = new JTextField(20);bartf.setFont(new Font("mry_kacstQum", Font.BOLD + Font.ITALIC, 15));

         //ADMINISTRATOR  PRODUCTS TABLE
       final  DefaultTableModel costomermodel = new pgsConnect().supermarketadminconnect();
        costomertable = new JTable(costomermodel);
       costomertable.setBackground(Color.decode("#dcecfc"));
       costomertable.setFont(new Font("Droid Sans Ethopic", 1, 12));
       costomertable.setForeground(Color.decode("#202020"));
       costomertable.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               super.mouseClicked(e);
               double prodid = 0;
               String prodidm = Double.toString(prodid);
               try {
                   int row = costomertable.getSelectedRow();
                   String onclick = (costomertable.getModel().getValueAt(row, 0).toString());
                   String sql = "SELECT * FROM Supermarket.Products  WHERE S_N = '" + onclick + "' ";
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
                   Statement stmt = con.prepareStatement(sql);
                   ResultSet rs = stmt.executeQuery(sql);

                   if (rs.next()) {
                       String add0 = rs.getString("S_N");
                       String add1 = rs.getString("Date");
                       String add2 = rs.getString("ProductID");
                       String add3 = rs.getString("Barcode");
                       String add4 = rs.getString("Product");
                       String add5 = rs.getString("Price");

                       sntf.setText(add0);
                       datetF.setText(add1);
                       prodID.setText(add2);
                       bcodetf.setText(add3);
                       prodname.setText(add4);
                       prodprice.setText(add5);


                   }
               } catch (SQLException esp) {
                   JOptionPane.showMessageDialog(null, "Something Went wrong");
esp.printStackTrace();
               }
           }
       });

       JScrollPane maintable = new JScrollPane(costomertable);
        final JPanel jPanel2 = new JPanel();
        jPanel2.setBackground(Color.decode("#202020"));
        jPanel2.setLayout(new FlowLayout(10, 10, 10));
        final JPanel admintextfpanel = new JPanel();
        admintextfpanel.setLayout(new GridLayout(6, 2));
        admintextfpanel.setBackground(Color.decode("#202020"));
      final JButton backmenu, backmenu2, Searchbtn;
        JButton addrow2btn = new JButton();
        addrow2btn.setBackground(Color.decode("#fd9901"));
        addrow2btn.setFont(new java.awt.Font("Virtual DJ", 1, 19));
       addrow2btn.setForeground(Color.WHITE);
        addrow2btn.setText("Add New Product");
        addrow2btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (new pgsConnect().supermarketadd(sntf.getText(),datetF.getText(), prodID.getText(), bcodetf.getText(), prodname.getText(), prodprice.getText())) {
                    JOptionPane.showMessageDialog(null, "Successfully Added");

                    sntf.setText("");
                    datetF.setText("");
                    prodID.setText("");
                    bcodetf.setText("");
                    prodprice.setText("");
                    prodname.setText("");

                    retrieve();
                } else {
                    JOptionPane.showMessageDialog(null, "Not Added");
                }

            }
        });
        jPanel2.add(addrow2btn);
        JButton save2btn = new JButton();
        save2btn.setBackground(Color.decode("#fd9901"));
        save2btn.setFont(new java.awt.Font("Virtual DJ", 1, 19));
       save2btn.setForeground(Color.WHITE);
        save2btn.setText("Update");
        save2btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (new pgsConnect().supermarketUpdate(sntf.getText(), datetF.getText(), prodID.getText(),bcodetf.getText(), prodname.getText(), prodprice.getText())){
                    JOptionPane.showMessageDialog(null, "Successfully Updated");



                    sntf.setText("");
                    datetF.setText("");
                    prodID.setText("");
                    bcodetf.setText("");
                    prodname.setText("");
                    prodprice.setText("");

                    retrieve();

                 } else {
                JOptionPane.showMessageDialog(null, "Not Updated");
            }


        }
        });
        jPanel2.add(save2btn);
       JButton delete2btn = new JButton();
       delete2btn.setBackground(Color.decode("#fd9901"));
       delete2btn.setFont(new java.awt.Font("Virtual DJ", 1, 19));
       delete2btn.setForeground(Color.WHITE);
       delete2btn.setText("Delete Product");
       delete2btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               String[] op = {"Yes", "No"};
               int ans = JOptionPane.showOptionDialog(null, "Sure to delete", "Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[1]);

               if (ans == 0) {

                   int index = costomertable.getSelectedRow();
                   String date = costomertable.getValueAt(index, 0).toString();

                   if (new pgsConnect().supermarketdelete(date))
                       JOptionPane.showMessageDialog(null, "Deleted Successfully ");

                   datetF.setText("");
                   prodID.setText("");
                   bcodetf.setText("");
                   prodname.setText("");
                   prodprice.setText("");


                   retrieve();
               }else {
                   JOptionPane.showMessageDialog(null, "Not Deleted");
               }
               }

       });
       jPanel2.add(delete2btn);
        searchtf = new JTextField(10);
        searchtf.setBackground(Color.white);
        searchtf.setFont(new java.awt.Font("Virtual DJ", 1, 19)); // NOI18N
         Searchbtn = new JButton("Find Product");
       Searchbtn.setBackground(Color.decode("#fd9901"));
       Searchbtn.setFont(new Font("Virtual DJ", 1, 19));
       Searchbtn.setForeground(Color.WHITE);
       jPanel2.add(Searchbtn);
        jPanel2.add(searchtf);
       Searchbtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {

               String val = searchtf.getText();  String prop = searchtf.getText();

               String sql ="SELECT *  FROM Supermarket.Products WHERE Barcode = '"+val+"' OR Product = '"+prop+"'";
               try{
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
                   Statement stmt = con.prepareStatement(sql);
                   ResultSet rs = stmt.executeQuery(sql);


                   if (rs.first()) {
                       String add0 = rs.getString("S_N");
                       String add1 = rs.getString("Date");
                       String add2 = rs.getString("ProductID");
                       String add3 = rs.getString("Barcode");
                       String add4 = rs.getString("Product");
                       String add5 = rs.getString("Price");

                       sntf.setText(add0);
                       datetF.setText(add1);
                       prodID.setText(add2);
                       bcodetf.setText(add3);
                       prodname.setText(add4);
                       prodprice.setText(add5);


                   }



               }catch (SQLException es){
                   JOptionPane.showMessageDialog(null, "Search Connection Problem");
                   es.printStackTrace();

           }
           }
       });

JPanel backpa = new JPanel();
      backmenu = new JButton("Back");
      backpa.add(backmenu);
       sntf.setBackground(Color.decode("#ffffff"));
       datetF.setBounds(10, 10, 25, 5);
       JLabel jLabel0 = new JLabel();
       jLabel0.setBackground(new java.awt.Color(51, 51, 51));
       jLabel0.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
       jLabel0.setForeground(Color.decode("#dcecfc"));
       jLabel0.setText("S/N");
       admintextfpanel.add(jLabel0);admintextfpanel.add(sntf);

        datetF.setBackground(Color.decode("#ffffff"));
       datetF.setBounds(10, 10, 25, 5);
        JLabel jLabel1 = new JLabel();
        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(Color.decode("#dcecfc"));
        jLabel1.setText("Date");
        admintextfpanel.add(jLabel1);admintextfpanel.add(datetF);

        prodID.setBackground(Color.decode("#ffffff"));
        JLabel jLabel2 = new JLabel();
        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabel2.setForeground(Color.decode("#dcecfc"));
        jLabel2.setText("ProductID");
        admintextfpanel.add(jLabel2);admintextfpanel.add(prodID);

       bcodetf.setBackground(Color.decode("#ffffff"));
       JButton bacode = new JButton("Generate Code");
       bacode.setBackground(Color.decode("#ffaa00"));
       bacode.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
       bacode.setForeground(Color.black);

       admintextfpanel.add(bacode);admintextfpanel.add(bcodetf);


       prodname.setBackground(Color.decode("#ffffff"));
        JLabel jLabel3 = new JLabel();
        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 20)); // NOI18N
        jLabel3.setForeground(Color.decode("#dcecfc"));
        jLabel3.setText("Product");
        admintextfpanel.add(jLabel3);admintextfpanel.add(prodname);


       prodprice.setBackground(Color.decode("#ffffff"));
       JLabel jLabel4 = new JLabel();
       jLabel4.setBackground(new java.awt.Color(51, 51, 51));
       jLabel4.setFont(new Font("Arial Black", 1, 20)); // NOI18N
       jLabel4.setForeground(Color.decode("#dcecfc"));
       jLabel4.setText("Price");
       admintextfpanel.add(jLabel4);admintextfpanel.add(prodprice);

     final  JPanel last = new JPanel();
       last.setLayout(new BorderLayout());
       last.add(admintextfpanel, BorderLayout.CENTER);
       last.add(backpa, BorderLayout.SOUTH);
       cost.add(jPanel2, BorderLayout.NORTH);
        cost.add(maintable, BorderLayout.CENTER);
        cost.add(last, BorderLayout.SOUTH);
       tpane = new JTabbedPane();


        //          RECEPTIONIST TABLE
       prodf = new JPanel();
       prodf.setLayout(new BorderLayout());
       DefaultTableModel protable = new pgsConnect().supermarketreception();
       tab = new JTable(protable);
       tab.setFont(new Font("Arial Black",1,12));
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
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
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
        prodbtn.setLayout(new GridLayout(6,2,8,8));
        prodbtn.setBackground(Color.decode("#202020"));
       JPanel pan = new JPanel();
       pan.setLayout(new FlowLayout());

       JLabel bar= new JLabel("ProductID");
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
        JLabel pprl = new JLabel("Price");pprl.setFont(new Font("Virtual DJ", 1, 18));
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
       JLabel ball  = new JLabel("Balance");
       ball.setFont(new Font("Virtual DJ", 1, 18));
       ball.setForeground(Color.decode("#ffffff"));
       prodbtn.add(ball);
       prodbtn.add(balance);

       JPanel lasp = new JPanel();
       lasp.setLayout(new FlowLayout(10,10,10));
       lasp.setBackground(Color.black.decode("#202020"));

       backmenu2 = new JButton("Back");
       prodbtn.add(backmenu2);

       // Search
       psearch.setBackground(Color.white);
       psearch.setFont(new java.awt.Font("Virtual DJ", 1, 18)); // NOI18N
       searchl.setFont(new Font("Virtual DJ", 1, 20));
       lasp.add(searchl);lasp.add(psearch);
       searchl.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
                String val = psearch.getText(); String prp = psearch.getText();
               String sql ="SELECT *  FROM Supermarket.Products WHERE ProductID = '"+val+"' OR Product = '"+prp+"'" ;
               try{
                   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
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



               }catch (SQLException es){
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
       JTextPane datee = new JTextPane();datee.setFont(new Font("Virtual DJ", 1, 18));datee.setBackground(Color.black);datee.setForeground(Color.white);
       datee.setText(new TimeandDateClass().date);
       lasp.add(time);lasp.add(datee);


       //ORDER PANEL
       ta.setText("\t Order View for Shoprite Supermarket \t\nShoprite Supermarket Order Receipt:");
       ta.setFont(new Font("BitStream Charter", 1, 15));
       JScrollPane ord = new JScrollPane(ta);
       orderpane.setLayout(new BorderLayout());
       orderpane.setBackground(Color.decode("#ffffff"));
       orderpane.add(ord, BorderLayout.CENTER);
       orderpane.add(removeorder, BorderLayout.SOUTH);


       //PRINTER PANEL
       JPanel panel = new JPanel();
       panel.setLayout(new GridLayout(2,2));
       panel.add(calc1);panel.add(calc);panel.add(order);panel.add(purchase);


       JButton print = new JButton("Print");
       print.setFont(new Font("Virtual DJ", 1, 20 ));
       print.setBackground(Color.decode("#3652a3"));


 JPanel las = new JPanel();
       las.setLayout(new BorderLayout());
       las.setBackground(Color.decode("#60a0df"));
       las.add(prodbtn, BorderLayout.WEST);
       las.add(panel, BorderLayout.CENTER);
       las.add(print, BorderLayout.EAST);
       las.add(backmenu2,BorderLayout.SOUTH);
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


               if (new pgscalculator().quantityPrice(total,quatf,prrr)) {
                   total = quatf * prrr;
                   String ok = Double.toString(total);
                   ppr.setText(ok);
                   amount.setText("0.0");
                   balance.setText("0.0");
                   return;
                   } else{
                       JOptionPane.showMessageDialog(null, "Amount Please");

           }}}

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
                                }catch (Exception js){
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
               try{
                   String product = pp.getText();String quantity = pq.getText();double price = Double.parseDouble(ppr.getText());

                      ta.append("\n\t"+product+":\t" +
                           " "+ quantity+"\t"+price+"\n" );

               }catch (Exception js){
                   JOptionPane.showMessageDialog(null, "Check Here");
                   js.printStackTrace();

               }

           }
       });
       removeorder.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               try{
                   ta.removeAll();
               }catch (Exception js){
                   js.printStackTrace();

               }
           }
       });
          purchase.setBackground(Color.decode("#99b286"));
       print.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
              try{
                  Boolean complete = ta.print();
                  if (complete){
JOptionPane.showMessageDialog(null, "Done Printing");
                  }else {
                      JOptionPane.showMessageDialog(null, "Printing...");

                  }
              }catch (Exception js){
                  js.printStackTrace();
              }


           }
       });
           pro.addActionListener(new

           ActionListener() {
               @Override
               public void actionPerformed (ActionEvent actionEvent){

                   String pass = JOptionPane.showInputDialog("Enter your PassWord ");

                   if (pass.equalsIgnoreCase("Admin")) {
                       tpane.add("Products", cost);
                       tpane.add("Staff table", staff);
                       tpane.setVisible(true);
                       welcome.setVisible(false);
                   } else {
                       JOptionPane.showMessageDialog(null, "Incorrect password");
                       return;
                   }

               }
           }

           );
           // Panel Menu

           pri.addActionListener(new

           ActionListener() {
               @Override
               public void actionPerformed (ActionEvent actionEvent){


                   String recepname = JOptionPane.showInputDialog("User Name: ", "Linda");
                   String RecepID = JOptionPane.showInputDialog("StaffID: ");

                   if (recepname.equalsIgnoreCase(recepname)) {
                       prodf.setVisible(true);
                       welcome.setVisible(false);

                   } else if (recepname.equalsIgnoreCase(null)) {
                       JOptionPane.showMessageDialog(null, " No name entered please enter a name");
                       return;
                   } else {
                       JOptionPane.showMessageDialog(null, " No name entered please enter a name");
                       return;
                   }
               }
           }

           );

           backmenu.addActionListener(new

           ActionListener() {
               @Override
               public void actionPerformed (ActionEvent actionEvent){
                   cost.setVisible(false);
                   welcome.setVisible(true);
                   jPanel2.setVisible(false);
                   admintextfpanel.setVisible(false);
                   last.setVisible(false);

               }
           }

           );
           backmenu2.addActionListener(new

           ActionListener() {
               @Override
               public void actionPerformed (ActionEvent actionEvent){
                   prodf.setVisible(false);
                   welcome.setVisible(true);
               }
           }

           );


       prodf.add(lasp, BorderLayout.NORTH);
       prodf.add(main,BorderLayout.CENTER );
       prodf.add(orderpane, BorderLayout.EAST);
       prodf.add(las, BorderLayout.SOUTH);
           fame.add(welcome);
           fame.getContentPane().

           add(cost);

           fame.getContentPane().

           add(prodf);

           fame.add(tpane);


       }


    }

