package classes.People;

import classes.projects.Project;
import java.util.Date;

public class Client extends Person{
    boolean isEnterprise;
    int amountOfProjects;
    public Client(String name, String lastName, String country, Date BDay, boolean enterprise) {
        super(name, lastName, country, BDay);
        super.type = getClass().toString().split("\\.")[2];
        this.isEnterprise = enterprise;
        this.amountOfProjects = 0;
    }
    public Client(String name, String lastName, String country, Date BDay, Project[] project, boolean enterprise) {
        super(name, lastName, country, BDay, project);
        super.type = getClass().toString().split("\\.")[2];
        this.isEnterprise = enterprise;
        this.amountOfProjects = 0;
    }
}
