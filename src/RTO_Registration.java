import java.util.*;
import java.sql.*;

public class RTO_Registration {
        Scanner sc = new Scanner(System.in);
        String sql;
        String number_plate;
        String owner_name;
        String vehicle_name;
        String vehicle_color;
        String vehicle_type;
        String password;
        String city;
        String plate;
        String insurance_date;
        String puc_date;
        int city_id;
        String owner_phoneNo;

        public void Registration() throws Exception {

                JDBC_Connection j = new JDBC_Connection();
                Statement st = j.Connection2().createStatement();
                System.out.println("Enter owner name : ");
                owner_name = sc.nextLine();
                System.out.println("Enter a vehicle name : ");
                vehicle_name = sc.nextLine();
                System.out.println("Enter vehicle color : ");
                vehicle_color = sc.nextLine();
                System.out.println("Enter a vehical type : ");
                vehicle_type = sc.nextLine();
                System.out.println("Enter city name : ");
                city = sc.nextLine();
                 sql = "Select id from city where name='" + city.toLowerCase() + "'";
                ResultSet rs = st.executeQuery(sql);
                boolean check =false;
                while (rs.next()) {
                        check=true;
                        city_id = rs.getInt(1);
                }
                if(check==false){
                        System.out.println("Invalid City name ");
                        return;
                }
                System.out.println("Enter insurance end-Date in DD/MM/YYYY Formate : ");
                insurance_date = sc.nextLine();
                System.out.println("Enter Puc end-Date in DD/MM/YYYY Formate : ");
                puc_date = sc.nextLine();
                System.out.println("Enter owner contact number : ");
                owner_phoneNo = sc.nextLine();
                password_verify pv = new password_verify();
                password = pv.login();
               
                sql = "Select number_plate from registration";
                ResultSet rs1 = st.executeQuery(sql);
                System.out.println("1)Do you want a custom number plate. \n1)Yes \n2)No");
                String a = sc.nextLine();

                if (a.equals("1")) {
                        System.out.println("Enter the six digits of the number plate you want.");
                        String p = sc.nextLine();
                        while (rs1.next()) {
                                if (rs1.getString(1).equals("GJ " + city_id + " " + p)) {
                                        System.out.println("Sorry Number plate is not available");
                                        return;
                                }
                        }
                        number_plate = "GJ " + city_id + " " + p;
                } else {
                        number_plate = "GJ " + city_id + " " + number_platte_generator();
                        System.out.println("number_plate:-" + number_plate);
                }
                sql = "insert into registration values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement prp = j.Connection2().prepareStatement(sql);
                prp.setString(1, number_plate);
                prp.setString(2, owner_name);
                prp.setString(3, vehicle_name);
                prp.setString(4, vehicle_color);
                prp.setString(5, vehicle_type);
                prp.setDouble(6, 0);
                prp.setString(7, insurance_date);
                prp.setString(8, puc_date);
                prp.setString(9, password);
                prp.setString(10, owner_phoneNo);
                int r = prp.executeUpdate();
                if (r >= 1) {
                        System.out.println("You have sucessfully registered");
                } else {
                        System.out.println("Sorry registered insucessfull");
                }
        }

        public String number_platte_generator() {
                int letter1 = 65 + (int) (Math.random() * (90 - 65));
                int letter2 = 65 + (int) (Math.random() * (90 - 65));
                int no1 = (int) (Math.random() * 10);
                int no2 = (int) (Math.random() * 10);
                int no3 = (int) (Math.random() * 10);
                int no4 = (int) (Math.random() * 10);
                plate = "" + ((char) (letter1)) + "" + ((char) (letter2)) + " " + no1 + no2 + no3 + no4;
                return plate;
        }

}
