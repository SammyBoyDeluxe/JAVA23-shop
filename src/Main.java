import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        shop();
    }

    public static void shop() {
        // Create instances of classes
        Products mask = new Products("Mask", 235.5, 20);
        Products knife = new Products("Plastic knife", 49.5, 3);
        Sale blood = new Sale("Fake blood", 89.1, 44, 0.3);
        Customer customer = new Customer(0, 0);
        Scanner scanner = new Scanner(System.in);

        // Creates a menu for user
        while (true) {
            System.out.printf(""" 
                    -----------------------------------
                    1. %s
                    2. %s
                    3. %s
                    4. Quit
                    """,
                    mask.productInfo(),
                    knife.productInfo(),
                    blood.productInfo());
            System.out.print("Choose your option: ");

            // Takes user input and buys chosen product or breaks the program, if input is un-allowed
            // ask for new input
            int menuChoice = scanner.nextInt();
            if (menuChoice == 1) {
                customer.addToCart(mask.buy());
            } else if (menuChoice == 2) {
                customer.addToCart(knife.buy());
            } else if (menuChoice == 3) {
                customer.addToCart(blood.buy());
            } else if (menuChoice == 4) {
                customer.cartInfo();
                break;
            } else {
                System.out.println("-----------------------------------\nInvalid choice, please try again!");
            }
        }
    }
}