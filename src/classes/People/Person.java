package classes.People;

import classes.interfaces.Identifiable;
import classes.interfaces.Printable;
import classes.projects.Project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public abstract class Person implements Printable, Identifiable {
    protected String type;
    private static int globalId = 0;
    protected int id;
    public String name;
    public String lastName;
    protected String country;
    LocalDate BDay;
    protected ArrayList<Project> projects;
    protected String password;

    public Person(String name, String lastName, String country, LocalDate BDay, String password) {
        setId();
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.BDay = BDay;
        this.password = password;
    }
    public Person(String name, String lastName, String country, LocalDate BDay, String password, ArrayList<Project> project) {
        setId();
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.BDay = BDay;
        this.projects = project;
        this.password = password;
    }
    public static int getGlobalId() {
        return globalId;
    }
    @Override
    public final int getId() {
        return id;
    }
    public ArrayList<Project> getProject() {
        return projects;
    }

    //START SETTERS
    private static void setGlobalId() {
        Person.globalId++;
    }
    @Override
    public final void setId() {
        int value = getGlobalId();
        this.id = value++;
        setGlobalId();
    }

    public void setProject(Project project) {
        if (!projects.contains(project)){
            this.projects.add(project);
        }
    }
    //END SETTER
    public static boolean signIn(){
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Name");
//        String pass = keyboard.next();
//        System.out.println(pass);
//        Global.LogIn = true;
        //TODO sign in checking with some kind of array of registered users
        return true;
    }
    public static boolean logIn(String name, String password){
        //TODO log in
        return  true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() &&
                type.equals(person.type) &&
                name.equals(person.name) &&
                lastName.equals(person.lastName) &&
                country.equals( person.country) &&
                BDay.equals(person.BDay) &&
                projects.equals(person.projects);
    }

    @Override
    public int hashCode() {
        return 21 * getId() + type.hashCode() + name.hashCode() + lastName.hashCode() + country.hashCode() + BDay.hashCode() + projects.hashCode();
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
                '}';

//                ", project=" + ArraysList.toString(projects) +
//                '}';
    }
}
