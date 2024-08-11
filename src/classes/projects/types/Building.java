package classes.projects.types;

import classes.Persons.Person;
import enums.ProjectType;

public class Building {

    private static int globalId = 0;
    private int id;
    ProjectType name;
    long squareMeters;

    public Building(ProjectType name, long squareMeters) {
        this.name = name;
        this.squareMeters = squareMeters;
    }
    public static int getGlobalId() {
        return globalId;
    }
    public int getId() {
        return id;
    }
    private static void setGlobalId() {
        Building.globalId++;
    }
    public void setId() {
        int value = getGlobalId();
        this.id = value++;
        setGlobalId();
    }
}
