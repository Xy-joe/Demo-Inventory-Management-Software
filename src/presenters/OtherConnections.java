package presenters;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * Created by joebuntu on 4/4/17.
 */
public class OtherConnections {
    Connection con;

    public boolean addPurchasedetails(String date, String pnme, String pid, String amount, String pqty, String time,
                                   String cashie) {
        String sql = "INSERT INTO Supermarket.Purchase_History_table( Date_Of_Purchase, Cashiers_Name, Product_Name, Product_ID, Product_Quantity, Amount_Paid,Time_Of_Purchase,Serial_No)" +
                " VALUES('" + date + "','" + cashie + "', '" + pnme + "', '" + pid + "', '" + pqty + "','" + amount + "','" + time + "')";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(sql);
            ss.execute(sql);
            return (true);

        } catch (SQLException es) {
            JOptionPane.showMessageDialog(null, "Some fields have been incorrectly entered");
            es.printStackTrace();
            return (false);
        }
    }

    public DefaultTableModel purchaseTable() {
        DefaultTableModel dt = new DefaultTableModel();
        dt. addColumn("Serial No");
        dt.addColumn("Date Of Purchase");
        dt.addColumn("Cashiers Name");
        dt.addColumn("Product Name");
        dt.addColumn("Product ID");
        dt.addColumn("Product Quantity");
        dt.addColumn("Amount Paid");
        dt.addColumn("Time Of Purchase");


        // SQL Statement
        String st = "SELECT * FROM Supermarket.Purchase_History_Table";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

               String date = rr.getString(1);
                String cashier = rr.getString(2);
                String prod = rr.getString(3);
                String produID = rr.getString(4);
                int qty = rr.getInt(5); String amount = Integer.toString(qty);
                String price = rr.getString(6);
                String time = rr.getString(7);
                int sn = rr.getInt(7); String serial = Integer.toString(sn);



                dt.addRow(new String[]{serial,date,cashier,prod,produID, price,amount,time});
            }
            return dt;

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return null;
    }

    public DefaultTableModel deptTable() {
        DefaultTableModel dt = new DefaultTableModel();
        dt. addColumn("Serial No");
        dt.addColumn("Customer Full Name");
        dt.addColumn("Dept ID");
        dt.addColumn("Dept Date");
        dt.addColumn("Product Name");
        dt.addColumn("Product ID");
        dt.addColumn("Product Quantity");
        dt.addColumn("Due_Date");
        dt.addColumn("Payment Status");
        dt.addColumn("Amount Paid");
        dt.addColumn("Balance Payment");
        dt.addColumn("Phone_Number");
        dt.addColumn("Address");



        // SQL Statement
        String st = "SELECT * FROM Supermarket.Dept_Table";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {
                int sn = rr.getInt(1); String serial = Integer.toString(sn);
                String name = rr.getString(2);
                String did = rr.getString(3);
                String date = rr.getString(4);
                String prod = rr.getString(5);
                String produID = rr.getString(6);
                int qty = rr.getInt(7); String amount = Integer.toString(qty);
                String duedate = rr.getString(8);
                String stat = rr.getString(9);
                double pp = rr.getDouble(10);String paid = Double.toString(pp);
                double bp = rr.getDouble(11);String balance = Double.toString(bp);
                String phone = rr.getString(12);
                String addre = rr.getString(13);





                dt.addRow(new String[]{serial,name,did,date,prod,produID,amount,paid,balance,duedate,phone,stat,addre});
            }
            return dt;

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return null;
    }

    public boolean addDept(String name,String did,String date,String prod,String produID,String amount,String duedate,String stat,
                           String paid,String balance,String phone,String addre) {
        String sql = "INSERT INTO Supermarket.Dept_Table( Customer_Full_Name,Dept_ID, Dept_Date, Product_Name, Product_ID, Product_Quantity,Due_Date,Payment_Status," +
                "Amount_Paid,Balance_Payment,Phone_Number, Address)" +
                " VALUES('" + name + "','" + did + "', '" + date + "', '" + prod + "', '" + produID + "','" + amount + "','" + duedate + "', '" + stat + "','" + paid + "'," +
                "'" + balance + "', '" + phone + "','" + addre+ "')";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(sql);
            ss.execute(sql);
            return (true);

        } catch (SQLException es) {
            JOptionPane.showMessageDialog(null, "Some fields have been incorrectly entered");
            es.printStackTrace();
            return (false);
        }
    }

    public DefaultTableModel searchDept(String id) {
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Serial No");
        dt.addColumn("Customer Full Name");
        dt.addColumn("Dept ID");
        dt.addColumn("Dept Date");
        dt.addColumn("Product Name");
        dt.addColumn("Product ID");
        dt.addColumn("Product Quantity");
        dt.addColumn("Due_Date");
        dt.addColumn("Payment Status");
        dt.addColumn("Amount Paid");
        dt.addColumn("Balance Payment");
        dt.addColumn("Phone_Number");
        dt.addColumn("Address");
        String sql = "SELECT *  FROM Dept_Table WHERE STAFF_ID = '" + id + "' ";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {

                int sn = rs.getInt(1);
                String serial = Integer.toString(sn);
                String name = rs.getString(2);
                String did = rs.getString(3);
                String date = rs.getString(4);
                String prod = rs.getString(5);
                String produID = rs.getString(6);
                int qty = rs.getInt(7);
                String amount = Integer.toString(qty);
                String duedate = rs.getString(8);
                String stat = rs.getString(9);
                double pp = rs.getDouble(10);
                String paid = Double.toString(pp);
                double bp = rs.getDouble(11);
                String balance = Double.toString(bp);
                String phone = rs.getString(12);
                String addre = rs.getString(13);

                dt.addRow(new String[]{serial, name, did, date, prod, produID, amount, paid, balance, duedate, phone, stat, addre});

            }
            return dt;


        } catch (SQLException es) {
            JOptionPane.showMessageDialog(null, "Search Connection Problem");
            es.printStackTrace();
            return null;
        }
    }
}
