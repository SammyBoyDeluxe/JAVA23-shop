public class Sale extends Products {
    private final double DISCOUNT;

    // Constructor runs newPrice when instance is created
    Sale(String name, double price, int amountInStock, double discount) {
        super(name, price, amountInStock);
        this.DISCOUNT = discount;
        newPrice();
    }

    // Changes the price to match discount
    void newPrice() {
        setPrice(getPrice() * (1-DISCOUNT));
        }
    }