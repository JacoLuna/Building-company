package classes;

import classes.People.*;
import classes.services.Global;
import classes.services.InputService;
import classes.services.MenuService;

import java.util.*;

public final class BuildingCompany {
    private static final int AMD_OPTION = 0;
    private static final int PRINT_OBJECTS_OPTION = 1;
    private static final int BEGIN_PROJECT_OPTION = 2;
    private static final int EXIT_OPTION = 3;

    private static final int SIGN_IN_OPTION = 0;
    private static final int LOG_IN_OPTION = 1;
    private static final int ADMIN_CLIENT_OPTION = 2;
    private static final int ADMIN_WORKER_OPTION = 3;
    private static final int EXIT_LOGGED_OUT_OPTION = 4;

    MenuService menuSrv = new MenuService();
    InputService inputSrv = new InputService();
    Scanner keyboard = new Scanner(System.in);

    public void startProgram() {
        do {
            if (Global.LogIn) {
                displayMenu(new String[]{"AMD", "Print Objects", "Begin Project", "Exit"},
                        Arrays.asList(AMD_OPTION, PRINT_OBJECTS_OPTION, BEGIN_PROJECT_OPTION, EXIT_OPTION));
            } else {
                displayMenu(new String[]{"Sign in", "Log in", "admin_client", "admin_worker", "Exit"},
                        Arrays.asList(SIGN_IN_OPTION, LOG_IN_OPTION, ADMIN_CLIENT_OPTION, ADMIN_WORKER_OPTION, EXIT_LOGGED_OUT_OPTION));
            }
        } while (Global.LogIn && inputSrv.getAns() != EXIT_OPTION || !Global.LogIn && inputSrv.getAns() != EXIT_LOGGED_OUT_OPTION);
    }

    private void displayMenu(String[] options, List<Integer> validOptions) {
        System.out.print(menuSrv.printMenu("Menu", options));
        inputSrv.setIntAns(keyboard.nextInt(), validOptions);
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
            case BEGIN_PROJECT_OPTION:
                menuSrv.projectMenu();
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
                break;
            case ADMIN_WORKER_OPTION:
                Global.user = new Worker("admin", "admin", "Argentina", new Date(), 1500, "junior", "admin");
                break;
        }
    }
}