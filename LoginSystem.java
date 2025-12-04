import java.util.Scanner;

public class LoginSystem {

    // pakai scanner kiriman dari Main
    static String start(Scanner sc) {

        while (true) {
            System.out.println("=== LOGIN ===");
            System.out.print("Email: ");
            String email = sc.nextLine().trim();

            System.out.print("Password: ");
            String pass = sc.nextLine().trim();

            User u = InitData.cariUser(email);

            if (u != null && u.getPassword().equals(pass)) {
                System.out.println("Login berhasil!\n");
                return email;
            }

            System.out.println("Login salah!\n");
        }
    }
}