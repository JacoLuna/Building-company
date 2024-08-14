package classes.People;

import classes.projects.Project;

import java.util.Date;

public class Worker extends Person{
    int salary;
    String experience;
    public Worker(String name, String lastName, String country, Date BDay, int salary, String experience) {
        super(name, lastName, country, BDay);
        super.type = getClass().toString().split("\\.")[2];
        this.salary = salary;
        this.experience = experience;
    }

    public Worker(String name, String lastName, String country, Date BDay, int salary, String experience, Project[] project) {
        super(name, lastName, country, BDay, project);
        super.type = getClass().toString().split("\\.")[2];
        this.salary = salary;
        this.experience = experience;
    }
}
