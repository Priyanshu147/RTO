import java.util.*;

public class RTO {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String permanent_password = "12345678";
        System.out.println("----Welcome to RTO app----");
        String main_choice;
        while (true) {
            System.out.print("1)Login as Administrator \n2)login as user \n3)For exit \nEnter your choice : ");
            main_choice = sc.nextLine();
            switch (main_choice) {
                case "1": {
                    System.out.print("You registered as Administrator. \nPlease enter password : ");
                    while (true) {
                        String enter_password = sc.nextLine();
                        if (permanent_password.equals(enter_password)) {
                            System.out.println("registered sucessfully");
                            break;
                        } else {
                            System.out.println("Wrong password! Enter again.");
                        }
                    }
                    boolean exit = true;
                    while (exit == true) {
                        System.out.print(
                                "1)Registration of new car \n2)Update car detail \n3)Serch car \n4)Add fine \n5)Remove fine \n6)Back to main menu \nEnter your choice : ");
                        String sub_Menu_choice = sc.nextLine();
                        switch (sub_Menu_choice) {
                            case "1": {
                                RTO_Registration r = new RTO_Registration();
                                r.Registration();
                            }
                                break;
                            case "2": {
                                System.out.print("Enter number plate to update detail : ");
                                String update_number_plate = sc.nextLine();
                                RTO_Update_detail u = new RTO_Update_detail();
                                u.update(update_number_plate);
                            }
                                break;
                            case "3": {
                                RTO_Search_vehicle s = new RTO_Search_vehicle();
                                s.search();
                            }
                                break;
                            case "4": {
                                System.out.print("Enter the number plate to add fine : ");
                                String number_plate = sc.nextLine();
                                RTO_Fine f = new RTO_Fine();
                                f.addfine(number_plate);
                            }
                                break;
                            case "5": {
                                System.out.println("Enter the number plate to remove the fine : ");
                                String number_plate = sc.nextLine();
                                RTO_Fine f = new RTO_Fine();
                                f.remove_fine(number_plate);
                            }
                                break;
                            case "6": {
                                exit = false;
                            }
                                break;
                            default: {
                                System.out.println("Invalid input please enter a valid input");
                            }
                                break;
                        }
                    }
                }
                    break;
                case "2": {
                    System.out.println("You registered as user");
                    RTO_Login l = new RTO_Login();
                    l.Login();
                }
                    break;
                case "3": {
                    System.out.println("Thank you :)");
                    sc.close();
                    System.exit(0);
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