package presenters;

import javax.swing.*;
import java.sql.*;


public class pgscalculator {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    public pgscalculator() {


        try {

            Class.forName("com.mysql.jdbc.Driver");


            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/views.Supermarket", "root", "joe9ty");

            stmt = con.createStatement();
            System.out.println("Connection Established");
            String sql = "SELECT * FROM Supermarket.Products";
            rs = stmt.executeQuery(sql);


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Please where is Your Driver Connecion");
            System.exit(1);
        } catch (ClassNotFoundException cnf) {

            cnf.printStackTrace();
            System.exit(1);
        } finally {

            try {
                stmt.close();
                con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(1);
            }
        }
    }

    public Boolean quantityPrice( double price, int ppq, double total) {

        String sql = "SELECT * FROM Supermarket.Products WHERE Price = '"+price+"'";


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/views.Supermarket", "root", "joe9ty");
            Statement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Incorrect Calculations");
            ex.printStackTrace();
            return false;

        }
    }
public Boolean balanceprice(double bal, double price){
    String sql = "SELECT * FROM Supermarket.Products WHERE Price = '"+price+"'";


    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/views.Supermarket", "root", "joe9ty");
        Statement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
        return true;

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Incorrect Calculations");
        ex.printStackTrace();
        return false;

    }
}
}
