import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class administratorSection extends JPanel {
    JMenuBar menuBar;
    JPanel p1,p2;
    // Text fields for Number 1, Number 2, and Result
    private JTextField jtfNum1, jtfNum2, jtfResult;
    // Buttons "Add", "Subtract", "Multiply" and "Divide"
    private JButton jbtAdd, jbtSub, jbtMul, jbtDiv;
    // Menu items "Add", "Subtract", "Multiply", "Divide" and "Close"
   JMenuItem  jmeBar, jmeID, addstaff, jmiClose, updatestaff, delstaf, stafid,stafname
            ,addcus,delcus,upcus,cusna,cusid,cust,adsup,delsup,upsup,supid,supna,supt, rpt,bill, exit;
    JMenu productmenu, staffmenu, customermenu, suppliermenu, purchasemenu,exitmenu,findpr, findstaf,finsup,ficu;

    public administratorSection(){

        menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
// Add menu "Operation" to menu bar
        productmenu = new JMenu("Product");
        productmenu.setPopupMenuVisible(true);
        productmenu.setMnemonic('P');
        menuBar.add(productmenu);
// Add menu "Staff" to menu bar
staffmenu = new JMenu("Staff");
        staffmenu.setMnemonic('S');
        staffmenu.setBackground(Color.blue);
        menuBar.add(staffmenu);
        // Add menu "Customer" to menu bar

        customermenu = new JMenu("Costomer");
        customermenu.setMnemonic('C');
        menuBar.add(customermenu);
        // Add menu "Supplier" to menu bar

        suppliermenu = new JMenu("Supplier");
        suppliermenu.setMnemonic('P');
        menuBar.add(suppliermenu);
        // Add menu "Purchase" to menu bar

        purchasemenu = new JMenu("Purchase");
        purchasemenu.setMnemonic('H');
        menuBar.add(purchasemenu);
        // Add menu "Operation" to menu bar

        exitmenu = new JMenu("Exit");
        exitmenu.setMnemonic('E');
        menuBar.add(exitmenu);

     // Add menu items with mnemonics to menu "Product"

        productmenu.add(findpr= new JMenu("Find Product"));

       findpr.add(jmeBar = new JMenuItem("Barcode", 'B'));

        findpr.add(jmeID = new JMenuItem("Product ID", 'I'));
        // Add menu items with mnemonics to menu "Staff"

        staffmenu.add(addstaff = new JMenuItem("Insert"));
        staffmenu.add(updatestaff = new JMenuItem("Update"));
        staffmenu.add(delstaf = new JMenuItem("Remove"));
        staffmenu.add(jmiClose = new JMenuItem("Show table"));
        staffmenu.addSeparator();
        staffmenu.add(findstaf = new JMenu("Find Staff by"));
        findstaf.add(stafid = new JMenuItem("Staff ID"));
        findstaf.add(stafname = new JMenuItem("Staff name"));

        // Add menu items with mnemonics to menu "Customer"

        customermenu.add(addcus = new JMenuItem("Insert"));
        customermenu.add(upcus = new JMenuItem("Update"));
        customermenu.add(delcus = new JMenuItem("Remove"));
        customermenu.add(cust = new JMenuItem("Show table"));
        customermenu.addSeparator();
        customermenu.add(ficu = new JMenu("Find Customer by"));
        ficu.add(cusna= new JMenuItem("Name"));
        ficu.add(cusid = new JMenuItem("ID"));
        // Add menu items with mnemonics to menu "Supplier"

        suppliermenu.add(adsup = new JMenuItem("Insert"));
        suppliermenu.add(upsup = new JMenuItem("Update"));
        suppliermenu.add(delsup = new JMenuItem("Remove"));
        suppliermenu.add(supt = new JMenuItem("Show table"));
        suppliermenu.addSeparator();
        suppliermenu.add(finsup = new JMenu("Find Supplier by"));
        finsup.add(supna= new JMenuItem("Name"));
        finsup.add(supid = new JMenuItem("ID"));
        // Add menu items with mnemonics to menu "Purchase"

        purchasemenu.add(rpt = new JMenuItem("Reports", 'T'));
        purchasemenu.add(bill = new JMenuItem("Bill", 'L'));
        // Add menu items with mnemonics to menu "Exit"
        exitmenu.add(exit = new JMenuItem("Exit", 'X'));

// Set keyboard accelerators

       jmeBar.setAccelerator(

                KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));

        jmeID.setAccelerator(

                KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));

        jmeID.setAccelerator(

                KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        exit.setAccelerator(

                KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        rpt.setAccelerator(

                KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        bill.setAccelerator(

                KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));



// Panel p1 to hold text fields and labels

         p1 = new JPanel(new FlowLayout());

        p1.add(new JLabel("Number 1"));

        p1.add(jtfNum1 = new JTextField(3));

        p1.add(new JLabel("Number 2"));

        p1.add(jtfNum2 = new JTextField(3));

        p1.add(new JLabel("Result"));

        p1.add(jtfResult = new JTextField(4));

        jtfResult.setEditable(false);

// Panel p2 to hold buttons

        p2 = new JPanel(new FlowLayout());

        p2.add(jbtAdd = new JButton("Add"));

        p2.add(jbtSub = new JButton("Subtract"));

        p2.add(jbtMul = new JButton("Multiply"));

        p2.add(jbtDiv = new JButton("Divide"));
// Add panels to the frame
        setLayout(new BorderLayout());
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
// Register listeners
        jbtAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              //  calculate('+');
            }
        });

        jbtSub.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //calculate('-');

            }

        });

        jbtMul.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //calculate('*');

            }

        });

        jbtDiv.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                //calculate('/');

            }

        });

        /**jmiAdd.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                calculate('+');

            }

        });**/


        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });;

        setLayout(new BorderLayout());
        add(menuBar, BorderLayout.NORTH);

        add(p2, BorderLayout.SOUTH);

        setVisible(true);

    }

/** Calculate and show the result in jtfResult */

    private void calculate(char operator) {

// Obtain Number 1 and Number 2

        int num1 = (Integer.parseInt(jtfNum1.getText().trim()));

        int num2 = (Integer.parseInt(jtfNum2.getText().trim()));

        int result = 0;

// Perform selected operation

        switch (operator) {

            case '+': result  = num1 + num2;
                break;
            case '-': result = num1 - num2;
                break;
            case '*': result = num1 * num2;
                break;
            case '/': result = num1 / num2;

        }

// Set result in jtfResult
        jtfResult.setText(String.valueOf(result));

    }
    public static void main (String args[]){
    new administratorSection();
}
}
