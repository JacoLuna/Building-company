package classes.projects;

import classes.interfaces.Taxable;

import java.util.Date;

public class Bill implements Taxable {
    Project project;
    Product[] products;
    int[] amountOfProducts;
    Date date;
    long price;

    public Bill(Project project, Product[] products,int[] amountOfProducts, Date date) {
        this.project = project;
        this.products = products;
        this.amountOfProducts = amountOfProducts;
        for (int i = 0; i < products.length; i++) {
            price += (long) (products[i].price * amountOfProducts[i]);
        }
        this.date = date;
    }
    @Override
    public float getTaxValue() {
        return price * tax;
    }
}
