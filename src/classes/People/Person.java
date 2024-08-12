package classes.People;

import classes.projects.Project;

import java.util.Date;

public class Person {
    protected String type;
    private static int globalId = 0;
    private int id;
    String name;
    String lastName;
    String country;
    Date BDay;
    protected Project[] project;

    public Person(String name, String lastName, String country, Date BDay) {
        setId();
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.BDay = BDay;
    }
    public Person(String name, String lastName, String country, Date BDay, Project[] project) {
        setId();
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.BDay = BDay;
        this.project = project;
    }
    public static int getGlobalId() {
        return globalId;
    }
    public int getId() {
        return id;
    }
    private static void setGlobalId() {
        Person.globalId++;
    }
    public void setId() {
        int value = getGlobalId();
        this.id = value++;
        setGlobalId();
    }

    public void printInformation(){
        System.out.println(getId() + " type " + type + " name " + name + " lastName " + lastName + " country " + country + " BDay " + BDay);
    }
}
