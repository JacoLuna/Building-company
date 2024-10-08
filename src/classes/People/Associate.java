package classes.People;

import classes.projects.Project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;

public final class Associate extends Employee{
    Dictionary<Integer, Worker> workerDictionary;
    Dictionary<Integer, Receptionist> receptionistDictionary;

    public Associate(String name, String lastName, String country, LocalDate BDay, int salary, String experience, String password) {
        super(name, lastName, country, BDay, salary, experience, password);
    }
    @Override
    public String printInformation() {
        return "";
    }
}
