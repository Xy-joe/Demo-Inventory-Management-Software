import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class pgsConnect {
    public DefaultTableModel supermarketadminconnect() {
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("S/N");
        dt.addColumn("Date");
        dt.addColumn("ProductID");
        dt.addColumn("Barcode");
        dt.addColumn("Product");
        dt.addColumn("Price");

        // SQL Statement
        String st = "SELECT * FROM Supermarket.Products";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                int id = rr.getInt(1);String sn = Integer.toString(id);int ID = rr.getInt(2); String produID = Integer.toString(ID);
                String date = rr.getString(3);
                String bcode = rr.getString(4);
                String prod = rr.getString(5);
                double pd = rr.getDouble(6); String price = Double.toString(pd);

                dt.addRow(new String[]{sn,produID, date,bcode, prod, price});
            }
            return dt;

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return null;
    }

    public DefaultTableModel supermarketreception() {
        DefaultTableModel dt = new DefaultTableModel();
        dt. addColumn("S/N");
        dt.addColumn("ProductID");
        dt.addColumn("Product");
        dt.addColumn("Price");

        // SQL Statement
        String st = "SELECT * FROM Supermarket.Products";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                int id = rr.getInt(1);String sn = Integer.toString(id);
                String produID = rr.getString(3);
                String prod = rr.getString(5);
                String price = rr.getString(6);

                dt.addRow(new String[]{sn,produID,prod, price});
            }
            return dt;

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return null;
    }
    public  Boolean supermarketadd(String sn, String date, String prodID, String bcode, String prod, String price){

        String sql = "INSERT INTO Supermarket.Products(S_N, Date, ProductID, Barcode, Product, Price) VALUES('"+sn+"','"+date+"','"+prodID+"', '"+bcode+"', '"+prod+"', '"+price+"')";

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(sql);

            ss.execute(sql);
            return (true);
        }catch (SQLException es){
            JOptionPane.showMessageDialog(null, "Some fields have been incorrectly entered");
            es.printStackTrace();
            return (false);
        }

    }
    public DefaultTableModel supermaketDataretrival() {
        // Add Columns to the Table
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("S/N");
        dt.addColumn("Date");
        dt.addColumn("ProductID");
        dt.addColumn("Barcode");
        dt.addColumn("Product");
        dt.addColumn("Price");


        // SQL Statement
        String st = "SELECT * FROM Supermarket.Products";



        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                int id = rr.getInt(1); String sn = Integer.toString(id);
                String date = rr.getString(3);
                int prodid = rr.getInt(2);
                String idm = Integer.toString(prodid);
                String bcode = rr.getString(4);
                String prod = rr.getString(5);
                double pr = rr.getDouble(6);String price = Double.toString(pr);


                dt.addRow(new String[]{sn, date, idm,bcode, prod, price});
            }

            return dt;
        } catch (SQLException es) {
            es.printStackTrace();

        }
        return null;
    }
    public Boolean supermarketUpdate(String sn, String date, String prodid,String bcode, String prod, String price ){
        String sql = "UPDATE Supermarket.Products SET Date = '" + date+"', ProductID = '"+ prodid+"',Barcode = '"+bcode+"' ,Product=  '"+prod+"',Price = '"+price+"' WHERE S_N = '" + sn+"'";
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;


        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Server Error");
            ex.printStackTrace();
            return  false;
        }
    }
    public Boolean supermarketsearch(String prod, String bcode){


    String sql ="SELECT *  FROM Supermarket.Products WHERE Barcode = '"+bcode+"' OR Product = '"+prod+"'";
    try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.execute();
        return false;

    }catch (SQLException es){
        JOptionPane.showMessageDialog(null, "Search Connection Problem");
        es.printStackTrace();

        return null;
    }}
    public Boolean supermarketdelete(String sn){
        String sql = "DELETE FROM Supermarket.Products WHERE S_N ='" + sn + "'";

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException es) {
            es.printStackTrace();
            return false;
        }

    }

    // CONNECTIONS FOR THE STAFF TABLE




}






