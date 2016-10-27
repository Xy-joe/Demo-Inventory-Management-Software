import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class StaffConnection {

    public StaffConnection() {


    }

    public DefaultTableModel adminStaff() {
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("SURNAME");
        dt.addColumn("FIRSTNAME");
        dt.addColumn("Staff_ID");
        dt.addColumn("GENDER");
        dt.addColumn("POSITIONS");
        dt.addColumn("PHONE_NUMBER");
        dt.addColumn("ADDRESS");

        // SQL Statement
        String st = "SELECT * FROM Supermarket.Staff_Table";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                String surname = rr.getString(1);
                String firstname = rr.getString(2);
                String staffID = rr.getString(3);
                String gender = rr.getString(4);
                String positions = rr.getString(5);
                int phone = rr.getInt(6);
                String pn = Integer.toString(phone);
                String addres = rr.getString(7);

                dt.addRow(new String[]{surname, firstname, staffID, gender, positions, pn, addres});
            }
            return dt;

        } catch (SQLException es) {
            es.printStackTrace();
        }
        return null;
    }

    public Boolean staffadd(String sn, String fn, String stafid, String gen, String pos, String phone, String addres) {

        String sql = "INSERT INTO Supermarket.Staff_Table(SURNAME, FIRSTNAME, STAFF_ID, GENDER, POSITION, PHONE_NUMBER, ADDRESS) VALUES('" + sn + "','" + fn + "','" + stafid + "', '" + gen + "', '" + pos + "', '" + phone + "', '" + addres + "')";

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
        dt.addColumn("SURNAME");
        dt.addColumn("FIRSTNAME");
        dt.addColumn("Staff_ID");
        dt.addColumn("GENDER");
        dt.addColumn("POSITIONS");
        dt.addColumn("PHONE_NUMBER");
        dt.addColumn("ADDRESS");

        // SQL Statement
        String st = "SELECT * FROM Supermarket.Staff_Table";


        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                String surname = rr.getString(1);
                String firstname = rr.getString(2);
                String staffID = rr.getString(3);
                String gender = rr.getString(4);
                String positions = rr.getString(5);
                int phone = rr.getInt(6);
                String pn = Integer.toString(phone);
                String addres = rr.getString(7);

                dt.addRow(new String[]{surname, firstname, staffID, gender, positions, pn, addres});
            }
                return dt;

            }catch(SQLException esp){
                esp.printStackTrace();

            }
            return null;
        }
        public Boolean staffUpdate(String sn, String fn, String stafid,String gen, String pos, String phone, String addre ){
            String sql = "UPDATE Supermarket.Staff_Table SET SURNAME = '" +sn+"', FIRSTNAME = '"+ fn+"',STAFF_ID = '"+stafid+"' ,GENDER = '"+gen+"', POSITION=  '"+pos+"',PHONE_NUMBER = '"+phone+"', ADDRESS = '"+addre+"' WHERE STAFF_ID = '" + stafid+"'";
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

    }



