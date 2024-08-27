package classes.projects;

import classes.interfaces.Taxable;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Product implements Taxable {
    String name;
    LocalDate expirationDate;
    private float stock;
    private float stockPoint;
    float price;

    public Product(String name, LocalDate expirationDate, float stock, float stockPoint, float price) {
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
        return getStock() == product.getStock() &&
                getStockPoint() == product.getStockPoint() &&
                price == product.price &&
                name.equals(product.name) &&
                expirationDate.equals(product.expirationDate);
    }

    @Override
    public int hashCode() {
        return 21 * name.hashCode() + expirationDate.hashCode() + (int)price;
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

    @Override
    public float getTaxValue() {
        return price * tax;
    }
}
