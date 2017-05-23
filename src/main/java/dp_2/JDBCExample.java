package dp_2;


import java.sql.*;

class JDBCExample {
    private final static String DB_URL = "jdbc:mysql://db.f4.htw-berlin.de:3306/_s0550668__mockupdatadb";
    private final static String USER = "s0550668";
    private final static String PASSWORD = "password";
    private Connection conn = null;
    private Statement stmt = null;

    JDBCExample() {
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
        } catch(Exception e) {
            System.out.println("Connection to database failed.");		//Handle errors for Class.forName
        }
    }

    private ResultSet getAll() {
        ResultSet rs = null;

        try {
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM mockupdatatable");
        } catch(SQLException se) {
            System.out.println("Connection to database failed.");
        }
        return rs;
    }

    void printAll() {
        try {
            ResultSet rs = this.getAll();

            while(rs.next()) {
                int id  = rs.getInt("id");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                String email = rs.getString("email");
                String ipnr = rs.getString("ipnr");

                System.out.printf("%3d  %-10s %-12s %-30s %-10s %n", id, vorname, nachname, email, ipnr);
            }
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    void close() {
        try{
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            se.printStackTrace();
        }
        System.out.println("Goodbye!");
    }

}