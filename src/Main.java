import classes.Persons.Client;
import classes.Persons.Person;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Person[] clients = new Client[5];

        for (int i = 0; i < 5; i++) {
            clients[i] = new Client("name" + i,"lastName" + i,"country" + i,new Date());
        }

        for (Person client: clients){
            client.printInformation();
        }
    }
}