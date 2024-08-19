package classes.projects;

import java.util.Date;
import java.util.Objects;

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
    public Product(String name, float stock, float stockPoint, float price) {
        this.name = name;
        this.expirationDate = null;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Float.compare(getStock(), product.getStock()) == 0 &&
                Float.compare(getStockPoint(), product.getStockPoint()) == 0 &&
                Float.compare(price, product.price) == 0 &&
                Objects.equals(name, product.name) && Objects.equals(expirationDate, product.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expirationDate, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", expirationDate=" + expirationDate +
                ", stock=" + stock +
                ", stockPoint=" + stockPoint +
                ", price=" + price +
                '}';
    }
}
