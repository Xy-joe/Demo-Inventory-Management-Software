package views;

import presenters.StaffConnection;
import presenters.productconnections;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by joebuntu on 4/1/17.
 */
public class AddStaff extends JFrame implements ActionListener {
JPanel mainp,header,body,button;
JLabel headl,stsn, stafsna,staffna, stafid,stafposi,stafphon,staffgen,stafadres,date;
    JTextField stsntf,stafsnatf,staffnatf, stafidtf,stafpositf,stafphontf,staffgentf,stafadrestf,datetf;
    JButton isert,refresh, back;
    public AddStaff()  {
        header = new JPanel(new FlowLayout());
        header.setBackground(Color.decode("#009688"));
        ImageIcon img = new ImageIcon("resource/adsta.png");
        img.getImage();
        headl = new JLabel(img);
        headl.setText("Add Staff");
        headl.setFont(new Font("Liberation Serif", Font.PLAIN,  32));
        headl.setForeground(Color.WHITE);
        header.add(headl);
        body = new JPanel(new GridLayout(9,2));
        body.setBackground(Color.decode("#B2DFDB"));

        stsn = new JLabel();
        stsn.setForeground(Color.black);
        stsn.setFont(new Font("Liberation Serif", Font.PLAIN,  20));
        stsn.setText("Serial no:");
        stsntf = new JTextField(25);
        stsntf.setBackground(Color.WHITE);
        stsntf.setFont(new Font("Liberation Serif", Font.PLAIN,  18));
        stsntf.setForeground(Color.black);
        body.add(stsn);
        body.add(stsntf);


        stafsna = new JLabel();
        stafsna.setForeground(Color.black);
        stafsna.setFont(new Font("Liberation Serif", Font.PLAIN,  20));
        stafsna.setText("Surname:");
        stafsnatf = new JTextField(25);
        stafsnatf.setBackground(Color.WHITE);
        stafsnatf.setFont(new Font("Liberation Serif", Font.PLAIN,  18));
        stafsnatf.setForeground(Color.black);
        body.add(stafsna);
        body.add(stafsnatf);

        staffna = new JLabel();
        staffna.setForeground(Color.black);
        staffna.setFont(new Font("Liberation Serif", Font.PLAIN,  20));
        staffna.setText("First name:");
        staffnatf = new JTextField(25);
        staffnatf.setBackground(Color.WHITE);
        staffnatf.setFont(new Font("Liberation Serif", Font.PLAIN,  18));
        staffnatf.setForeground(Color.black);
        body.add(staffna);
        body.add(staffnatf);

        staffgen = new JLabel();
        staffgen.setForeground(Color.black);
        staffgen.setFont(new Font("Liberation Serif", Font.PLAIN,  20));
        staffgen.setText("Gender:");
        staffgentf = new JTextField(25);
        staffgentf.setBackground(Color.WHITE);
        staffgentf.setFont(new Font("Liberation Serif", Font.PLAIN,  18));
        staffgentf.setForeground(Color.black);
        body.add(staffgen);
        body.add(staffgentf);

        stafid = new JLabel();
        stafid.setForeground(Color.black);
        stafid.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
        stafid.setText("Staff ID:");
        stafidtf = new JTextField(25);
        stafidtf.setBackground(Color.WHITE);
        stafidtf.setFont(new Font("Liberation Serif", Font.PLAIN,  18));
        stafidtf.setForeground(Color.black);
        body.add(stafid);
        body.add(stafidtf);

        stafposi = new JLabel();
        stafposi.setForeground(Color.black);
        stafposi.setFont(new Font("Liberation Serif", Font.PLAIN,  20));
        stafposi.setText("Office:");
        stafpositf = new JTextField(25);
        stafpositf.setBackground(Color.WHITE);
        stafpositf.setFont(new Font("Liberation Serif", Font.PLAIN,  18));
        stafpositf.setForeground(Color.black);
        body.add(stafposi);
        body.add(stafpositf);

        stafphon = new JLabel();
        stafphon.setForeground(Color.black);
        stafphon.setFont(new Font("Liberation Serif", Font.PLAIN,  20));
        stafphon.setText("Phone:");
        stafphontf = new JTextField(25);
        stafphontf.setBackground(Color.WHITE);
        stafphontf.setFont(new Font("Liberation Serif", Font.PLAIN,  18));
        stafphontf.setForeground(Color.black);
        body.add(stafphon);
        body.add( stafphontf);

        stafadres = new JLabel();
        stafadres.setForeground(Color.black);
        stafadres.setFont(new Font("Liberation Serif", Font.PLAIN,  20));
        stafadres.setText("Address:");
        stafadrestf = new JTextField(25);
        stafadrestf.setBackground(Color.WHITE);
        stafadrestf.setFont(new Font("Liberation Serif", Font.PLAIN,  18));
        stafadrestf.setForeground(Color.black);
        body.add(stafadres);
        body.add(stafadrestf);

        date = new JLabel();
        date.setForeground(Color.black);
        date.setFont(new Font("Liberation Serif", Font.PLAIN,  20));
        date.setText("Date of Appointment:");
        datetf = new JTextField(25);
        datetf.setBackground(Color.WHITE);
        datetf.setFont(new Font("Liberation Serif", Font.PLAIN,  18));
        datetf.setForeground(Color.black);
        body.add(date);
        body.add(datetf);

        button = new JPanel(new FlowLayout(FlowLayout.CENTER));
        button.setBackground(Color.decode("#004d40"));
        isert = new JButton("Insert");
        isert.setBackground(Color.decode("#00796b"));
        isert.setForeground(Color.WHITE);
        isert.addActionListener(this);
        refresh = new JButton("Refresh");
        refresh.setBackground(Color.decode("#00796B"));
        refresh.setForeground(Color.WHITE);
        refresh.addActionListener(this);
        back = new JButton("Back");
        back.setBackground(Color.decode("#00796B"));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        button.add(isert);button.add(refresh);button.add(back);
        mainp = new JPanel(new BorderLayout());
        mainp.add(header, BorderLayout.NORTH);
        mainp.add(body, BorderLayout.CENTER);
        mainp.add(button, BorderLayout.SOUTH);
        add(mainp,BorderLayout.CENTER);

        setSize(400,410);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Add New Staff");
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
            if (new StaffConnection().staffadd(stsntf.getText(),stafsnatf.getText(), staffnatf.getText(), stafidtf.getText(),
                    staffgentf.getText(), stafpositf.getText(), stafphontf.getText(), stafadrestf.getText(),datetf.getText())) {
                JOptionPane.showMessageDialog(null, "Successfully Added");
                stsntf.setText("");
                stafsnatf.setText("");
                staffnatf.setText("");
                stafidtf.setText("");
                staffgentf.setText("");
                stafpositf.setText("");
                stafphontf.setText("");
                stafadrestf.setText("");
                datetf.setText("");

                retrieve();
            }
        }
        else if (src == refresh){
            stsntf.setText("");
            stafsnatf.setText("");
            staffgentf.setText("");
            stafidtf.setText("");
            staffgentf.setText("");
            stafpositf.setText("");
            stafphontf.setText("");
            stafadrestf.setText("");
            datetf.setText("");
        }
    }
    private void retrieve(){
         new Staffclass().retrieve();
    }
}
