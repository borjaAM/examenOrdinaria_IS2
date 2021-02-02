package view;

import java.util.List;
import model.Product;

public interface DisplayProductBid {
    void display(List<Product> product);
    List<Product> load();
}
