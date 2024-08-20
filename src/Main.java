import classes.BuildingCompany;

public class Main {
    public static void main(String[] args) {
        BuildingCompany bc = new BuildingCompany();
        bc.createClients();
        bc.createWorkers();
        bc.createStructures();
        bc.startProgram();
    }
}