package views;

import presenters.ImagePanel;
import presenters.TextHint;
import presenters.productconnections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.sql.*;

public class Supermarket implements ActionListener {
    JMenuBar menuBar;
    JMenuItem  adp, addstaff, jmiClose, updatestaff, delstaf, htry
            ,addcus,delcus,upcus,settings,contact,help,adsup,delsup,upsup,supid,supna,supt, rpt,deptid,deptname, admintextfpaneli, exit;
    JMenu productmenu, staffmenu, customermenu, suppliermenu, purchasemenu,exitmenu, findd,finsup;
   // JTabbedPane tpane;
  
    JFrame mainadmin,cashier, staff;

  JPanel welcome, jPanel2,admintextfpanel,last, backpa,cost, mainp2;

  JTable costomertable;
   private ImageIcon img;
ImagePanel loader;
    JFrame newproduct;
    JButton pro,pri,backmenu, backmenu2, Searchbtn, retrievebtn;

    public static void main(String[] joe) {
 EventQueue.invokeLater(new Runnable() {
     @Override
     public void run() {
        try{
           Supermarket window = new Supermarket();
           window.mainadmin.setVisible(true);
        }
        catch (Exception evt){
           evt.printStackTrace();
        }
     }
  });
  new Supermarket();
    }



    private void retrieve(){
        DefaultTableModel dt  = new productconnections().supermaketDataretrival();
        costomertable.setModel(dt);
    }
    JTextField datetF,prodID, prodname, prodprice, amount, balance, searchtf, pp, stock, ppr,bcodetf, pq, sntf, bartf;
   public Supermarket() {
       staff = new Staffclass();
       newproduct = new NewProduct();
       cashier = new CashierClass();
      img = new ImageIcon("resource/pgs.jpg");
      img.getImage();
      mainadmin = new JFrame();
       mainadmin.setSize(1500,1200);
     //   mainadmin.setBounds(400, 400, 1100, 700);
     mainadmin.setLocationRelativeTo(null);
       mainadmin.setMinimumSize(new Dimension(1100,700));
      mainadmin.setTitle("PEGASUS Supermarket IMS");
       mainadmin.setBackground(Color.decode("#E3F2FD"));
        mainadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mainadmin.setLayout(new CardLayout(0, 0));
       cost = new JPanel();

       cost.setLayout(new BorderLayout());
       cost.setVisible(false);


       // WELCOME SCREEN
          welcome = new JPanel();
          welcome.setLayout(new BorderLayout());
          welcome.setBackground(Color.decode("#CFD8DC"));
          welcome.setVisible(true);
          JPanel menubtn = new JPanel();
          menubtn.setLayout(new FlowLayout());

       JLabel sign = new JLabel();
       sign.setText("Sign in as an ");
       sign.setFont(new Font("Liberation Serif", Font.BOLD,  30));
       sign.setForeground(Color.BLUE);
       JLabel or = new JLabel();
       or.setText(" or ");
       or.setForeground(Color.BLUE);
       or.setFont(new Font("Liberation Serif", Font.BOLD,  30));
       menubtn.setBackground(Color.decode("#c3cad1"));
       pro = new JButton("Administrator");
       pro.setBounds(79,100,100,79);
        pro.addActionListener(this);
       pro.setFont(new Font("Serif",Font.BOLD,20));
       pro.setBackground(Color.decode("#1976D2"));//import java.awt.Color;
      pro.setForeground(Color.WHITE);
       pro.setFocusPainted(false);
       pro.setBorderPainted(false);

       pri = new JButton("Cashier");
       JLabel supname = new JLabel("PEGASUS SUPERMARKER IMS",JLabel.CENTER);
       JLabel comme = new JLabel("licenced to shoprite Supermarket ",JLabel.RIGHT);
       comme.setFont(new Font("Virtual DJ", Font.ITALIC, 18));
       comme.setForeground(Color.BLACK);
       supname.setFont(new Font("Liberation Serif", Font.BOLD,  50));
       supname.setForeground(Color.decode("#ffffff"));
      // supname.setBackground(Color.decode("#ffffff"));


      pri.setBounds(79,79,100,79);
       pri.setFont(new Font("Serif",Font.BOLD,20));
       pri.setBackground(Color.decode("#1976D2"));//import java.awt.Color;
       pri.setForeground(Color.WHITE);
       pri.setFocusPainted(false);
       pri.setBorderPainted(false);
       pri.addActionListener(this);
       menubtn.add(sign);
       menubtn.add(pro);
       menubtn.add(or);
      menubtn.add(pri);
       loader = new ImagePanel(new ImageIcon("resource/pg1.jpg").getImage());
       loader.setLayout(new BorderLayout());
       loader.add(menubtn, BorderLayout.SOUTH);
       welcome.add(supname, BorderLayout.NORTH);
      welcome.add(loader,BorderLayout.CENTER);
       welcome.add(comme, BorderLayout.SOUTH);



       stock = new JTextField(20); stock.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));
       sntf = new JTextField(20); sntf.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));
       prodID = new JTextField(20); prodID.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));
       prodname = new JTextField(20); prodname.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));
       prodprice = new JTextField(20); prodprice.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 15));
       pp = new JTextField(20); pp.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 15));
       ppr = new JTextField(20); ppr.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));
       amount = new JTextField(20); amount.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));
       balance = new JTextField(20); balance.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));
       datetF = new JTextField(20); datetF.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 15));
       pq = new JTextField(20); pq.setFont(new Font("Serif", Font.BOLD+Font.ITALIC, 15));
       bcodetf = new JTextField(20);bcodetf.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));
       bartf = new JTextField(20);bartf.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));

         //ADMINISTRATOR  PRODUCTS TABLE
       menuBar = new JMenuBar();
       menuBar.setBackground(Color.decode("#90CAF9"));
       menuBar.setBorderPainted(true);
