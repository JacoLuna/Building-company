package classes;

import classes.People.*;
import classes.services.*;

import java.util.*;

public final class BuildingCompany {
    private static final int AMD_OPTION = 0;
    private static final int PRINT_OBJECTS_OPTION = 1;
    private static final int MY_PROFILE_OPTION = 2;
    private static final int BEGIN_PROJECT_OPTION = 3;
    private static final int MANAGE_PROJECT_OPTION = 4;
    private static final int EXIT_OPTION = 5;

    private static final int SIGN_IN_OPTION = 0;
    private static final int LOG_IN_OPTION = 1;
    private static final int ADMIN_CLIENT_OPTION = 2001;
    private static final int ADMIN_WORKER_OPTION = 312;
    private static final int EXIT_LOGGED_OUT_OPTION = 2;

    MenuService menuSrv = new MenuService();
    InputService inputSrv = new InputService();
    DefaultDataService instanceSrv = new DefaultDataService();
    StructureService structureSrc = new StructureService();
    ProjectService projectSrv = new ProjectService();

    public void startProgram() {
        instanceSrv.instantiateAll();
        do {
            if (Global.LogIn) {
                displayMenu(new String[]{"AMD", "Print Objects", "My profile", "Begin Project", "Manage project", "Exit"},
                        Arrays.asList(AMD_OPTION, PRINT_OBJECTS_OPTION, MY_PROFILE_OPTION, BEGIN_PROJECT_OPTION, MANAGE_PROJECT_OPTION, EXIT_OPTION));
            } else {
                displayMenu(new String[]{"Sign in", "Log in", "Exit"},
                        Arrays.asList(SIGN_IN_OPTION, LOG_IN_OPTION, ADMIN_CLIENT_OPTION, ADMIN_WORKER_OPTION, EXIT_LOGGED_OUT_OPTION));
            }
        } while (Global.LogIn && inputSrv.getAns() != EXIT_OPTION || !Global.LogIn && inputSrv.getAns() != EXIT_LOGGED_OUT_OPTION);
    }

    private void displayMenu(String[] options, List<Integer> validOptions) {
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
                menuSrv.AMDMenu();
                break;
            case PRINT_OBJECTS_OPTION:
                menuSrv.objectMenu();
                break;
            case  MY_PROFILE_OPTION:
                switch (menuSrv.myProfileMenu()){
                    case 0:
                        Global.user.printInformation();
                        break;
                    case 1:
                        System.out.println(Global.user.printInformation());
                        break;
                }
                break;
            case BEGIN_PROJECT_OPTION:
                if (menuSrv.projectMenu() == 0){
                    structureSrc.createStructure();
                }
                break;
            case MANAGE_PROJECT_OPTION:
                projectSrv.createProject();
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
            case ADMIN_CLIENT_OPTION:
                Global.user = new Client("admin", "admin", "Argentina", new Date(), false, "admin");
                Global.LogIn = true;
                System.out.println("log in as a client");
                break;
            case ADMIN_WORKER_OPTION:
                Global.user = new Worker("admin", "admin", "Argentina", new Date(), 1500, "junior", "admin");
                Global.LogIn = true;
                System.out.println("log in as a worker");
                break;
        }
    }
}