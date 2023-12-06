public class Products {

    private final String NAME;
    private double price;
    private int amountInStock;
    /*Access modifier 'protected': We can access the property inside this class and its childclasses*/
    protected boolean isDiscounted = false;

    public Products(String name, double price, int amountInStock) {
        this.NAME = name;
        this.price = price;
        this.amountInStock = amountInStock;
    }

    // Getters and setters used in Sale.java
    public double getPrice() {
        return price;
    }

    // Ensures that price doesn't have a negative value, if it has, set it to 0
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    // Creates method productInfo which contains information about the product
    String productInfo() {
        return String.format("%s, %.2f SEK, %d left", NAME, price, amountInStock);
    }

    // Creates method buy which removes one item from the stocks each time it's bought until its zero
    // Returns the price which is then used in Customer.addToCart
    double buy(){
        if (amountInStock < 1) {
            System.out.println("-----------------------------------");
            System.out.printf("%s is out of stock.\n", NAME);
            return -1;
        } else {
            amountInStock--;
            return price;
        }
    }

    /*We implement a getter to see if the specific object is a DiscountedProduct*/

    public boolean isDiscounted() {
        return isDiscounted;
    }
}