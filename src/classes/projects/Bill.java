package classes.projects;

import java.util.Date;

public class Bill {
    Project project;
    Product[] products;
    Date date;

    public Bill(Project project, Product[] products, Date date) {
        this.project = project;
        this.products = products;
        this.date = date;
    }
}
