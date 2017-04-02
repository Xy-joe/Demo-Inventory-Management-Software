import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Orderview extends JApplet {


    public JPanel pan1 = new JPanel();

    public JPanel pan2 = new JPanel();    // Create a button
    public JButton jbtDeleteColumn = new JButton(" Order");

    JLabel head = new JLabel();
    private JTextField nwww = new JTextField(20);
    private JTextField nww1 = new JTextField(20);
    private JTextField nww2 = new JTextField(20);
    private JTextField nww3 = new JTextField(20);

    JTextArea printarea = new JTextArea();

    public Orderview() {
       head.setText("Order For Shoprite \n\n SuperMarket");


        pan2.setLayout(new GridLayout(2,2));
        pan2.add(nwww);pan2.add(nww1);pan2.add(nww2);pan2.add(nww3);


        jbtDeleteColumn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String pr = nwww.getText();String fos = nww3.getText();
                String price =  nww1.getText();String payed = nww2.getText();
                printarea.append("\n\n Shoprite views.Supermarket Order Receipt: \n\n" +price+":\t\t" +
                        " "+ pr+"\t\t"+fos+"\n\n Thanks for Patronising us\n see you again soon" );

                JOptionPane.showMessageDialog(null, "Successfullly Ordered");


            }

        });
        printarea.setText("\t Shoprite SuperMarket (Order View) ");

        printarea.setWrapStyleWord(true);
        printarea.setFont(new Font("Century Schoolbook L", Font.BOLD + Font.ITALIC, 14));


       // pan1.add(pan2, BorderLayout.NORTH);
        pan1.add(printarea, BorderLayout.CENTER);
        //pan1.add(jbtDeleteColumn, BorderLayout.SOUTH);
       // add(pan1);
    }
    public boolean orderNow(String prod, String qty, double price){
      try {
          printarea.append("\n\n Shoprite views.Supermarket Order Receipt: \n\n" + prod + ":\t\t" +
                  " " + qty + "\t\t" + price + "\n\n Thanks for Patronising us\n see you again soon");

      }catch (Exception js){
          JOptionPane.showMessageDialog(null, "What are you odering ?");
          js.printStackTrace();

      }
        return true;
    }


    }


