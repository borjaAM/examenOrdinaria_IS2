package control;

import java.math.BigDecimal;
import model.Bidder;
import model.Product;

public class SetNewBidAmountCommand implements Command{
    private final Bidder bidder;
    private final Product product;
    private final BigDecimal newBidAmount;

    public SetNewBidAmountCommand(Bidder bidder, Product product, BigDecimal newBidAmount) {
        this.bidder = bidder;
        this.product = product;
        this.newBidAmount = newBidAmount;
    }
    
    @Override
    public void execute() {
        product.setBidAmount(bidder, newBidAmount);
    }
    
}
