package classes.services;

import classes.People.Worker;
import classes.projects.Project;

import java.util.Calendar;
import java.util.Date;

public class ProjectService {
    InputService inputSrv = new InputService();
    public Project createProject(){
        Date startingDate, projectedEnd;
        String projectName;
        System.out.println("Starting date");
        startingDate = inputSrv.dateAns();
        System.out.println("projected date");
        projectedEnd = inputSrv.dateAns();
        projectName = inputSrv.stringAns("Introduce the name of the project");
        //TODO print list of available clients
        //TODO connect project with structure
        return null;
    }
}