// Add menu "Operation" to menu bar
       productmenu = new JMenu("Product");
       productmenu.setPopupMenuVisible(true);
       productmenu.setMnemonic('P');
       productmenu.setFont(new Font("Virtual DJ", 1, 20));
       productmenu.setForeground(Color.BLACK);
       productmenu.addActionListener(this);
       menuBar.add(productmenu);
// Add menu "Staff" to menu bar
       staffmenu = new JMenu("Staff");
       staffmenu.setMnemonic('S');
       staffmenu.setFont(new Font("Virtual DJ", 1, 20));
       staffmenu.setForeground(Color.BLACK);
       menuBar.add(staffmenu);

       // Add menu "Supplier" to menu bar

       suppliermenu = new JMenu("Supplier");
       suppliermenu.setMnemonic('P');
      suppliermenu.setFont(new Font("Virtual DJ", 1, 20));
       suppliermenu.setForeground(Color.BLACK);
       menuBar.add(suppliermenu);
       // Add menu "Purchase" to menu bar

       purchasemenu = new JMenu("Purchase");
       purchasemenu.setMnemonic('H');
       purchasemenu.setFont(new Font("Virtual DJ", 1, 20));
       purchasemenu.setForeground(Color.BLACK);
       menuBar.add(purchasemenu);
       // Add menu "Operation" to menu bar

       exitmenu = new JMenu("Others");
       exitmenu.setMnemonic('E');
       exitmenu.setFont(new Font("Virtual DJ", 1, 20));
      exitmenu.setForeground(Color.BLACK);
       menuBar.add(exitmenu);


       // Add menu items with mnemonics to menu "Staff"

       staffmenu.add(addstaff = new JMenuItem("Add"));
       addstaff.addActionListener(this);
       staffmenu.add(updatestaff = new JMenuItem("Update"));
       updatestaff.addActionListener(this);
       staffmenu.add(delstaf = new JMenuItem("Remove"));
       delstaf.addActionListener(this);
       staffmenu.add(jmiClose = new JMenuItem("Show table"));
       staffmenu.addSeparator();
       jmiClose.addActionListener(this);


       // Add menu items with mnemonics to menu "Supplier"

       suppliermenu.add(adsup = new JMenuItem("Add", 'I'));
       adsup.addActionListener(this);
       suppliermenu.add(upsup = new JMenuItem("Update", 'U'));
       upsup.addActionListener(this);
       suppliermenu.add(delsup = new JMenuItem("Remove",'R'));
       delsup.addActionListener(this);
       suppliermenu.add(supt = new JMenuItem("Show table"));
       supt.addActionListener(this);


       // Add menu items with mnemonics to menu "Purchase"
       purchasemenu.add(htry = new JMenuItem("Purchase History", 'H'));
       htry.addActionListener(this);
       purchasemenu.add(rpt = new JMenuItem("New Dept", 'T'));
       rpt.addActionListener(this);
       purchasemenu.add(admintextfpaneli = new JMenuItem("Dept History", 'L'));
       admintextfpaneli.addActionListener(this);
       purchasemenu.add(findd = new JMenu("View dept details by"));


       // Add menu items with mnemonics to menu "Exit"
       exitmenu.add(help = new JMenuItem("Help",'P'));
       exitmenu.add(settings = new JMenuItem("Settings", 'S'));
       exitmenu.add(exit = new JMenuItem("Exit", 'X'));

