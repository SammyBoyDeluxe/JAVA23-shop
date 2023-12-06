import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        shop();
    }

    public static void shop() {
        // Create instances of classes
        Products mask = new Products("Mask", 235.5, 20);
        Products knife = new Products("Plastic knife", 49.5, 3);
        DiscountedProduct blood = new DiscountedProduct("Fake blood", 89.1, 44, 0.3);
        Customer customer = new Customer();
        Scanner scanner = new Scanner(System.in);
        /*While true is unbreakable and therefore not advised. We should couple a boolean to the exit phrase

        Definite nice touch with the .productInfo() and the formatting!
         */
        /*Before session has started sessionEnded is always false*/
        boolean sessionEnded = false;
        // Creates a menu for user
        while (!sessionEnded) {
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
            /*Code definitely does the job! Instead of multiple else ifs we could have a switch-case. Default is tried last and
            is all cases not described
             */
            // Takes user input and buys chosen product or breaks the program, if input is un-allowed
            // ask for new input
            int menuChoice = scanner.nextInt();
            switch (menuChoice){
                case 1 : customer.addToCart(mask);break;
                case 2 : customer.addToCart(knife); break;
                case 3 : customer.addToCart(blood); break;
                case 4 : sessionEnded = true; break;
                default : System.out.println("-----------------------------------\nInvalid choice, please try again!"); break;



            }

        }
        /*When session has ended we checkout the cart and print the totals of the session*/
        customer.checkoutCart();
    }
}