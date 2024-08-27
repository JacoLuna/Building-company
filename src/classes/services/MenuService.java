package classes.services;

import classes.projects.Bill;
import classes.projects.Project;
import classes.projects.types.*;
import enums.TypeOfProject;
import enums.TypeOfSoil;

import java.util.*;

public class MenuService {
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
}
