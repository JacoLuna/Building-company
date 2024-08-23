package classes.services;

import classes.projects.Bill;
import classes.projects.Project;
import classes.projects.types.*;
import enums.TypeOfProject;
import enums.TypeOfSoil;

import java.util.*;

public class MenuService {
    private static final int PERSON_OPTION = 0;
    private static final int STRUCTURE_OPTION = 1;
    private static final int PRODUCT_OPTION = 2;
    private static final int EXIT_OPTION = 3;

    private static final int INFORMATION_OPTION = 0;
    private static final int PROJECT_OPTION = 1;
    private static final int BEGIN_PROJECT_OPTION = 2;

    InputService inputSrv = new InputService();
    Scanner keyboard = new Scanner(System.in);

    public void printFrame(String word, int frame) {
        int middleSection = frame - word.length() - 1;
        printLine(frame);
        printMiddleSection(word, middleSection);
        printLine(frame);
    }
    public void printFrame(String word) {
        printFrame(word, 30);
    }
    private void printLine(int frame) {
        for (int i = 0; i < frame; i++) {
            System.out.print("-" + ((i == frame - 1) ? "\n" : ""));
        }
    }
    private void printMiddleSection(String word, int middleSection) {
        for (int i = 0; i < middleSection; i++) {
            if (i == (middleSection / 2)) {
                System.out.print(word);
            } else {
                if (i == middleSection - 1 || i == 0) {
                    System.out.print(((i == middleSection - 1) ? "  |\n" : "|"));
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
    public String printMenu(String title, String[] ans) {
        printFrame(title);
        return buildMenuString(ans);
    }
    public String printMenu(String title, String[] ans, int frame) {
        printFrame(title, frame);
        return buildMenuString(ans);
    }
    public String printMenu(String[] ans) {
        return buildMenuString(ans);
    }
    private String buildMenuString(String[] ans) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            sb.append(i).append(" ").append(ans[i]).append("\n");
        }
        return sb.toString();
    }
    public void userMenu(){
    }
    public void AMDMenu(){
        do {
            System.out.print(printMenu("AMD",new String[]{"Person","Structure","Product", "Exit"}));
            inputSrv.setIntAns(Arrays.asList(PERSON_OPTION, STRUCTURE_OPTION, PRODUCT_OPTION, EXIT_OPTION));
            switch (inputSrv.getAns()){
                case PERSON_OPTION:
                    //TODO AMD Persons
                    break;
                case STRUCTURE_OPTION:
                    //TODO AMD structures
                    break;
                case PRODUCT_OPTION:
                    //TODO AMD Products
                    break;
            }
        }while (inputSrv.getAns() != EXIT_OPTION);
    }
    public void objectMenu(){
        do {
            System.out.print(printMenu("Objects",new String[]{"Exit"}));
            //TODO
            inputSrv.setIntAns(Arrays.asList(EXIT_OPTION));
        }while (inputSrv.getAns() != 0);
    }
    public int projectMenu() {
        do {
            System.out.print(printMenu("Projects", new String[]{"Begin project", "Exit"}));
            inputSrv.setIntAns(Arrays.asList(BEGIN_PROJECT_OPTION ,EXIT_OPTION));
        }while (inputSrv.getAns() != EXIT_OPTION);
        return inputSrv.getAns();
    }

    public int myProfileMenu() {
        do {
            System.out.print(printMenu("My profile",new String[]{"Information","Projects","", "Exit"}));
            inputSrv.setIntAns(Arrays.asList(INFORMATION_OPTION, PROJECT_OPTION, EXIT_OPTION));
        }while (inputSrv.getAns() != EXIT_OPTION);
        return inputSrv.getAns();
    }
}