// Set keyboard accelerators
       upsup.setAccelerator(

               KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));

       adsup.setAccelerator(

               KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

       delsup.setAccelerator(

               KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
       exit.setAccelerator(

               KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
       rpt.setAccelerator(

               KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
       admintextfpaneli.setAccelerator(

               KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
       htry.setAccelerator(

               KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
       help.setAccelerator(

               KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
       settings.setAccelerator(

               KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));


       final  DefaultTableModel costomermodel = new productconnections().supermarketadminconnect();
        costomertable = new JTable(costomermodel);
       costomertable.setMinimumSize(new Dimension(800,700));
       costomertable.setBackground(Color.decode("#BBDEFB"));
       costomertable.setGridColor(Color.decode("#1565C0"));
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
                       String add6 = rs.getString("Stock");

                       sntf.setText(add0);
                       datetF.setText(add1);
                       prodID.setText(add2);
                       bcodetf.setText(add3);
                       prodname.setText(add4);
                       prodprice.setText(add5);
                       stock.setText(add6);


                   }
               } catch (SQLException esp) {
                   JOptionPane.showMessageDialog(null, "Something Went wrong");
esp.printStackTrace();
               }
           }
       });

       JScrollPane maintable = new JScrollPane(costomertable);
       maintable.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanel2 = new JPanel();
        jPanel2.setBackground(Color.decode("#BBDEFB"));
       jPanel2.setBorder(BorderFactory.createTitledBorder("Options:"));
        jPanel2.setLayout(new GridLayout(3,2,15,10));
        JButton addrow2btn = new JButton();
        addrow2btn.setBackground(Color.decode("#1565C0"));
        addrow2btn.setFont(new Font("Virtual DJ", Font.ITALIC, 20));
       addrow2btn.setBounds(50,50,50,50);
       addrow2btn.setForeground(Color.WHITE);
        addrow2btn.setText("Add New Product");
        addrow2btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (checkfornull()) {
                    if (new productconnections().supermarketadd(datetF.getText(), prodID.getText(), bcodetf.getText(), prodname.getText(), prodprice.getText(), stock.getText())) {
                        JOptionPane.showMessageDialog(null, "Successfully Added");

                        sntf.setText("");
                        datetF.setText("");
                        prodID.setText("");
                        bcodetf.setText("");
                        prodprice.setText("");
                        prodname.setText("");
                        stock.setText("");

                        retrieve();
                    }

                }
            }
        });
        jPanel2.add(addrow2btn);
        JButton save2btn = new JButton();
        save2btn.setBackground(Color.decode("#1565C0"));
       save2btn.setBounds(50,50,50,50);
        save2btn.setFont(new Font("Virtual DJ", Font.ITALIC, 20));
       save2btn.setForeground(Color.WHITE);
        save2btn.setText("Update");
        save2btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (checkfornull()) {
                    if (new productconnections().supermarketUpdate(sntf.getText(), datetF.getText(), prodID.getText(), bcodetf.getText(), prodname.getText(), prodprice.getText(), stock.getText())) {
                        JOptionPane.showMessageDialog(null, "Successfully Updated");


                        sntf.setText("");
                        datetF.setText("");
                        prodID.setText("");
                        bcodetf.setText("");
                        prodname.setText("");
                        prodprice.setText("");
                        stock.setText("");

                        retrieve();

                    } else {
                        JOptionPane.showMessageDialog(null, "Not Updated");
                    }
                }


        }
        });
        jPanel2.add(save2btn);
       JButton delete2btn = new JButton();
       delete2btn.setBackground(Color.decode("#1565C0"));
       delete2btn.setFont(new Font("Virtual DJ", Font.ITALIC, 20));
      delete2btn.setBounds(50,50,50,50);
       // delete2btn.setBounds(79,100,100,79);
       delete2btn.setForeground(Color.WHITE);
       delete2btn.setText("Delete Product");
       delete2btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               if (checkfornull()){
               if (sntf.getText().equals("")){

               }
               String[] op = {"Yes", "No"};
               int ans = JOptionPane.showOptionDialog(null, "Sure to delete", "Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, op, op[1]);

               if (ans == 0) {

                   int index = costomertable.getSelectedRow();
                   String date = costomertable.getValueAt(index, 0).toString();

                   if (new productconnections().supermarketdelete(date))
                       JOptionPane.showMessageDialog(null, "Deleted Successfully ");

                   sntf.setText("");
                   datetF.setText("");
                   prodID.setText("");
                   bcodetf.setText("");
                   prodname.setText("");
                   prodprice.setText("");
                   stock.setText("");


                   retrieve();
               }else {
                   JOptionPane.showMessageDialog(null, "Not Deleted");
               }
               }
           }

       });
       jPanel2.add(delete2btn);
       retrievebtn = new JButton();
       retrievebtn.setBackground(Color.decode("#1565C0"));
       retrievebtn.setFont(new Font("Virtual DJ", Font.ITALIC, 20));
       retrievebtn.setForeground(Color.WHITE);
       retrievebtn.setBounds(50,50,50,50);
       retrievebtn.setText("Refresh");
       retrievebtn.addActionListener(this);
       jPanel2.add(retrievebtn);
        searchtf = new TextHint("Type Product Barcode Here");
        searchtf.setBackground(Color.white);
       searchtf.setBounds(50,50,50,50);
        searchtf.setFont(new Font("Virtual DJ", 1, 17)); // NOI18N
         Searchbtn = new JButton("Find Product");
       Searchbtn.setBounds(50,50,50,50);
       Searchbtn.setBackground(Color.decode("#1565C0"));
       Searchbtn.setFont(new Font("Virtual DJ", Font.ITALIC, 20));
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
                       String add6 = rs.getString("Stock");

                       sntf.setText(add0);
                       datetF.setText(add1);
                       prodID.setText(add2);
                       bcodetf.setText(add3);
                       prodname.setText(add4);
                       prodprice.setText(add5);
                       stock.setText(add6);


                   }



               }catch (SQLException es){
                   JOptionPane.showMessageDialog(null, "Search Connection Problem");
                   es.printStackTrace();

           }
           }
       });

       admintextfpanel = new JPanel();
       admintextfpanel.setLayout(new GridLayout(7,2,5,15));
       admintextfpanel.setBackground(Color.decode("#BBDEFB"));
       admintextfpanel.setBorder(BorderFactory.createLineBorder(Color.black));

