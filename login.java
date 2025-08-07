import java.util.*;
import java.io.*;

class usersDC {
    String name, pass;
}

public class login {
    static Scanner input = new Scanner(System.in);
    static String REGISname = "";
    static List<usersDC> usersD = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            int choice;
            System.out.println("\n================");
            System.out.println("\n[   WELCOME   ]");
            System.out.println("\n================");
            System.out.println("\n1. Registration");
            System.out.println("\n2. Login");
            System.out.println("\n3. Exit");
            System.out.print("\nEnter: ");
            try {
                choice = Integer.parseInt(input.nextLine());
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
                exit();
                return;
                default:
                for (int i = 0; i < 3; i++) {
                    System.out.println("\n[PLEASE ENTER A VALID INPUT]");
                }
            }
        }
    }

    public static void REGIS() {
        usersDC users = new usersDC();
        System.out.println("\n[REGISTRATION]");
        System.out.print("\nEnter your full name: ");
        users.name = input.nextLine();
        System.out.print("\nCreate your password: ");
        users.pass = input.nextLine();
        usersD.add(users);
        SAVEDFILES();
        System.out.println("\n[REGISTRATION SUCCESSFUL]");
    }

    public static void LOGIN() {
        while (true) {
            String LOGINname, LOGINpass;
            boolean USERHANDLING = false, PASSHANDLING = false;
            System.out.println("\n[LOGIN]");
            System.out.print("\nEnter your full name: ");
            LOGINname = input.nextLine();
            System.out.print("\nEnter your password: ");
            LOGINpass = input.nextLine();
            for (usersDC users : usersD) {
                if (users.name.equalsIgnoreCase(LOGINname)) {
                    USERHANDLING = true;
                if (users.pass.equalsIgnoreCase(LOGINpass)) {
                    PASSHANDLING = true;
                    System.out.println("\n[LOGIN SUCCESSFUL]");
                    REGISname = users.name;
                    HOMESCR();
                    return;
                } break;
              }
            } if (!USERHANDLING) {
                for (int i = 0; i < 3; i++) {
                    System.out.println("\n[USER NOT FOUND]");
                }
            } else if (!PASSHANDLING) {
                for (int i = 0; i < 3; i++) {
                    System.out.println("\n[INCORRECT INPUT]");
                }
            }
        }
    }

    public static void HOMESCR() {
        System.out.println("\n[WELCOME " + REGISname + " ]");
        System.out.println("\nPLEASE CLICK ENTER TO GO BACK");
        input.nextLine();
    }

    public static void exit() {
        System.out.println("\n[THANK YOU FOR USING!]");
    }

    public static void SAVEDFILES() {
        try (PrintWriter receiver = new PrintWriter("users.txt")) {
            for (usersDC users : usersD) {
                receiver.println("NAME: " + users.name);
                receiver.println("PASSWORD: " + users.pass);
            }
        } catch (IOException e) {
            for (int i = 0; i < 3; i++) {
                System.out.println("\n[ERROR]");
            }
        }
    }
}