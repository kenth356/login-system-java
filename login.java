// Log-in System in Java
// Mariano, Kenth Jarren S.

import java.util.*;
import java.io.*;

class UserDC {
    String name;
    String passw;

    public UserDC(String name, String passw) {
        this.name = name;
        this.passw = passw;
    }
}

public class login {
    static List<UserDC> usersD = new ArrayList<>();
    static String REGISname = "";
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("\n\n" + String.format("%75s", "================================"));
            System.out.println(String.format("%66s", "[   WELCOME   ]"));
            System.out.println(String.format("%75s", "================================"));
            System.out.println("\n" + String.format("%86s", "1. Registration           2. Log in          3. Exit"));
            System.out.println(String.format("%89s", "----------------------------------------------------------"));
            System.out.print("\n\n" + String.format("%39s", "Enter: "));
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }
            switch (choice) {
                case 1:
                REGIS();
                break;
                case 2:
                LOGIN();
                break;
                case 3:
                EXIT();
                return;
                default:
                System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
                System.out.println("\n" + String.format("%76s", "[  PLEASE ENTER A CORRECT INPUT  ]"));
                System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
            }
        }
    }

    public static void REGIS() {
        String REGname, REGpassw;
        System.out.println("\n\n" + String.format("%75s", "==============================="));
        System.out.println(String.format("%68s", "[  REGISTRATION  ]"));
        System.out.println(String.format("%75s", "==============================="));
        System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
        System.out.print("\n" + String.format("%54s", "Enter your full name: "));
        REGname = scanner.nextLine();
        System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
        System.out.print("\n" + String.format("%54s", "Create your password: "));
        REGpassw = scanner.nextLine();
        usersD.add(new UserDC(REGname, REGpassw));
        SAVEDFILES();
        System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
        System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
        System.out.println(String.format("%74s", "[  REGISTRATION SUCCESSFUL  ]"));
        System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
    }

    public static void LOGIN() {
        while (true) {
            String LOGINname, LOGINpass;
            boolean USERHANDLING, PASSHANDLING;
            LOGINname = "";
            LOGINpass = "";
            USERHANDLING = false;
            PASSHANDLING = false;
            System.out.println("\n\n" + String.format("%75s", "==============================="));
            System.out.println(String.format("%66s", "[  LOG - IN  ]"));
            System.out.println(String.format("%75s", "==============================="));
            System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
            System.out.print("\n" + String.format("%54s", "Enter your full name: "));
            LOGINname = scanner.nextLine();
            System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
            System.out.print("\n" + String.format("%54s", "Enter your password: "));
            LOGINpass = scanner.nextLine();
            System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
            for (UserDC user : usersD) {
                if (user.name.equals(LOGINname)) {
                    USERHANDLING = true;
                    if (user.passw.equals(LOGINpass)) {
                        PASSHANDLING = true;
                        System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
                        System.out.println("\n" + String.format("%72s", "[  LOG - IN SUCCESSFUL  ]"));
                        System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
                        REGISname = user.name;
                        HOMESCR();
                        return;
                    }
                    break;
                }
            }

            if (!USERHANDLING) {
                System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
                System.out.println("\n" + String.format("%70s", "[  USER NOT FOUND  ]"));
                System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
            } else if (!PASSHANDLING) {
                for (int i = 0; i < 3; i++) {
                    System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
                    System.out.println("\n" + String.format("%71s", "[  INCORRECT INPUT  ]"));
                    System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
                }
            }
        }
    }

    public static void HOMESCR() {
        while (true) {
            int choice;
            System.out.println("\n\n" + String.format("%82s", "============================================"));
            System.out.println(String.format("%73s", "[  WELCOME  " + REGISname + " ]"));
            System.out.println(String.format("%82s", "============================================"));
            System.out.println("\n" + String.format("%48s", "1. Return"));
            System.out.println(String.format("%88s", "--------------------------------------------------------"));
            System.out.print("\n\n" + String.format("%39s", "Enter: "));
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1;
            }
            if (choice == 1) {
                return;
            } else {
                System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
                System.out.println("\n" + String.format("%76s", "[  PLEASE ENTER A CORRECT INPUT  ]"));
                System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
            }
        }
    }

    public static void EXIT() {
        System.out.println("\n\n" + String.format("%88s", "--------------------------------------------------------"));
        System.out.println("\n" + String.format("%67s", "[  THANK YOU  ]"));
        System.out.println("\n" + String.format("%88s", "--------------------------------------------------------"));
    }

    public static void SAVEDFILES() {
        try (FileWriter file = new FileWriter("users.txt")) {
            for (UserDC user : usersD) {
                file.write("NAME: " + user.name + "\nPASSWORD: " + user.passw + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}
