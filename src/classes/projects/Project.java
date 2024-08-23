package classes.projects;

import classes.People.Client;
import classes.People.Worker;
import classes.interfaces.Printable;
import classes.services.MenuService;
import enums.TypeOfProject;

import java.util.Arrays;
import java.util.Date;

public class Project implements Printable {
    Date startingDate;
    Date projectedEnd;
    Date endingDate;
    TypeOfProject projectType;
    String projectName;
    Client client;
    Worker[] workers;

    public Project(Date startingDate, Date projectedEnd, TypeOfProject projectType, String projectName, Client client) {
        this.startingDate = startingDate;
        this.projectedEnd = projectedEnd;
        this.projectType = projectType;
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

    @Override
    public String toString() {
        return "Project{" +
                "startingDate=" + startingDate +
                ", projectedEnd=" + projectedEnd +
                ", endingDate=" + endingDate +
                ", projectType=" + projectType +
                ", projectName='" + projectName + '\'' +
                ", client=" + client +
                ", workers=" + Arrays.toString(workers) +
                '}';
    }

    @Override
    public String printInformation() {
        MenuService menuSrc = new MenuService();
        menuSrc.printFrame("Project","Project".length());
        menuSrc.printFrame(startingDate.toString(), 100);
        menuSrc.printFrame(projectedEnd.toString(),100);
        menuSrc.printFrame(endingDate.toString(),100);
        menuSrc.printFrame(projectType.toString(),100);
        menuSrc.printFrame(projectName,100);
        menuSrc.printFrame(client.toString(),100);
        menuSrc.printFrame("workers", 100);
        for (Worker worker : workers){
            System.out.println(worker.name + " " + worker.lastName);
        }

        return "Project{" +
                "startingDate=" + startingDate +
                ", projectedEnd=" + projectedEnd +
                ", endingDate=" + endingDate +
                ", projectType=" + projectType +
                ", projectName='" + projectName + '\'' +
                ", client=" + client +
                ", workers=" + Arrays.toString(workers) +
                '}';
    }
}
