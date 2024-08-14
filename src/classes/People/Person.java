package classes.People;

import classes.projects.Project;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public abstract class Person {
    protected String type;
    private static int globalId = 0;
    protected int id;
    String name;
    String lastName;
    protected String country;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                Objects.equals(type, person.type) &&
                Objects.equals(name, person.name) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(country, person.country) &&
                Objects.equals(BDay, person.BDay) &&
                Objects.deepEquals(project, person.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, getId(), name, lastName, country, BDay, Arrays.hashCode(project));
    }

    @Override
    public String toString() {
        return "Person{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", BDay=" + BDay +
                ", project=" + Arrays.toString(project) +
                '}';
    }
}
