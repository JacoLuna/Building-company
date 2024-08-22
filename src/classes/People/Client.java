package classes.People;

import classes.interfaces.Updatable;
import classes.projects.Project;
import java.util.Date;

public class Client extends Person implements Updatable<Client> {
    boolean isEnterprise;
    int amountOfProjects;
    public Client(String name, String lastName, String country, Date BDay, boolean enterprise, String password) {
        super(name, lastName, country, BDay, password);
        super.type = getClass().toString().split("\\.")[2];
        this.isEnterprise = enterprise;
        this.amountOfProjects = 0;
    }
    public Client(String name, String lastName, String country, Date BDay, Project[] project, boolean enterprise, String password) {
        super(name, lastName, country, BDay, password, project);
        super.type = getClass().toString().split("\\.")[2];
        this.isEnterprise = enterprise;
        this.amountOfProjects = 0;
    }

    @Override
    public String printInformation() {
        return "";
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
}
