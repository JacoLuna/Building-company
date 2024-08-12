import classes.People.Client;
import classes.People.Person;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Person[] clients = new Client[5];

        for (int i = 0; i < 5; i++) {
            clients[i] = new Client("name" + i,"lastName" + i,"country" + i,new Date(), false);
        }

        for (Person client: clients){
            client.printInformation();
        }
    }
}