package Tool;

import java.sql.*;


public class KoneksiDB {
    
    public Connection getConnection() throws SQLException {
        Connection cnn;
        try{
            String server = "jdbc:mysql://localhost/dbsiakad_171530012";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            cnn = DriverManager.getConnection(server, "root", "");
            return cnn;
        }catch(SQLException | ClassNotFoundException se){
            System.err.println(se);
            return null;
        }
    }
}

// Keterangan

/*
    pada baris 10 : dbsiakad_171530012 ubah dengan nama database kalian. 

*/