// Serial no
       sntf.setBackground(Color.decode("#ffffff"));
       JLabel jLabel0 = new JLabel();
       jLabel0.setBackground(Color.BLACK);
       jLabel0.setFont(new Font("Serif", Font.BOLD, 20)); // NOI18N
       jLabel0.setForeground(Color.BLACK);
       jLabel0.setText("S/N");
       admintextfpanel.add(jLabel0);
       admintextfpanel.add(sntf);
//Date
       datetF.setBackground(Color.decode("#ffffff"));
       datetF.setBounds(5,5,15,10);
       JLabel jLabel1 = new JLabel();
       jLabel1.setFont(new Font("Serif", Font.BOLD, 20)); // NOI18N
       jLabel1.setForeground(Color.BLACK);
       jLabel1.setText("Date");
       admintextfpanel.add(jLabel1);
       admintextfpanel.add(datetF);
//Product ID
       prodID.setBackground(Color.decode("#ffffff"));
       JLabel jLabel2 = new JLabel();
       jLabel2.setFont(new Font("Serif", Font.BOLD, 20)); // NOI18N
       jLabel2.setForeground(Color.BLACK);
       jLabel2.setText("ProductID");
       admintextfpanel.add(jLabel2);
       admintextfpanel.add(prodID);
// Barcode
       bcodetf.setBackground(Color.decode("#ffffff"));
       JButton bacode = new JButton("Generate Code");
       bacode.setBackground(Color.decode("#1565C0"));
       bacode.setFont(new Font("Serif", Font.BOLD, 20)); // NOI18N
       bacode.setForeground(Color.WHITE);
       bacode.setFocusPainted(false);
       bacode.setBorderPainted(false);
       admintextfpanel.add(bacode);
       admintextfpanel.add(bcodetf);

// Product Name
       prodname.setBackground(Color.decode("#ffffff"));
       JLabel jLabel3 = new JLabel();
       jLabel3.setFont(new Font("Serif", Font.BOLD, 20)); // NOI18N
       jLabel3.setForeground(Color.BLACK);
       jLabel3.setText("Product");
       admintextfpanel.add(jLabel3);
       admintextfpanel.add(prodname);
// Price

       prodprice.setBackground(Color.decode("#ffffff"));
       JLabel jLabel4 = new JLabel();
       jLabel4.setFont(new Font("Serif", Font.BOLD, 20)); // NOI18N
       jLabel4.setForeground(Color.BLACK);
       jLabel4.setText("Price");
       admintextfpanel.add(jLabel4);
       admintextfpanel.add(prodprice);
