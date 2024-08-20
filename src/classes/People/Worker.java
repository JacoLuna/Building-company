package classes.People;

import classes.projects.Project;

import java.util.Date;

public class Worker extends Person{
    int salary;
    String experience;
    public Worker(String name, String lastName, String country, Date BDay, int salary, String experience, String password) {
        super(name, lastName, country, BDay, password);
        super.type = getClass().toString().split("\\.")[2];
        this.salary = salary;
        this.experience = experience;
    }

    public Worker(String name, String lastName, String country, Date BDay, int salary, String experience, Project[] project, String password) {
        super(name, lastName, country, BDay, password, project);
        super.type = getClass().toString().split("\\.")[2];
        this.salary = salary;
        this.experience = experience;
    }
}
