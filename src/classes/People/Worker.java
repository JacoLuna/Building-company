package classes.People;

import classes.interfaces.Updatable;
import classes.projects.Project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Worker extends Person implements Updatable<Worker> {
    int salary;
    String experience;
    public Worker(String name, String lastName, String country, LocalDate BDay, int salary, String experience, String password) {
        super(name, lastName, country, BDay, password);
        super.type = getClass().toString().split("\\.")[2];
        this.salary = salary;
        this.experience = experience;
    }

    public Worker(String name, String lastName, String country, LocalDate BDay, int salary, String experience, ArrayList<Project> projects, String password) {
        super(name, lastName, country, BDay, password, projects);
        super.type = getClass().toString().split("\\.")[2];
        this.salary = salary;
        this.experience = experience;
    }

    @Override
    public String printInformation() {
        return "name: " + name +
                "lastName: " + lastName +
                "country: " + country +
                "BDay: " + BDay +
                "salary: " + salary +
                "experience " + experience;
    }

    @Override
    public void update(Worker data) {
        this.name = data.name;
        this.lastName = data.lastName;
        this.country = data.country;
        this.BDay = data.BDay;
        this.salary = data.salary;
        this.experience = experience;
        this.password = data.password;
    }
}
