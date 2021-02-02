package model;

import java.math.BigDecimal;

public class Bidder implements Product.Observer{
    private final String name;

    public Bidder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Product.Observer observer, String productName, BigDecimal bidAmount) {
        if(observer.toString().equals(name)){
            System.out.println("Hola " + name + ", has efectuado una oferta de " + bidAmount
            + "€ por el producto: " + productName);
        } else {
            System.out.println("Hola " + name + ", el usuario " + observer
                    + " ha efectuado una nueva puja de " + bidAmount
                    + "€ por el producto: " + productName);
        }
    }
    
    
}
