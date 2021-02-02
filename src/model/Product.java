package model;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private final String productName;
    private String description;
    private BigDecimal bidAmount;
    private Observer observer;
    private final List<BigDecimal> bidHistory = new ArrayList<>();;
    private final List<Observer> observers = new ArrayList<>();
    private final List<BufferedImage> photos = new ArrayList<>();
    private final LocalDate finishBidDate;

    public Product(String productNamme, String description, BigDecimal initialPrice, LocalDate finishBidDate) {
        this.productName = productNamme;
        this.description = description;
        this.bidAmount = initialPrice;
        this.finishBidDate = finishBidDate;
        bidHistory.add(bidAmount);
    }
    
    public void registerObserver(Observer observer){
        System.out.println(productName.toUpperCase() + ":Ha entrado a la subasta: " + observer);
        observers.add(observer);
    }
    
    public void removeObserver(Observer observer){
        System.out.println(productName.toUpperCase() + "Ha salido de la subasta: " + observer);
        observers.remove(observer);
    }
    
    public void notifyObservers(){
        for (Observer obs : observers) {
            obs.update(observer, productName, bidAmount);
        }
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Observer observer, BigDecimal newBidAmount) {
        if(bidAmount.compareTo(newBidAmount) == -1){
            this.bidAmount = newBidAmount;
            this.observer = observer;
            addNewBidAmount(bidAmount);
            notifyObservers();
        } else {
            System.out.println(observer + ", la nueva oferta (" + newBidAmount.toString() +
                    "€) no puede ser menor o igual que la oferta actual: " + bidAmount);
        }
    }

    public LocalDate getFinishBidDate() {
        return finishBidDate;
    }

    public List<BigDecimal> getBidHistory() {
        return bidHistory;
    }

    public List<BufferedImage> getPhotos() {
        return photos;
    }
    
    public String visualizePhotos(){
        String res = "";
        for (BufferedImage photo : photos) {
            res += photo.toString() + " ";
        }
        return res;
    }
    
    public void addImage(BufferedImage image){
        photos.add(image);
    }
    
    public void removeImage(BufferedImage image){
        photos.remove(image);
    }
    
    public void addNewBidAmount(BigDecimal newBidAmount){
        bidHistory.add(newBidAmount);
    }
    
    public String readBidHistory(){
        String res = "";
        for (BigDecimal bigDecimal : bidHistory) {
            res += " " + bigDecimal.toString() + "€,";
        }
        return res;
    }

    @Override
    public String toString() {
        return "Product{ productName = " + productName + ", description = " + description + ", initialPrice = " + bidHistory.get(0) + ", finishBidDate = " + finishBidDate 
                + '\n' + "bidHistory =" + readBidHistory() + " photos = " + visualizePhotos() + "}";
    }
    
    public interface Observer {
        public void update(Observer observer, String productName, BigDecimal bidAmount);
    }
    
}
