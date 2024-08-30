package classes;

import classes.Exceptions.menuException;
import classes.People.*;
import classes.projects.Project;
import classes.services.*;
import enums.TypeOfProject;

import java.time.LocalDate;
import java.util.*;

public final class BuildingCompany {
    private static final int AMD_OPTION = 0;
    private static final int PRINT_OBJECTS_OPTION = 1;
    private static final int MY_PROFILE_OPTION = 2;
    private static final int BEGIN_PROJECT_OPTION = 3;
    private static final int MANAGE_PROJECT_OPTION = 4;
    private static final int ERROR_REPORT_OPTION = 5;
    private static final int EXIT_OPTION = 6;

    private static final int SIGN_IN_OPTION = 0;
    private static final int LOG_IN_OPTION = 1;
    private static final int  EXIT_LOGGED_OUT_OPTION = 2;
    private static final int  ADMIN_CLIENT_OPTION = 2001;
    private static final int  ADMIN_WORKER_OPTION = 312;

    private static final int  PERSON_OPTION = 0;
    private static final int  STRUCTURE_OPTION = 1;
    private static final int  PRODUCT_OPTION = 2;
    private static final int  INFORMATION_OPTION = 0;
    private static final int  PROJECT_OPTION = 1;

    MenuService menuSrv = new MenuService();
    InputService inputSrv = new InputService();
    DefaultDataService instanceSrv = new DefaultDataService();
    StructureService structureSrc = new StructureService();
    ProjectService projectSrv = new ProjectService();
    FileService fileSrv = new FileService();

    public void startProgram() {
        instanceSrv.instantiateAll();

//        DefaultDataService.getProjects().get(0).addWorker( (Worker) DefaultDataService.getWorkers()[0]);
//        DefaultDataService.getProjects().get(0).addWorker( (Worker) DefaultDataService.getWorkers()[0]);

        do {
            if (Global.LogIn) {
                handleUserSession(new String[]{"AMD", "Print Objects", "My profile", "Begin Project", "Manage project", "Read error reports", "Exit"},
                        Arrays.asList(AMD_OPTION, PRINT_OBJECTS_OPTION, MY_PROFILE_OPTION, PROJECT_OPTION, PROJECT_OPTION, ERROR_REPORT_OPTION ,EXIT_OPTION));
            } else {
                handleUserSession(new String[]{"Sign in", "Log in", "Exit"},
                        Arrays.asList(SIGN_IN_OPTION, LOG_IN_OPTION,  ADMIN_CLIENT_OPTION,  ADMIN_WORKER_OPTION,  EXIT_LOGGED_OUT_OPTION));
            }
        } while (Global.LogIn && inputSrv.getAns() != EXIT_OPTION || !Global.LogIn && inputSrv.getAns() !=  EXIT_LOGGED_OUT_OPTION);
    }

    private void handleUserSession(String[] options, List<Integer> validOptions) {
        System.out.print(menuSrv.printMenu("Menu", options));
        inputSrv.setIntAns(validOptions);
            if (Global.LogIn) {
                handleLoggedInOptions();
            } else {
                handleLoggedOutOptions();
            }
    }

    private void handleLoggedInOptions() {
        switch (inputSrv.getAns()) {
            case AMD_OPTION:
                do {
                System.out.println(menuSrv.printMenu("AMD",new String[]{"Person","Structure","Product", "Exit"}));
                    inputSrv.setIntAns(Arrays.asList( PERSON_OPTION,  STRUCTURE_OPTION,  PRODUCT_OPTION, EXIT_OPTION));
                    switch (inputSrv.getAns()){
                        case  PERSON_OPTION:
                            //TODO AMD Persons
                            break;
                        case  STRUCTURE_OPTION:
                            //TODO AMD structures
                            break;
                        case  PRODUCT_OPTION:
                            //TODO AMD Products
                            break;
                    }
                }while (inputSrv.getAns() != EXIT_OPTION);
                break;
            case PRINT_OBJECTS_OPTION:
                do {
                    System.out.print(menuSrv.printMenu("Objects",new String[]{"Exit"}));
                    //TODO
                    inputSrv.setIntAns(Arrays.asList(EXIT_OPTION));
                }while (inputSrv.getAns() != 0);
                break;
            case  MY_PROFILE_OPTION:
                do {
                    System.out.print(menuSrv.printMenu("My profile",new String[]{"Information","Projects", "Exit"}));
                    inputSrv.setIntAns(Arrays.asList( INFORMATION_OPTION,  PROJECT_OPTION, EXIT_OPTION));
                }while (inputSrv.getAns() != EXIT_OPTION);
                if (inputSrv.getAns() ==  INFORMATION_OPTION){
                    Global.user.printInformation();
                }else {
                    System.out.println(Global.user.printInformation());
                }
                break;
            case BEGIN_PROJECT_OPTION:
                    do {
                        System.out.print(menuSrv.printMenu("Projects", new String[]{"Begin project", "Exit"}));
                        inputSrv.setIntAns(Arrays.asList(BEGIN_PROJECT_OPTION ,EXIT_OPTION));
                    }while (inputSrv.getAns() != EXIT_OPTION);
                    if (inputSrv.getAns() == 0)
                        structureSrc.createStructure();
                break;
            case MANAGE_PROJECT_OPTION:
                projectSrv.createProject();
                break;
            case ERROR_REPORT_OPTION:
                fileSrv.readFile("logs/app.log");
                break;
        }
    }

    private void handleLoggedOutOptions() {
        switch (inputSrv.getAns()) {
            case SIGN_IN_OPTION:
                Person.signIn();
                break;
            case LOG_IN_OPTION:
                Person.logIn("", "");
                break;
            case  ADMIN_CLIENT_OPTION:
                Global.user = new Client("admin", "admin", "Argentina", LocalDate.of(1990, 8, 5), false, "admin");
                Global.LogIn = true;
                System.out.println("log in as a client");
                break;
            case  ADMIN_WORKER_OPTION:
                Global.user = new Worker("admin", "admin", "Argentina", LocalDate.of(1990, 8, 5), 1500, "junior", "admin");
                Global.LogIn = true;
                System.out.println("log in as a worker");
                break;
        }
    }
}