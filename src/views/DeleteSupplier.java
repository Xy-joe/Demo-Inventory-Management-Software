package views;

import presenters.StaffConnection;
import presenters.TextHint;
import presenters.supplierconnections;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by joebuntu on 4/2/17.
 */
public class DeleteSupplier extends JFrame implements ActionListener {
    JPanel mainp,header,body,button,searchpa,mainhead;
    JLabel headl,stsn, stafsna,staffna, stafid,stafposi,stafphon,staffgen,stafadres,date,pname,pqty,lsd,sd,cp,bc;
    JTextField searchtf,stsntf,stafsnatf,staffnatf, stafidtf,stafpositf,stafphontf,staffgentf,stafadrestf,datetf,pnametf,pqtytf,lsdtf,sdtf,cptf,bctf;
    JButton isert,refresh, back,search;

    public DeleteSupplier()  {
        searchpa = new JPanel(new GridLayout(1,2));
        searchpa.setBackground(Color.decode("#FFAB40"));
        searchpa.setAlignmentX(CENTER_ALIGNMENT);
        search = new JButton("Search for Supplier");
        search.setForeground(Color.WHITE);
        search.setBackground(Color.decode("#EF6c00"));
        search.addActionListener(this);
        searchpa.setSize(500,60);
        searchtf = new TextHint("Enter Supplier Code here ");
        searchtf.setBackground(Color.WHITE);
        searchtf.setFont(new Font("Liberation Serif", Font.BOLD,  18));
        searchtf.setForeground(Color.black);
        searchpa.add(search);
        searchpa.add(searchtf);

        header = new JPanel(new FlowLayout());
        header.setBackground(Color.decode("#F57C00"));
        ImageIcon img = new ImageIcon("resource/adsta.png");
        img.getImage();
        headl = new JLabel(img);
        headl.setText("Delete Supplier");
        headl.setFont(new Font("Liberation Serif", Font.PLAIN,  32));
        headl.setForeground(Color.WHITE);
        header.add(headl);
        mainhead = new JPanel(new BorderLayout());
        mainhead.setBackground(Color.decode("#E65100"));
        mainhead.add(header,BorderLayout.NORTH);
        mainhead.add(searchpa,BorderLayout.CENTER);
        body = new JPanel(new GridLayout(14,2));
        body.setBackground(Color.decode("#FFA726"));

        stsn = new JLabel();
        stsn.setForeground(Color.black);
        stsn.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stsn.setText("Serial no:");
        stsntf = new JTextField(25);
        stsntf.setBackground(Color.WHITE);
        stsntf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stsntf.setForeground(Color.black);
        body.add(stsn);
        body.add(stsntf);


        stafsna = new JLabel();
        stafsna.setForeground(Color.black);
        stafsna.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stafsna.setText("Code:");
        stafsnatf = new JTextField(25);
        stafsnatf.setBackground(Color.WHITE);
        stafsnatf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stafsnatf.setForeground(Color.black);
        body.add(stafsna);
        body.add(stafsnatf);

        staffna = new JLabel();
        staffna.setForeground(Color.black);
        staffna.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        staffna.setText("Company Name:");
        staffnatf = new JTextField(25);
        staffnatf.setBackground(Color.WHITE);
        staffnatf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        staffnatf.setForeground(Color.black);
        body.add(staffna);
        body.add(staffnatf);

        staffgen = new JLabel();
        staffgen.setForeground(Color.black);
        staffgen.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        staffgen.setText("Address:");
        staffgentf = new JTextField(25);
        staffgentf.setBackground(Color.WHITE);
        staffgentf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        staffgentf.setForeground(Color.black);
        body.add(staffgen);
        body.add(staffgentf);

        stafid = new JLabel();
        stafid.setForeground(Color.black);
        stafid.setFont(new Font("Liberation Serif", Font.PLAIN, 13));
        stafid.setText("City:");
        stafidtf = new JTextField(25);
        stafidtf.setBackground(Color.WHITE);
        stafidtf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stafidtf.setForeground(Color.black);
        body.add(stafid);
        body.add(stafidtf);

        stafposi = new JLabel();
        stafposi.setForeground(Color.black);
        stafposi.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stafposi.setText("Country:");
        stafpositf = new JTextField(25);
        stafpositf.setBackground(Color.WHITE);
        stafpositf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stafpositf.setForeground(Color.black);
        body.add(stafposi);
        body.add(stafpositf);

        stafphon = new JLabel();
        stafphon.setForeground(Color.black);
        stafphon.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stafphon.setText("Phone Number:");
        stafphontf = new JTextField(25);
        stafphontf.setBackground(Color.WHITE);
        stafphontf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stafphontf.setForeground(Color.black);
        body.add(stafphon);
        body.add( stafphontf);

        stafadres = new JLabel();
        stafadres.setForeground(Color.black);
        stafadres.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stafadres.setText("Email:");
        stafadrestf = new JTextField(25);
        stafadrestf.setBackground(Color.WHITE);
        stafadrestf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        stafadrestf.setForeground(Color.black);
        body.add(stafadres);
        body.add(stafadrestf);

        pname = new JLabel();
        pname.setForeground(Color.black);
        pname.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        pname.setText("Product Name:");
        pnametf = new JTextField(25);
        pnametf.setBackground(Color.WHITE);
        pnametf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        pnametf.setForeground(Color.black);
        body.add(pname);
        body.add(pnametf);

        pqty = new JLabel();
        pqty.setForeground(Color.black);
        pqty.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        pqty.setText("Product Quantity:");
        pqtytf = new JTextField(25);
        pqtytf.setBackground(Color.WHITE);
        pqtytf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        pqtytf.setForeground(Color.black);
        body.add(pqty);
        body.add(pqtytf);

        sd = new JLabel();
        sd.setForeground(Color.black);
        sd.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        sd.setText("Supply Date:");
        sdtf = new JTextField(25);
        sdtf.setBackground(Color.WHITE);
        sdtf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        sdtf.setForeground(Color.black);
        body.add(sd);
        body.add(sdtf);

        lsd = new JLabel();
        lsd.setForeground(Color.black);
        lsd.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        lsd.setText("Last Supply Date:");
        lsdtf = new JTextField(25);
        lsdtf.setBackground(Color.WHITE);
        lsdtf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        lsdtf.setForeground(Color.black);
        body.add(lsd);
        body.add(lsdtf);

        cp = new JLabel();
        cp.setForeground(Color.black);
        cp.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        cp.setText("Cash Paid:");
        cptf = new TextHint("0.0");
        cptf.setBackground(Color.WHITE);
        cptf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        cptf.setForeground(Color.black);
        body.add(cp);
        body.add(cptf);

        bc = new JLabel();
        bc.setForeground(Color.black);
        bc.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        bc.setText("Balance Cash:");
        bctf = new TextHint("0.0");
        bctf.setBackground(Color.WHITE);
        bctf.setFont(new Font("Liberation Serif", Font.PLAIN,  13));
        bctf.setForeground(Color.black);
        body.add(bc);
        body.add(bctf);

        button = new JPanel(new FlowLayout(FlowLayout.CENTER));
        button.setBackground(Color.decode("#EF6C00"));
        isert = new JButton("UPDATE");
        isert.setBounds(79,79,100,79);
        isert.setBackground(Color.decode("#E65100"));
        isert.setForeground(Color.WHITE);
        isert.addActionListener(this);
        refresh = new JButton("REFRESH");
        refresh.setBounds(79,79,100,79);
        refresh.setBackground(Color.decode("#E65100"));
        refresh.setForeground(Color.WHITE);
        refresh.addActionListener(this);
        back = new JButton("BACK");
        back.setBounds(79,79,100,79);
        back.setBackground(Color.decode("#E65100"));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        button.add(isert);button.add(refresh);button.add(back);
        mainp = new JPanel(new BorderLayout());
        mainp.add(mainhead, BorderLayout.NORTH);
        mainp.add(body, BorderLayout.CENTER);
        mainp.add(button, BorderLayout.SOUTH);
        add(mainp,BorderLayout.CENTER);

        setSize(500,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Delete Supplier Details");
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == back){
            dispose();
            setVisible(false);
        }
        else if (src == isert){
            int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this information completely \n NOTE: Once deleted, the details " +
                    "can't be recovered ","Confirm Deletion",JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                if (new supplierconnections().supplierDelete(stsntf.getText())) {
                    JOptionPane.showMessageDialog(null, "Deleted");

                    stsntf.setText("");
                    stafsnatf.setText("");
                    staffnatf.setText("");
                    stafidtf.setText("");
                    staffgentf.setText("");
                    stafpositf.setText("");
                    stafphontf.setText("");
                    stafadrestf.setText("");
                    pnametf.setText("");
                    pqtytf.setText("");
                    bctf.setText("");
                    cptf.setText("");
                    lsdtf.setText("");
                    sdtf.setText("");

                    retrieve();
                }
            }
        } else if (src == refresh){
            stsntf.setText("");
            stafsnatf.setText("");
            staffnatf.setText("");
            stafidtf.setText("");
            staffgentf.setText("");
            stafpositf.setText("");
            stafphontf.setText("");
            stafadrestf.setText("");
            pnametf.setText("");
            pqtytf.setText("");
            bctf.setText("");
            cptf.setText("");
            lsdtf.setText("");
            sdtf.setText("");
        }
        else if (src == search){
            String val = searchtf.getText();
            String sql = "SELECT *  FROM Supermarket.Supplier_Table WHERE Code = '" + val + "'";
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.first()){

                    String val1 = rs.getString("Serial_No");
                    String add0 = rs.getString("Code");
                    String add1=rs.getString("Company_Name");
                    String add5 =  rs.getString("Address");
                    String add2= rs.getString("City");
                    String add3 = rs.getString("Country");
                    String add4 = rs.getString("Phone_No");
                    String val2 = rs.getString("Email");
                    String val3 = rs.getString("Product_Name");
                    String val4 = rs.getString("Product_Quantity");
                    String val5 = rs.getString("Supply_Date");
                    String val6 = rs.getString("Last_Supplied_Date");
                    String val7 = rs.getString("Cash_Paid");
                    String val8 = rs.getString("Balance_Cash");

                    stsntf.setText(val1);
                    stafsnatf.setText(add0);
                    staffnatf.setText(add1);
                    stafidtf.setText(add5);
                    staffgentf.setText(add2);
                    stafpositf.setText(add3);
                    stafphontf.setText(add4);
                    stafadrestf.setText(val2);
                    pnametf.setText(val3);
                    pqtytf.setText(val4);
                    bctf.setText(val8);
                    cptf.setText(val7);
                    lsdtf.setText(val6);
                    sdtf.setText(val5);

                }else {
                    JOptionPane.showMessageDialog(null, "Search Connection Problem");
                }

            } catch (SQLException es) {
                JOptionPane.showMessageDialog(null, "The code is either incorrect or \n does not exist in our database ");
                es.printStackTrace();

            }
        }
    }
    public void retrieve(){
        DefaultTableModel dt  = new supplierconnections().refreshSupplier();
        new SupplierClass().suppliertable.setModel(dt);
    }
}
