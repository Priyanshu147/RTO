import java.util.*;
import java.sql.*;

public class RTO_Search_vehicle {
    Scanner sc = new Scanner(System.in); 
    public void search() throws Exception {
            JDBC_Connection j = new JDBC_Connection();
            System.out.println("Enter number plate of vehicle:-");
            String serch_vehicle = sc.nextLine();
            String sql = "Select * from registration where number_plate=?";
            PreparedStatement pst = j.Connection2().prepareStatement(sql);
            pst.setString(1, serch_vehicle);
            ResultSet rs = pst.executeQuery();
            boolean found=false;
            while (rs.next()) {
                found = true; 
                System.out.println("Owner Name:-" + rs.getString("owner_name"));
                System.out.println();
                System.out.println("vehicle information");
                System.out.println();
                System.out.println("vehicle name:-" + rs.getString("vehicle_name"));
                System.out.println();
                System.out.println("vehicle Type:-" + rs.getString("vehicle_type"));
                System.out.println();
                System.out.println("vehicle color:-" + rs.getString("vehicle_color"));
                System.out.println();
                System.out.println("vehicle insurance end date:-" + rs.getString("insurance"));
                System.out.println();
                System.out.println("vehicle PUC end date:-" + rs.getString("puc"));
                System.out.println();
                System.out.println("Owner contact number:-" + rs.getString("owner_phone_no"));
                System.out.println();
                System.out.println("vehicle owner have to pay fine:-" + rs.getDouble("fines"));
                System.out.println();

            }
            if (!found) {
                System.out.println("invalid number plate ");
            } 
    }
}
