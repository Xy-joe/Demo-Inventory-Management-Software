package views;

import presenters.SQLDate;
import presenters.StaffConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import presenters.TextHint;
import presenters.supplierconnections;
import java.awt.event.ActionListener;

/**
 * Created by joebuntu on 4/1/17.
 */
public class AddSupplier extends JFrame implements ActionListener {
JPanel mainp,header,body,button;
    SQLDate date1;
JLabel headl,stsn, stafsna,staffna, stafid,stafposi,stafphon,staffgen,stafadres,date,pname,pqty,lsd,sd,cp,bc;
    JTextField stsntf,stafsnatf,staffnatf, stafidtf,stafpositf,stafphontf,staffgentf,stafadrestf,pnametf,pqtytf,lsdtf,sdtf,cptf,bctf;
    JButton isert,refresh, back;
    public AddSupplier()  {
        date1 = new SQLDate();
        header = new JPanel(new FlowLayout());
        header.setBackground(Color.decode("#64B5F6"));
        ImageIcon img = new ImageIcon("resource/adsta.png");
        img.getImage();
        headl = new JLabel(img);
        headl.setText("Add Supplier");
        headl.setFont(new Font("Liberation Serif", Font.PLAIN,  25));
        headl.setForeground(Color.WHITE);
        header.add(headl);
        body = new JPanel(new GridLayout(13,2));
        body.setBackground(Color.decode("#BBDEFB"));


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
        body.add(date1);

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
        button.setBackground(Color.decode("#64B5F6"));
        isert = new JButton("ADD");
        isert.setBounds(79,79,100,79);
        isert.setBackground(Color.decode("#1565C0"));
        isert.setForeground(Color.WHITE);
        isert.addActionListener(this);
        refresh = new JButton("REFRESH");
        refresh.setBounds(79,79,100,79);
        refresh.setBackground(Color.decode("#1565C0"));
        refresh.setForeground(Color.WHITE);
        refresh.addActionListener(this);
        back = new JButton("BACK");
        back.setBounds(79,79,100,79);
        back.setBackground(Color.decode("#1565C0"));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        button.add(isert);button.add(refresh);button.add(back);
        mainp = new JPanel(new BorderLayout());
        mainp.add(header, BorderLayout.NORTH);
        mainp.add(body, BorderLayout.CENTER);
        mainp.add(button, BorderLayout.SOUTH);
        add(mainp,BorderLayout.CENTER);

        setSize(500,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Add New Supplier");
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
            if (new supplierconnections().addsupplier(stafsnatf.getText(), staffnatf.getText(), stafidtf.getText(),
                    staffgentf.getText(), stafpositf.getText(), stafphontf.getText(), stafadrestf.getText(), pnametf.getText(), pqtytf.getText(), lsdtf.getText(), date1.datePicker.getJFormattedTextField().getText(), cptf.getText(), bctf.getText())) {
                JOptionPane.showMessageDialog(null, "Successfully Added");

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
        else if (src == refresh){
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
    }
    private void retrieve(){
         new Staffclass().retrieve();
    }
}
