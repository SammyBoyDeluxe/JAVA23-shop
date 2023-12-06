public class Customer {
    /*Appropriately named class, good attributes. Logically reflects how a //customer// buys products, it´s not an inventory program*/
    private int amountOfProducts;
    private double totalPrice;
    /*This attribute betters the logical representation of a shop*/
    private Products[] productsInCart;

    /*Define scope of constructor from undefined to public. Took away inParameters since they should implicitly be 0*/
    public Customer() {
        /*this. is very clear and separates inputValues and attributes
        this.amountOfProducts = amountOfProducts;
        this.totalPrice = totalPrice;

        **I´ll change the syntax to match the syntax used for the other constructors with "..In".
        One could argue that when a customer is constructed that it has no totalPrice yet, unless we account for debt.
       -> totalPrice should be implicitly set to 0, totalPrice = 0; when a customer object is made.
       The same argument holds true for amountOfProducts, when a customer enters no amount of products have been bought

       **Comment not current, was when constructor had inparameters
        */

         this.totalPrice = 0;
         this.amountOfProducts = 0;
         /*Hardcoded in total amount in store, could be dynamically updated*/
         productsInCart = new Products[67];
    }
    /*Good, clear comment! Also very reasonable to have price as an inParameter since the amount we want to add depends on outside factors
    Further we clearly define the scope.
    If the method is called addToCart, logically what should be added to it is a product. There we can get the price.
     */
    // When function is called, add the price of product and increase amountOfProducts by one
    public void addToCart(Products wantedProduct) {


            /*Good use of +=*/
            amountOfProducts += 1;
            totalPrice += wantedProduct.getPrice();
            /*The amount of products is the length of the product array so far*/
            productsInCart[amountOfProducts-1] = wantedProduct;

    }
    /*Good method! Also nice that we can get cart-info and print! However maybe we should reflect the cart better by
    letting a customer have a collection of Products that´s in the cart. We could then print their names, prices and even
    amount saved via DiscountedProduct
    We also explicitly define scope. We also improve by specifying the methodname from "cartInfo" to
    checkoutCart() since we use it to complete a purchase.
    To not fuck around too much and implement abstract stuff I just input a boolean inside product "isDiscounted" which for all
    regular instances is false and for discountedProducts true.

    Nice touch with the formatting with printf();




     */
    // Prints information about users shopping cart
    public void checkoutCart() {
        double totalAmountSaved = 0;
        for(int i = 0 ; i < amountOfProducts ; i++){
             if(productsInCart[i].isDiscounted()){
                 DiscountedProduct discountedProduct = (DiscountedProduct) productsInCart[i];
                 totalAmountSaved +=discountedProduct.getMoneySaved();
             }


        }
        System.out.printf("\nYou purchased a total of %d items. The total cost was %.2f SEK. You saved %.2f SEK\n",
                amountOfProducts, totalPrice,totalAmountSaved);
        }
    }