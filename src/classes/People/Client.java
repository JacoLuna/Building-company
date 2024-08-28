package classes.People;

import classes.interfaces.Updatable;
import classes.projects.Project;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Client extends Person implements Updatable<Client> {
    boolean isEnterprise;
    int amountOfProjects;
    public Client(String name, String lastName, String country, LocalDate BDay, boolean enterprise, String password) {
        super(name, lastName, country, BDay, password);
        super.type = getClass().toString().split("\\.")[2];
        this.isEnterprise = enterprise;
        this.amountOfProjects = 0;
    }
    public Client(String name, String lastName, String country, LocalDate BDay, ArrayList<Project> projects, boolean enterprise, String password) {
        super(name, lastName, country, BDay, password, projects);
        super.type = getClass().toString().split("\\.")[2];
        this.isEnterprise = enterprise;
        this.amountOfProjects = 0;
    }

    @Override
    public String printInformation() {
        return "name: " + name +
                "lastName: " + lastName +
                "country: " + country +
                "BDay: " + BDay +
                "enterprise: " + ((isEnterprise)?"yes":"no");
    }
    @Override
    public void update(Client data) {
        this.name = data.name;
        this.lastName = data.lastName;
        this.country = data.country;
        this.BDay = data.BDay;
        this.isEnterprise = data.isEnterprise;
        this.amountOfProjects = data.amountOfProjects;
        this.password = data.password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "isEnterprise=" + isEnterprise +
                ", amountOfProjects=" + amountOfProjects +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", BDay=" + BDay +
                ", password='" + password + '\'' +
                '}';
    }
//                ", project=" + projects.toString() +
}
