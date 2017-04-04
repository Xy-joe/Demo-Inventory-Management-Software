package presenters;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class supplierconnections {
    Connection con;
    public DefaultTableModel supplieradminconnect() {
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Serial_No");
        dt.addColumn("Code");
        dt.addColumn("Company Name");
        dt.addColumn("Address");
        dt.addColumn("City");
        dt.addColumn("Country");
        dt.addColumn("Phone Number");
        dt.addColumn("Email");
        dt.addColumn("Product Name");
        dt.addColumn("Quantity");
        dt.addColumn("Supplied Date");
        dt.addColumn("Last Supplied Date");
        dt.addColumn("Cash Paid");
        dt.addColumn("Balance Cash");

        // SQL Statement
        String st = "SELECT * FROM Supermarket.Supplier_Table";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                int id = rr.getInt(1);String sn = Integer.toString(id);
               String code = rr.getString(2);
                String name = rr.getString(3);
                String addre = rr.getString(4);
                String city = rr.getString(5);
                String count = rr.getString(6);
                int stock_no = rr.getInt(7); String phone = Integer.toString(stock_no);
                String email = rr.getString(8);
                String pname = rr.getString(9);
                int qty = rr.getInt(10);String pqty = Integer.toString(qty);
                String lsd = rr.getString(11);
                String sd = rr.getString(12);
                double pd = rr.getDouble(13); String cp = Double.toString(pd);
                double pdd = rr.getDouble(14); String bc = Double.toString(pdd);


                dt.addRow(new String[]{sn,code, name,addre, city, count, phone,email,pname,pqty,lsd,sd,cp,bc});
            }
            return dt;

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return null;
    }

    public  Boolean addsupplier( String code, String name, String addre, String city, String cotry,
                                String phone, String email, String pname, String pqty, String lsd, String sd, String cp, String bc){

        String sql = "INSERT INTO Supermarket.Supplier_Table(Code, Company_Name, Address, City, Country, Phone_No, Email, Product_Name, Product_Quantity, Last_Supplied_Date,Supply_Date, Cash_Paid, Balance_Cash)" +
                " VALUES('"+code+"','"+name+"', '"+addre+"', '"+city+"', '"+cotry+"','"+phone+"','"+email+"', '"+pname+"', '"+pqty+"', '"+lsd+"','"+sd+"','"+cp+"','"+bc+"')";

        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(sql);
            if (code.equals("")){
                JOptionPane.showMessageDialog(null,"Code field is empty");
                return true;
            }
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Company Name field is empty");
                return true;
            }
            if (addre.equals(null)){
                JOptionPane.showMessageDialog(null,"Address field is empty");
                return true;
            }
            if (city.equals(null)){
                JOptionPane.showMessageDialog(null,"City field is empty");
                return true;
            }
            if (cotry.equals(null)){
                JOptionPane.showMessageDialog(null,"Cotry field is empty");
                return true;
            }else {
                ss.execute(sql);
                return (true);
            }
        }catch (SQLException es){
            JOptionPane.showMessageDialog(null, "Some fields have been incorrectly entered");
            es.printStackTrace();
            return (false);
        }

    }
    public DefaultTableModel refreshSupplier() {
        // Add Columns to the Table
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Serial_No");
        dt.addColumn("Code");
        dt.addColumn("Company Name");
        dt.addColumn("Address");
        dt.addColumn("City");
        dt.addColumn("Country");
        dt.addColumn("Phone Number");
        dt.addColumn("Email");
        dt.addColumn("Product Name");
        dt.addColumn("Quantity");
        dt.addColumn("Supplied Date");
        dt.addColumn("Last Supplied Date");
        dt.addColumn("Cash Paid");
        dt.addColumn("Balance Cash");


        // SQL Statement
        String st = "SELECT * FROM Supermarket.Supplier_Table";



        try {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                int id = rr.getInt(1);String sn = Integer.toString(id);
                String code = rr.getString(2);
                String name = rr.getString(3);
                String addre = rr.getString(4);
                String city = rr.getString(5);
                String count = rr.getString(6);
                int stock_no = rr.getInt(7); String phone = Integer.toString(stock_no);
                String email = rr.getString(8);
                String pname = rr.getString(9);
                int qty = rr.getInt(10);String pqty = Integer.toString(qty);
                String lsd = rr.getString(11);
                String sd = rr.getString(12);
                double pd = rr.getDouble(13); String cp = Double.toString(pd);
                double pdd = rr.getDouble(14); String bc = Double.toString(pdd);


                dt.addRow(new String[]{sn,code, name,addre, city, count, phone,email,pname,pqty,lsd,sd,cp,bc});
            }

            return dt;
        } catch (SQLException es) {
            es.printStackTrace();

        }
        return null;
    }
    // Update Product  Method
    public Boolean updateSupplier(String sn, String code, String name, String addre, String city, String cotry,
                                     String phone, String email, String pname, String pqty, String lsd, String sd, String cp, String bc ){
        String sql = "UPDATE Supermarket.Supplier_Table SET Code = '" + code+"', Company_Name = '"+ name+"',Address = '"+addre+"' ,City=  '"+city+"',Country = '"+cotry+"',Phone_No =  '"+phone+"'," +
                "Email = '"+email+"',Product_Name = '"+pname+"',Product_Quantity = '"+pqty+"',Last_Supplied_Date = '"+lsd+"',Supply_Date = '"+sd+"',Cash_Paid = '"+cp+"',Balance_Cash = '"+bc+"' WHERE Serial_No = '" + sn+"'";
        try{
            if (code.equals("")){
                JOptionPane.showMessageDialog(null,"Code field is empty");
                return true;
            }
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Company Name field is empty");
                return true;
            }
            if (addre.equals(null)){
                JOptionPane.showMessageDialog(null,"Address field is empty");
                return true;
            }
            if (city.equals(null)){
                JOptionPane.showMessageDialog(null,"City field is empty");
                return true;
            }
            if (cotry.equals(null)){
                JOptionPane.showMessageDialog(null,"Country field is empty");
                return true;
            }else {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
                Statement stmt = con.prepareStatement(sql);
                stmt.execute(sql);
                return true;
            }

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Server Error");
            ex.printStackTrace();
            return  false;
        }
    }
    // Search method for the Products
    public Boolean searchsupplier(String prod){
    String sql ="SELECT *  FROM Supermarket.Supplier_Table WHERE Company_Name = '"+prod+"' OR Code = '"+prod+"'";
    try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.execute();
        return false;

    }catch (SQLException es){
        JOptionPane.showMessageDialog(null, "Search Connection Problem");
        es.printStackTrace();

        return null;
    }}
    // Delete Method for the Products
    public Boolean supplierDelete(String sn){
        String sql = "DELETE FROM Supermarket.Supplier_Table WHERE Serial_No ='" + sn + "'";

        try {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException es) {
            es.printStackTrace();
            return false;
        }

    }
}






