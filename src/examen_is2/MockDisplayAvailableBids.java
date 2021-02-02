package examen_is2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import model.Product;
import view.DisplayProductBid;

public class MockDisplayAvailableBids implements DisplayProductBid{

    private final List<Product> productBids = new ArrayList<>();
    public MockDisplayAvailableBids() {
    }
    
    public Product getProductBid(String productName){
        for (Product productBid : productBids) {
            if(productBid.getProductName().equals(productName)) return productBid;
        }
        System.out.println("No se ha encontrado la subasta que desea.");
        return null;
    }
    
    @Override
    public void display(List<Product> productBids) {
        System.out.println("---------- Subastas disponibles ----------");
        for (Product productBid : productBids) {
            System.out.println(productBid.toString());
        }
    }
    
    @Override
    public List<Product> load(){
        productBids.add(new Product("Zapatos", "Zapatos Nike talla 45 Hombre", new BigDecimal(30), LocalDate.of(2021, Month.MARCH, 15)));
        productBids.add(new Product("Mitsubishi Montero", "Coche 4x4, Marca: Mitsubishi, 2ª Mano", new BigDecimal(3500), LocalDate.of(2021, Month.MAY, 30)));
        productBids.add(new Product("PS5", "Consola de videojuegos en perfecto estado", new BigDecimal(500), LocalDate.of(2021, Month.FEBRUARY, 15)));
        return productBids;
    }
    
}
