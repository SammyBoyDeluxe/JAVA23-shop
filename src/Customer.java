public class Customer {

    private int amountOfProducts;
    private double totalPrice;

    Customer(int amountOfProducts, double totalPrice) {
        this.amountOfProducts = amountOfProducts;
        this.totalPrice = totalPrice;
    }

    // When function is called, add the price of product and increase amountOfProducts by one
    void addToCart(double price) {
        // the if-statement ensures that no item that is out of stock is added to the cart
        if (price >= 0) {
            amountOfProducts += 1;
            totalPrice += price;
        }
    }

    // Prints information about users shopping cart
    void cartInfo() {
        System.out.printf("\nYou purchased a total of %d items. The total cost was %.2f SEK\n",
                amountOfProducts, totalPrice);
        }
    }