package presenters;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class StaffConnection {

    public StaffConnection() {


    }

    public DefaultTableModel adminStaff() {
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Serial_No");
        dt.addColumn("SURNAME");
        dt.addColumn("FIRSTNAME");
        dt.addColumn("Staff_ID");
        dt.addColumn("GENDER");
        dt.addColumn("OFFICE");
        dt.addColumn("PHONE_NUMBER");
        dt.addColumn("ADDRESS");
        dt.addColumn("Date_Of_Appiontment");
        // SQL Statement
        String st = "SELECT * FROM Supermarket.Staff_Table";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                int sn = rr.getInt(1);
                String no = Integer.toString(sn);
                String surname = rr.getString(2);
                String firstname = rr.getString(3);
                String staffID = rr.getString(4);
                String gender = rr.getString(5);
                String positions = rr.getString(6);
                int phone = rr.getInt(7);
                String pn = Integer.toString(phone);
                String addres = rr.getString(8);
                String date = rr.getString(9);

                dt.addRow(new String[]{no, surname, firstname, staffID, gender, positions, pn, addres, date});
            }
            return dt;

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return null;
    }

    public Boolean staffadd( String sn, String fn, String stafid, String gen, String pos, String phone, String addres, String date) {

        String sql = "INSERT INTO Supermarket.Staff_Table(SURNAME, FIRSTNAME, STAFF_ID, GENDER, OFFICE, PHONE_NUMBER, ADDRESS, Date_Of_Appiontment) VALUES('" + sn + "','" + fn + "','" + stafid + "', '" + gen + "', '" + pos + "', '" + phone + "', '" + addres + "', '"+date+"')";

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(sql);

            ss.execute(sql);
            return (true);
        } catch (SQLException es) {
            JOptionPane.showMessageDialog(null, "Some fields have been incorrectly entered");
            es.printStackTrace();
            return (false);
        }

    }

    public DefaultTableModel staffDataretrival() {
        // Add Columns to the Table
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("Serial_No");
        dt.addColumn("SURNAME");
        dt.addColumn("FIRSTNAME");
        dt.addColumn("STAFF_ID");
        dt.addColumn("GENDER");
        dt.addColumn("OFFICE");
        dt.addColumn("PHONE_NUMBER");
        dt.addColumn("ADDRESS");
        dt.addColumn("Date_Of_Appiontment");

        // SQL Statement
        String st = "SELECT * FROM Supermarket.Staff_Table";


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                int sn = rr.getInt(1);
                String no = Integer.toString(sn);
                String surname = rr.getString(2);
                String firstname = rr.getString(3);
                String staffID = rr.getString(4);
                String gender = rr.getString(5);
                String positions = rr.getString(6);
                int phone = rr.getInt(7);
                String pn = Integer.toString(phone);
                String addres = rr.getString(8);
                String date = rr.getString(9);

                dt.addRow(new String[]{no, surname, firstname, staffID, gender, positions, pn, addres, date});
            }
            return dt;

        } catch (SQLException esp) {
            esp.printStackTrace();

        }
        return null;
    }

    public Boolean staffUpdate(String no, String sn, String fn, String stafid, String gen, String pos, String phone, String addre,String date) {
        String sql = "UPDATE Supermarket.Staff_Table SET Date_Of_Appiontment = '" + date +"',SURNAME = '" + sn + "', FIRSTNAME = '" + fn + "',STAFF_ID = '" + stafid + "' ,GENDER = '" + gen + "', OFFICE=  '" + pos + "',PHONE_NUMBER = '" + phone + "', ADDRESS = '" + addre + "' WHERE Serial_No = '" + no + "'";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Update Error");
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean staffDeletion(String sn) {
        String sql = "DELETE FROM Supermarket.Staff_Table WHERE Serial_No ='" + sn + "'";

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
}



