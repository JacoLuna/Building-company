package classes.services;

import classes.People.Client;
import classes.People.Person;
import classes.People.Worker;
import classes.projects.Product;
import classes.projects.types.*;
import enums.TypeOfSoil;

import java.util.Calendar;
import java.util.Date;

public class InstancesService {
    Person[] clients = new Client[5];
    Person[] workers = new Worker[5];
    public void createClients(){
        for (int i = 0; i < 5; i++) {
            clients[i] = new Client("clients_name_" + i,"clients_lastName_" + i,"clients_country_" + i,new Date(),false, "1234");
        }
    }
    public void createWorkers(){
        for (int i = 0; i < 5; i++) {
            workers[i] = new Worker("worker_name_" + i,"worker_lastName_" + i,"worker_country_" + i,new Date(), 1500 ,"junior", "1234");
        }
    }
    public Structure[] createStructures(){
        return new Structure[]{
                new ApartmentBuilding(30, 10, true),
                new Garden(15, TypeOfSoil.PEAT, 10),
                new House(30, 5, 2),
                new Pool(30, 10, 24),
        };
    }
    public void createProducts(){
        Product plywood = new Product("plywood",50,10,300);
        Product steel = new Product("steel",50,10,300);
        Product log = new Product("log",50,10,300);
        Product concrete = new Product("concrete",50,10,300);
        Product glass = new Product("glass",50,10,300);
        Product pallet = new Product("pallet",50,10,300);
        Product ceramic = new Product("ceramic", new Date(2024, Calendar.SEPTEMBER, 5),50,10,300);
    }
}
