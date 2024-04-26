import java.sql.*;

public class JDBC_Connection {

    public Connection Connection2() throws Exception {
        String dburl = "jdbc:mysql://localhost:3306/rto_office";
        String dbuser = "root";
        String dbpass = "";
        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(dburl, dbuser, dbpass);
        return con;
    }
}
