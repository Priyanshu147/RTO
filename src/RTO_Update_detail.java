import java.sql.*;
import java.util.*;

public class RTO_Update_detail {
    Scanner sc = new Scanner(System.in);

    public void update(String input_number_plate) throws Exception {
        JDBC_Connection j = new JDBC_Connection();
        String sql;
        boolean exit_update = true;
        while (exit_update == true) {
            System.out.print(
                    "1)Update owner name \n2)Update insurance date \n3)Update puc date \n4)Upddate contact detail \n5) Back to main menu \nEnter your choice : ");
            String update_choice = sc.nextLine();

            switch (update_choice) {
                case "1": {
                    System.out.print("Enter name to update : ");
                    String name = sc.nextLine();
                    sql = "update registration set owner_name =? where number_plate=?";
                    PreparedStatement pst = j.Connection2().prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setString(2, input_number_plate);
                    int r = pst.executeUpdate();
                    if (r > 0) {
                        System.out.println("name update sucessfully");
                    } else {
                        System.out.println("Update unsucessfull");
                    }
                }
                    break;
                case "2": {
                    System.out.println("Enter insurance end-Date in DD/MM/YYYY Formate to update : ");
                    String insurance = sc.nextLine();
                    sql = "update registration set insurance =? where number_plate=?";
                    PreparedStatement pst = j.Connection2().prepareStatement(sql);
                    pst.setString(1, insurance);
                    pst.setString(2, input_number_plate);
                    int r = pst.executeUpdate();
                    if (r > 0) {
                        System.out.println("insurance update sucessfully");
                    } else {
                        System.out.println("invalid number plate");
                    }
                }
                    break;
                case "3": {
                    System.out.println("Enter puc end-Date in DD/MM/YYYY Formate to update : ");
                    String puc = sc.nextLine();
                    sql = "update registration set insurance =? where number_plate=?";
                    PreparedStatement pst = j.Connection2().prepareStatement(sql);
                    pst.setString(1, puc);
                    pst.setString(2, input_number_plate);
                    int r = pst.executeUpdate();
                    if (r > 0) {
                        System.out.println("puc update sucessfully");
                    } else {
                        System.out.println("invalid number plate");
                    }
                }
                    break;
                case "4": {
                    System.out.println("Enter contact to update : ");
                    String contact = sc.nextLine();
                    sql = "update registration set owner_phone_no =? where number_plate=?";
                    PreparedStatement pst = j.Connection2().prepareStatement(sql);
                    pst.setString(1, contact);
                    pst.setString(2, input_number_plate);
                    int r = pst.executeUpdate();
                    if (r > 0) {
                        System.out.println("contact update sucessfully");
                    } else {
                        System.out.println("invalid number plate");
                    }
                }
                    break;
                case "5": {
                    exit_update = false;
                }
                    break;
                default: {
                    System.out.println("Invalid choice");
                }
                    break;
            }
        }
    }
}
