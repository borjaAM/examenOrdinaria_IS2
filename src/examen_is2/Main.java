package examen_is2;

import control.Command;
import control.RegisterBidderCommand;
import control.SetNewBidAmountCommand;
import java.math.BigDecimal;
import model.Bidder;
import model.Product;


public class Main {
    
    public static void main(String[] args) {
        new Main().execute();
    }

    private void execute() {
        MockDisplayAvailableBids availableBids = new MockDisplayAvailableBids();
        availableBids.display(availableBids.load());
        Bidder juan = new Bidder("Juan");
        Bidder pepe = new Bidder("Pepe");
        Bidder maria = new Bidder("María");
        
        registerBidder(juan, availableBids.getProductBid("Zapatos"));
        registerBidder(pepe, availableBids.getProductBid("Zapatos"));
        registerBidder(maria, availableBids.getProductBid("Zapatos"));
        
        setNewBid(juan, availableBids.getProductBid("Zapatos"), new BigDecimal(35));
        System.out.println("-----------------------------------------");
        setNewBid(pepe, availableBids.getProductBid("Zapatos"), new BigDecimal(45));
        System.out.println("-----------------------------------------");
        setNewBid(maria, availableBids.getProductBid("Zapatos"), new BigDecimal(45));
        System.out.println("-----------------------------------------");
        System.out.println(availableBids.getProductBid("Zapatos").toString());
        
    }
    
    private void registerBidder(Bidder bidder, Product product){
        Command registerBidderCommand = new RegisterBidderCommand(bidder, product);
        registerBidderCommand.execute();
    }

    private void setNewBid(Bidder bidder, Product product, BigDecimal newBidAmount) {
        Command setNewBidAmountCommand = new SetNewBidAmountCommand(bidder, product, newBidAmount);
        setNewBidAmountCommand.execute();
    }
    
}
