package classes.services;

import classes.projects.Bill;
import classes.projects.Project;
import classes.projects.types.*;
import enums.TypeOfProject;
import enums.TypeOfSoil;

import java.util.*;

public class MenuService {
    private static final int PERSON = 0;
    private static final int STRUCTURE = 1;
    private static final int PRODUCT = 2;
    private static final int EXIT = 3;

    private static final int BEGIN_PROJECT = 0;

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
            inputSrv.setIntAns(keyboard.nextInt(), Arrays.asList(PERSON, STRUCTURE, PRODUCT, EXIT));
            switch (inputSrv.getAns()){
                case PERSON:
                    break;
                case STRUCTURE:
                    break;
                case PRODUCT:
                    break;
            }
        }while (inputSrv.getAns() != EXIT);
    }
    public void objectMenu(){
        do {
            System.out.print(printMenu("Objects",new String[]{"Exit"}));
            inputSrv.setIntAns(keyboard.nextInt(), Arrays.asList(EXIT));
        }while (inputSrv.getAns() != 0);
    }
    public void projectMenu() {
        String[] typeOfProjects = Arrays.stream(TypeOfProject.values()).map(Enum::name).toArray(String[]::new);
        String[] typeOfSoil = Arrays.stream(TypeOfSoil.values()).map(Enum::name).toArray(String[]::new);
        int projectIndex, soilIndex, rooms, bathrooms, storeys;
        float depth, temperature, squareMetersOfSoil;
        long squareMeters;
        boolean MRP;
        Structure structure = null;

        do {
            System.out.print(printMenu("Projects", new String[]{"Begin project", "Exit"}));
            inputSrv.setIntAns(keyboard.nextInt(), Arrays.asList(BEGIN_PROJECT ,EXIT));
            if (inputSrv.getAns() == 0) {
                projectIndex = getProjectIndex(typeOfProjects);
                if (projectIndex != -1) {
                    squareMeters = getSquareMeters();
                    structure = createStructure(typeOfProjects[projectIndex], squareMeters, typeOfSoil);
                    if (structure != null) {
                        System.out.println(structure.showDescription());
                    }
                }
            }
        } while (inputSrv.getAns() != 1);
    }

    private int getProjectIndex(String[] typeOfProjects) {
        int projectIndex;
        do {
            String prompt = "What type of project do you want to do?";
            System.out.print(printMenu(prompt, typeOfProjects, prompt.length() * 2));
            projectIndex = inputSrv.setIntAns(keyboard.nextInt(), createIndexList(typeOfProjects.length));
        } while (projectIndex == -1);
        return projectIndex;
    }

    private long getSquareMeters() {
        long squareMeters;
        do {
            System.out.print("size of the project in square meters: ");
            squareMeters = inputSrv.setLongAns(keyboard.nextLong(), 0, 100);
        } while (squareMeters == -1);
        return squareMeters;
    }

    private Structure createStructure(String projectType, long squareMeters, String[] typeOfSoil) {
        return switch (projectType) {
            case "HOUSE" -> createHouse(squareMeters);
            case "APARTMENT" -> createApartmentBuilding(squareMeters);
            case "POOL" -> createPool(squareMeters);
            case "GARDEN" -> createGarden(squareMeters, typeOfSoil);
            default -> null;
        };
    }

    private House createHouse(long squareMeters) {
        int bathrooms = inputSrv.setIntAns("how many bathrooms will the house have?", keyboard.nextInt(), 0, 100);
        int rooms = inputSrv.setIntAns("how many rooms will the house have?", keyboard.nextInt(), 0, 100);
        return new House(squareMeters, rooms, bathrooms);
    }

    private ApartmentBuilding createApartmentBuilding(long squareMeters) {
        int storeys = inputSrv.setIntAns("how many storeys will the Apartment Building have?", keyboard.nextInt(), 0, 100);
        System.out.print(printMenu("will the building have an MRP?", new String[]{"Yes", "No"}));
        boolean MRP = inputSrv.setIntAns(keyboard.nextInt(), Arrays.asList(0, 1)) == 0;
        return new ApartmentBuilding(squareMeters, storeys, MRP);
    }

    private Pool createPool(long squareMeters) {
        float depth = inputSrv.setFloatAns("how deep will the pool be?", keyboard.nextFloat(), 0, 100);
        float temperature = inputSrv.setFloatAns("how is the temperature going to be?", keyboard.nextFloat(), 20, 30);
        return new Pool(squareMeters, depth, temperature);
    }

    private Garden createGarden(long squareMeters, String[] typeOfSoil) {
        int soilIndex = getSoilIndex(typeOfSoil);
        float squareMetersOfSoil = inputSrv.setFloatAns("how many square meters of soil will be used?", keyboard.nextFloat(), 0, squareMeters);
        return new Garden(squareMeters, TypeOfSoil.valueOf(typeOfSoil[soilIndex]), squareMetersOfSoil);
    }
    private int getSoilIndex(String[] typeOfSoil) {
        int soilIndex;
        do {
            System.out.print(printMenu("what type of soil will be used?", typeOfSoil));
            soilIndex = inputSrv.setIntAns(keyboard.nextInt(), createIndexList(typeOfSoil.length));
        } while (soilIndex == -1);
        return soilIndex;
    }

    private List<Integer> createIndexList(int length) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            indexList.add(i);
        }
        return indexList;
    }
}
