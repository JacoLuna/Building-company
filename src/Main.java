import classes.BuildingCompany;
import classes.services.MenuService;

public class Main {
    public static void main(String[] args) {
        MenuService ms = new MenuService();
        BuildingCompany bc = new BuildingCompany();


        bc.startProgram();
    }
}