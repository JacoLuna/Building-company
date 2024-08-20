package classes.projects;

import java.util.Date;

public class Bill {
    Project project;
    Product[] products;
    int[] amountOfProducts;
    Date date;
    long budget;

    public Bill(Project project, Product[] products,int[] amountOfProducts, Date date) {
        this.project = project;
        this.products = products;
        this.amountOfProducts = amountOfProducts;
        for (int i = 0; i < products.length; i++) {
            budget += (long) (products[i].price * amountOfProducts[i]);
        }
        this.date = date;
    }
}
