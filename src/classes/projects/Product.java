package classes.projects;

import java.util.Date;

public class Product {
    String name;
    Date expirationDate;
    private float stock;
    private float stockPoint;
    float price;

    public Product(String name, Date expirationDate, float stock, float stockPoint, float price) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.stock = stock;
        this.stockPoint = stockPoint;
        this.price = price;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        if (stock > 0){
            this.stock = stock;
        }
    }

    public float getStockPoint() {
        return stockPoint;
    }

    public void setStockPoint(float stockPoint) {
        if (stockPoint > 0){
            this.stockPoint = stockPoint;
        }
    }
}
