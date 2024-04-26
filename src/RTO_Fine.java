import java.util.*;
import java.sql.*;

public class RTO_Fine {
    double fine;
    Scanner sc = new Scanner(System.in);
    public void payfine(String number_plate) throws Exception {
        JDBC_Connection j = new JDBC_Connection();
        String sql = "select fines from registration where number_plate=?";
        PreparedStatement pst = j.Connection2().prepareStatement(sql);
        pst.setString(1, number_plate);
        ResultSet rs = pst.executeQuery();
        boolean find = false;
        while (rs.next()) {
            find = true;
            fine = rs.getDouble(1);
        }
        if (find == false) {
            System.out.println("invalid number plate");
        }
        if (fine > 0) {
            boolean exit = true;
            while (exit) {
                System.out.println("You want pay your fine ? \nEnter 1 for YES \nEnter 2 for NO ");
                String choice_fine = sc.nextLine();
                switch (choice_fine) {
                    case "1": {
                        System.out.println("Enter your debit card / credit card details");
                        String card = sc.nextLine();
                        System.out.println("Enter your card password");
                        String card_password = sc.nextLine();
                        sql = "Update registration set fines=? where number_plate=?";
                        pst = j.Connection2().prepareStatement(sql);
                        pst.setDouble(1, 0);
                        pst.setString(2, number_plate);
                        pst.execute();
                        if (card.equals("12345678") && card_password.equals("1234")) {
                            System.out.println("You successfully paid the  " + fine + " fine.");
                            exit = false;
                        } else {
                            System.out.println("Inalid card detail or password");
                            System.out.println("Try again");
                        }
                    }
                        break;
                    case "2": {
                        exit = false;
                    }
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        } else {
            System.out.println("You don't have any fines.");
        }

    }

    public void addfine(String number_plate) throws Exception {
        JDBC_Connection j = new JDBC_Connection();
        System.out.print("Enter fine to add : ");
        try {   
            fine = sc.nextDouble();
        } catch (Exception e) {
            System.out.println(e);
        }
        String sql = "update registration set fines=fines+? where number_plate=?";
        PreparedStatement pst = j.Connection2().prepareStatement(sql);
        pst.setDouble(1, fine);
        pst.setString(2, number_plate);
        int r = pst.executeUpdate();
        if (r>0) {
            System.out.println("successfully update fine");
        } else {
            System.out.println("invalid number plate");
        }

    }

    public void remove_fine(String number_plate) throws Exception {
        JDBC_Connection j = new JDBC_Connection();
        Statement st = j.Connection2().createStatement();
        String sql = "update registration set fines=0 where number_plate='"+number_plate+"'";

        int r = st.executeUpdate(sql);
        if (r > 0) {
            System.out.println("successfully remove fine");
        } else {
            System.out.println("invalid number plate");
        }

    }
}