package control;

import model.Bidder;
import model.Product;

public class RegisterBidderCommand implements Command{
    private final Bidder bidder;
    private final Product product;

    public RegisterBidderCommand(Bidder bidder, Product product) {
        this.bidder = bidder;
        this.product = product;
    }
    
    @Override
    public void execute() {
        product.registerObserver(bidder);
    }
    
}
