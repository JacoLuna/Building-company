import classes.People.*;
import classes.projects.types.*;
import enums.ProjectType;
import enums.TypeOfSoil;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Person[] clients = new Client[5];
        Person[] workers = new Worker[5];

        for (int i = 0; i < 5; i++) {
            clients[i] = new Client("clients_name_" + i,"clients_lastName_" + i,"clients_country_" + i,new Date(), false);
        }
        for (int i = 0; i < 5; i++) {
            workers[i] = new Worker("worker_name_" + i,"worker_lastName_" + i,"worker_country_" + i,new Date(), 1500 ,"junior");
        }

        for (Person client: clients){
            System.out.println(client.toString());
        }
        System.out.println();
        for (Person worker: workers){
            System.out.println(worker.toString());
        }
        System.out.println();

        Structure apartment = new Apartment(30, 10, true);
        Structure garden = new Garden(15, TypeOfSoil.PEAT,10);
        Structure house = new House(30, 5, 2);
        Structure pool = new Pool(30, 10, 24);
        System.out.println(apartment.showDescription());
        System.out.println(garden.showDescription());
        System.out.println(house.showDescription());
        System.out.println(pool.showDescription());
    }
}