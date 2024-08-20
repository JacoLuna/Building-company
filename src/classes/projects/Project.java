package classes.projects;

import classes.People.Client;
import classes.People.Worker;
import enums.TypeOfProject;

import java.util.Date;

public class Project {
    Date startingDate;
    Date projectedEnd;
    Date endingDate;
    TypeOfProject projectTypes;
    String projectName;
    Client client;
    Worker[] workers;

    public Project(Date startingDate, Date projectedEnd, TypeOfProject projectTypes, String projectName, Client client) {
        this.startingDate = startingDate;
        this.projectedEnd = projectedEnd;
        this.projectTypes = projectTypes;
        this.projectName = projectName;
        this.client = client;
    }

    public void setWorkers(Worker[] workers) {
        this.workers = workers;
    }

    public void setEndingDate(Date endingDate) {
        if (startingDate.before(endingDate)){
            this.endingDate = endingDate;
        }else {
            System.out.println("The ending date must be after the starting date");
        }
    }
}
