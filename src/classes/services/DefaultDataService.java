package classes.services;

import classes.People.Client;
import classes.People.Person;
import classes.People.Worker;
import classes.projects.Product;
import classes.projects.Project;
import classes.projects.types.*;
import enums.TypeOfProject;
import enums.TypeOfSoil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DefaultDataService {
    static Person[] clients = new Client[5];
    static Person[] workers = new Worker[5];
    static ArrayList<Structure> structures;
    static ArrayList<Product> products;
    static ArrayList<Project> projects;

    public void instantiateAll(){
        createClients();
        products = createProducts();
        createWorkers();
        structures = createStructures();
        projects = createProjects();
    }
    public void createClients(){
        for (int i = 0; i < 5; i++) {
            clients[i] = new Client("clients_name_" + i,"clients_lastName_" + i,"clients_country_" + i, LocalDate.of(1990, 8, 5),false, "1234");
        }
    }
    public void createWorkers(){
        for (int i = 0; i < 5; i++) {
            workers[i] = new Worker("worker_name_" + i,"worker_lastName_" + i,"worker_country_" + i, LocalDate.of(1990, 8, 5), 1500 ,"junior", "1234");
        }

    }
    public ArrayList<Structure> createStructures(){
        return new ArrayList<Structure>(){{
            add(new ApartmentBuilding(30, 10, true));
            add(new Garden(15, TypeOfSoil.PEAT, 10));
            add(new House(30, 5, 2));
            add(new Pool(30, 10, 24));
        }};
    }
    public ArrayList<Product> createProducts(){
        return new ArrayList<Product>(){{
                add(new Product("plywood", 50, 10, 300));
                add(new Product("steel", 50, 10, 300));
                add(new Product("log", 50, 10, 300));
                add(new Product("concrete", 50, 10, 300));
                add(new Product("glass", 50, 10, 300));
                add(new Product("pallet", 50, 10, 300));
                add(new Product("ceramic", LocalDate.of(2024, 8, 5), 50, 10, 300));
            }};
    }

    public ArrayList<Project> createProjects(){
        return new ArrayList<Project>(){{
            add(new Project(LocalDate.of(2000,11,1), LocalDate.of(2001,11,1), TypeOfProject.HOUSE, "test project", (Client) clients[0]));
        }};
    }

    public static Person[] getClients() {
        return clients;
    }

    public static Person[] getWorkers() {
        return workers;
    }

    public static ArrayList<Structure> getStructures() {
        return structures;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static ArrayList<Project> getProjects() {
        return projects;
    }
}
