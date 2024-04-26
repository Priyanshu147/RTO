import java.util.*;

public class password_verify {
    String userName, password;
    String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    String captchaText;
    Scanner sc = new Scanner(System.in);

  public  String login() {
        System.out.println();
        System.out.println("Here Some Rules For Creating Password");
        passwordRules();
        System.out.print("Enter Your Password : ");
        password = sc.nextLine();

        while (true) {
            boolean flag = checkPassword(password);
            if (!flag) {
                System.out.print("Sorry! Your Password Is Not Valid.\nEnter Valid Password: ");
                password = sc.nextLine();
            } else {
                System.out.println("Ok!!  Your password is Set\n");
                System.out.println();
                System.out.print("Remember Your Password!! This Will Help You To Login");
                System.out.println();
                break;
            }
        }
        System.out.println();
        
        
        return password;
    }

    void passwordRules() {
        System.out.println("-->1. Length: Passwords should be at least 8 characters long. ");
        System.out.println("-->2. Passwords should include a mix of upper and lowercase letters.");
        System.out.println("-->3. Passwords should include a numbers. and special characters. ");
        System.out.println("-->4. Passwords should include a special characters.");
        System.out.println();
    }

    boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasSpecialChar = false;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (password.contains("#") || password.contains("!") || password.contains("@")
                    || password.contains("$") || password.contains("%") || password.contains("^")
                    || password.contains("&") || password.contains("*")) {
                hasSpecialChar = true;
            }
        }
        return (hasUppercase && hasLowercase && hasDigit && hasSpecialChar);
    }

    

}

