package classes.projects;

import classes.People.Client;
import classes.People.Worker;
import enums.ProjectType;

import java.util.Date;

public class Project {
    Date startingDate;
    Date projectedEnd;
    Date endingDate;
    ProjectType[] projectTypes;
    String projectName;
    Client client;
    Worker[] workers;
    Bill bill;
    float budget;

    public Project(Date startingDate, Date projectedEnd, Date endingDate, ProjectType[] projectTypes, String projectName, Client client, Worker[] workers, Bill bill, float budget) {
        this.startingDate = startingDate;
        this.projectedEnd = projectedEnd;
        this.endingDate = endingDate;
        this.projectTypes = projectTypes;
        this.projectName = projectName;
        this.client = client;
        this.workers = workers;
        this.bill = bill;
        this.budget = budget;
    }
}