// Stock
       stock.setBackground(Color.decode("#ffffff"));
       JLabel jLabel5 = new JLabel();
       jLabel5.setFont(new Font("Serif", Font.BOLD, 20)); // NOI18N
       jLabel5.setForeground(Color.BLACK);
       jLabel5.setText("Stock");
       admintextfpanel.add(jLabel5);
       admintextfpanel.add(stock);

      backpa = new JPanel();
       backpa.setBackground(Color.decode("#64B5F6"));
      backmenu = new JButton("Back");
       backmenu.setBackground(Color.decode("#1565C0"));
       backmenu.setFont(new Font("Serif", Font.BOLD, 20));
       backmenu.setForeground(Color.WHITE);
       backmenu.addActionListener(this);
      backpa.add(backmenu);

       last = new JPanel();
       last.setLayout(new BorderLayout(0,10));
       last.setBackground(Color.decode("#BBDEFB"));
       last.add(jPanel2,BorderLayout.NORTH);
       last.add(admintextfpanel, BorderLayout.SOUTH);
       cost.add(menuBar, BorderLayout.NORTH);
        cost.add(maintable, BorderLayout.CENTER);
        cost.add(last, BorderLayout.EAST);
        cost.add(backpa, BorderLayout.SOUTH);


       mainadmin.getContentPane().add(welcome);
      mainadmin.getContentPane().add(cost);






       }

// Handling Action events listeners
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == pro){
            JPasswordField pwd = new JPasswordField(15);

            int option =   JOptionPane.showConfirmDialog(null, pwd,"Enter administrator Password",JOptionPane.OK_CANCEL_OPTION);

            if (option == 0 ) {
                char[] pass = pwd.getPassword();
                String passString = new String(pass);
                if (passString.equalsIgnoreCase("Admin")){
                    cost.setVisible(true);
                    welcome.setVisible(false);

                } else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect password");
                }
            }
        }
        else if (src == pri){

            String recepname = JOptionPane.showInputDialog(null,"User Name: ", "Username");
            String RecepID = JOptionPane.showInputDialog("StaffID: ");

            if (recepname.equalsIgnoreCase(recepname)) {
                cashier.setVisible(true);
                welcome.setVisible(false);

            } else if (recepname.equalsIgnoreCase(null)) {
                JOptionPane.showMessageDialog(null, " No name entered please enter a name");
            } else {
                JOptionPane.showMessageDialog(null, " No name entered please enter a name");
            }
        }
        else if (src == backmenu) {
            cost.setVisible(false);
            welcome.setVisible(true);
        }
        else if (src == backmenu2){
            cashier.setVisible(false);
            welcome.setVisible(true);
        }
        else if (src == jmiClose){
            staff.setVisible(true);
        }else if (src == adp){
            newproduct.setVisible(true);
            welcome.setVisible(true);

        }
        else if (src == retrievebtn){
            sntf.setText("");
            prodID.setText("");
            bcodetf.setText("");
            prodname.setText("");
            prodprice.setText("");
            datetF.setText("");
            stock.setText("");
        }else if (src == productmenu){
            cost.setVisible(true);
        }else if (src == addstaff) {
            new AddStaff().setVisible(true);
        }else if (src == updatestaff){
            new UpdateStaff().setVisible(true);
        }
        else if (src == delstaf){
            new DeleteStaff().setVisible(true);
        }else if (src == supt){
            new SupplierClass().setVisible(true);
        }else if (src == adsup){
            new AddSupplier().setVisible(true);
        }else if (src == upsup){
            new UpdateSupplier().setVisible(true);
        }else if (src == delsup){
            new DeleteSupplier().setVisible(true);
        }else if(src == htry){
            new HistoryClass().setVisible(true);
        }else  if (src == admintextfpaneli){
            new DeptClass().setVisible(true);
        }else if (src == rpt){
            new NewDeptClass().setVisible(true);
        }
    }
    public boolean checkfornull(){
        if (sntf.getText().equals("")){
JOptionPane.showMessageDialog(null,"Empty Fields");
            return false;
        }
        if (prodname.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Empty Fields");
            return false;
        }
        if (prodprice.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Empty Fields");
            return false;
        }
        if (bcodetf.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Empty Fields");
            return false;
        }
        if (datetF.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Empty Fields");
            return false;
        }
        if (stock.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Empty Fields");
            return false;
        }
        if (prodID.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Empty Fields");
            return false;
        }
        return true;
    }
}

