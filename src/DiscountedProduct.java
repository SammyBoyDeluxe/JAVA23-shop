/*Good use of inheritance structure since a product on sale is a product. However naming could
possibly be changed from "Sale" to something like "DiscountedProduct" || "ProductOnSale" which
 more accurately mirrors the object role*/
public class DiscountedProduct extends Products {
    /*DISCOUNT doesn´t need to be a constant. Reflecting that products can change in discount. For clarity "discount" -> "discountPercentage
    This also better reflects my interpretation of the newPrice()-method which should able to be called to dynamically update prices.
    Understand this is a later implementation-step so will leave the newPrice() as private in current structure of program
     */
    private double discountPercentage;
    /*This gives the money saved / unit of this discounted product*/
    private double moneySaved;
    /*The variable name discount is then changed to discountPercentageIn, clarifying that it´s a percentage and that it´s an inparameter.
    Done on all inparameters. Public is also added to DiscountedProduct to define scope
     */
    // Constructor runs newPrice when instance is created
    public DiscountedProduct(String nameIn, double priceIn, int amountInStockIn, double discountPercentageIn) {
        /**/
        super(nameIn, priceIn, amountInStockIn);
        this.discountPercentage = discountPercentageIn;
        this.moneySaved = discountPercentageIn*priceIn;
        /*This helps us see if we can downcast specific instances of product*/
        this.isDiscounted = true;
        newPrice();
    }
    /*Coding standard in java is generally that methods follow ARNI (Access Modifier)(ReturnType)(methodName)(InParameters). Currently it´s unspecified
    which works! However to always match required scopes to Methods, attributes etc Access modifier is encouraged. Also key in proper encapsulation!
    This method (newPrice()) is only called inside DiscountedProduct.this so we set AcMod to private.
    I also had some issues in understanding that the setPrice and getPrice was inherited and thought you forgot to write the methods.
    Small cosmetic change to clarify that would be adding super. so we add that!

     */
    // Changes the price to match discount
    private void newPrice() {
        super.setPrice(super.getPrice() * (1- discountPercentage));
        }

        /*We implement a getter to access the moneySaved for each DiscountedProduct object*/

    public double getMoneySaved() {
        return moneySaved;
    }
}