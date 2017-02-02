import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class connectionclass {

    public connectionclass() {


        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData md = null;


        try {

            Class.forName("com.mysql.jdbc.Driver");


            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");

            stmt = con.createStatement();
            System.out.println("Connection Established");
            String sql = "SELECT * FROM Supermarket.NFCSTableStaff";
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


    // INSEART INTO DATABASE
    public Boolean add(String sn, String fn, String ln, String ge, String dep, String offi, String soda, String dob, String par, String pn, String emai, String soo) {

        //SQL STATEMENT
        String sql = "INSERT INTO  Supermarket.NFCSTableStaff(S_N, FIRSTNAME, LASTNAME, GENDER, DEPARTMENT, OFFICEOCCUPIED, SODALITY,  DATEOFBIRTH, PARISH, PHONENUMBER, EMAIL, STATEOFORIGIN) VALUES ('" + sn + "','" + fn + "', '" + ln + "', '" + ge + "', '" + dep + "', '" + offi + "', '" + soda + "', '" + dob + "', '" + par + "', '" + pn + "', '" + emai + "', '" + soo + "')";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement st = con.prepareStatement(sql);

            st.execute(sql);

            return (true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return (false);
    }

    //RETRIEVE DATA FROM STUDENT DATABASE
    public DefaultTableModel getStudentdata() {
        //ADD COLOUMS TO THE TABLE
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("S_N");
        dt.addColumn("FIRSTNAME");
        dt.addColumn("LASTNAME");
        dt.addColumn("REGNO");
        dt.addColumn("DEPARTMENT");
        dt.addColumn("LEVEL");
        dt.addColumn("GENDER");
        dt.addColumn("SODALITY");
        dt.addColumn("STATEOFORIGIN");
        dt.addColumn("COMMITEE");
        dt.addColumn("POSTHELD");
        dt.addColumn("EMAIL");
        dt.addColumn("PHONENUMBER");
        dt.addColumn("DATEOFBIRTH");

        // SQL Statement
        String st = "SELECT * FROM Supermarket.NfcsStudenttable";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                String sn = rr.getString(1);
                String fn = rr.getString(2);
                String ln = rr.getString(3);
                String reg = rr.getString(4);
                String dep = rr.getString(5);
                String lev = rr.getString(6);
                String gen = rr.getString(7);
                String soda = rr.getString(8);
                String soo = rr.getString(9);
                String com = rr.getString(10);
                String ph = rr.getString(11);
                String emai = rr.getString(12);
                String pn = rr.getString(13);
                String dob = rr.getString(14);
                ;

                dt.addRow(new String[]{sn, fn, ln, reg, dep, lev, gen, soda, soo, com, ph, emai, pn, dob});
            }

            return dt;
        } catch (SQLException es) {
            es.printStackTrace();

        }
        return null;
    }
    // RETRIEVE FROM STAFF DATABASE

    public DefaultTableModel getData() {
        // Add Columns to the Table
        DefaultTableModel dt = new DefaultTableModel();
        dt.addColumn("S_N");
        dt.addColumn("FIRSTNAME");
        dt.addColumn("LASTNAME");
        dt.addColumn("GENDER");
        dt.addColumn("DEPARTMENT");
        dt.addColumn("OFFICEOCCUPIED");
        dt.addColumn("SODALITY");
        dt.addColumn("DATEOFBIRTH");
        dt.addColumn("PARISH");
        dt.addColumn("PHONENUMBER");
        dt.addColumn("EMAIL");
        dt.addColumn("STATEOFORIGIN");

        // SQL Statement
        String st = "SELECT * FROM Supermarket.NFCSTableStaff";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");
            Statement ss = con.prepareStatement(st);
            ResultSet rr = ss.executeQuery(st);

            while (rr.next()) {

                String sn = rr.getString(1);
                String fn = rr.getString(2);
                String ln = rr.getString(3);
                String ge = rr.getString(4);
                String dep = rr.getString(5);
                String offi = rr.getString(6);
                String soda = rr.getString(7);
                String dob = rr.getString(8);
                String par = rr.getString(9);
                String pn = rr.getString(10);
                String emai = rr.getString(11);
                String soo = rr.getString(12);

                dt.addRow(new String[]{sn, fn, ln, ge, dep, offi, soda, dob, par, pn, emai, soo});
            }

            return dt;
        } catch (SQLException es) {
            es.printStackTrace();

        }
        return null;
    }

    //UPDATE DATABASE
    public boolean update(String sn, String fn, String ln, String ge, String dep, String offi, String soda, String dob, String par, String pn, String emai, String soo) {


        //SQL STATEMENT
        String sql = "UPDATE Supermarket.NFCSTableStaff SET FIRSTNAME='" + fn + "', LASTNAME='" + ln + "',GENDER='" + ge + "', DEPARTMENT='" + dep + "',OFFICEOCCUPIED='" + offi + "', SODALITY='" + soda + "', DATEOFBIRTH='" + dob + "', PHONENUMBER='" + pn + "', EMAIL='" + emai + "', PARISH='" + par + "',STATEOFORIGIN='" + soo + "'  WHERE S_N ='" + sn + "'  ";

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Supermarket", "root", "joe9ty");

            Statement stmt = con.prepareStatement(sql);
            stmt.execute(sql);
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    //DELETE DATA FROM DATABASE
    public boolean delete(String sn) {
        String sql = "DELETE FROM Supermarket.NFCSTableStaff WHERE S_N='" + sn + "'";

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

