package classes.People;

import classes.interfaces.IHasProjects;
import classes.projects.Project;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;

public class Client extends Person implements IHasProjects {
    boolean isEnterprise;
    int amountOfProjects;
    public Client(String name, String lastName, String country, LocalDate BDay, boolean enterprise, String password) {
        super(name, lastName, country, BDay, password);
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

    @Override
    public LinkedList<Project> getProjects() {
        return null;
    }

    @Override
    public void addProject(Project project) {

    }

    @Override
    public void removeProject(Project project) {

    }

    @Override
    public void removeProject(Integer projectIndex) {

    }

    @Override
    public Project getProject(Integer projectIndex) {
        return null;
    }

    @Override
    public int getProject(Project project) {
        return 0;
    }

    @Override
    public void setProject(int projectIndex, Project project){
        if (!getProject(projectIndex).equals(project)){
            projects.set(projectIndex, project);
        }else {
            //TODO project exception msg
        }
    }

    @Override
    public void clearProjects(){}

}
