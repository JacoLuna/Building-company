import classes.BuildingCompany;
import classes.People.*;
import classes.projects.types.*;
import enums.ProjectType;
import enums.TypeOfSoil;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BuildingCompany bc = new BuildingCompany();
        bc.createClients();
        bc.createWorkers();
        bc.createStructures();
        bc.startProgram();
    }
}