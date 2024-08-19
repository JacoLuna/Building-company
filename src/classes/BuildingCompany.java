package classes;

import classes.People.*;
import classes.projects.*;
import classes.projects.types.*;
import classes.services.MenuService;
import enums.*;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class BuildingCompany {

    MenuService menuSrc = new MenuService();
    Scanner keyboard = new Scanner(System.in);
    Person[] clients = new Client[5];
    Person[] workers = new Worker[5];

    public void createClients(){
        for (int i = 0; i < 5; i++) {
            clients[i] = new Client("clients_name_" + i,"clients_lastName_" + i,"clients_country_" + i,new Date(), false);
        }
    }
    public void createWorkers(){
        for (int i = 0; i < 5; i++) {
            workers[i] = new Worker("worker_name_" + i,"worker_lastName_" + i,"worker_country_" + i,new Date(), 1500 ,"junior");
        }
    }
    public void createStructures(){
        Structure apartment = new Apartment(30, 10, true);
        Structure garden = new Garden(15, TypeOfSoil.PEAT,10);
        Structure house = new House(30, 5, 2);
        Structure pool = new Pool(30, 10, 24);
    }
    public void createProducts(){
        Product plywood = new Product("plywood",50,10,300);
        Product steel = new Product("steel",50,10,300);
        Product log = new Product("log",50,10,300);
        Product concrete = new Product("concrete",50,10,300);
        Product glass = new Product("glass",50,10,300);
        Product pallet = new Product("pallet",50,10,300);
        Product ceramic = new Product("ceramic", new Date(2024, Calendar.SEPTEMBER, 5),50,10,300);
    }
    public void startProgram(){
        do {
            System.out.print(MenuService.printMenu("Menu", new String[]{"AMD", "Print Objects", "Begin Project","Exit"}) );
                MenuService.setAns(keyboard.nextInt(), new ArrayList<Integer>(){{
                    add(0);
                    add(1);
                    add(2);
                    add(3);
                    }}
            );
            switch (MenuService.getAns()){
                case 0:
                    AMDMenu();
                    break;
                case 1:
                    objectMenu();
                    break;
                case 2:
                    projectMenu();
                    break;
            }
        }while (MenuService.getAns() != 3);
    }
    public void AMDMenu(){
        do {
            System.out.print(MenuService.printMenu("AMD",new String[]{"Person","Structure","Product", "Exit"}));
                    MenuService.setAns(keyboard.nextInt(), new ArrayList<Integer>(){{
                                add(0);
                                add(1);
                                add(2);
                                add(3);
                            }}
            );
            switch (MenuService.getAns()){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }while (MenuService.getAns() != 3);
    }
    public void objectMenu(){
        do {
            System.out.print(MenuService.printMenu("Objects",new String[]{"Exit"}));
                    MenuService.setAns(keyboard.nextInt(), new ArrayList<Integer>(){{
                                add(0);
                            }}
            );
        }while (MenuService.getAns() != 0);
    }
    public void projectMenu(){
        String[] typeOfProjects = Arrays.stream(ProjectType.values()).map(Enum::name).toArray(String[]::new);
        String[] typeOfSoil = Arrays.stream(TypeOfSoil.values()).map(Enum::name).toArray(String[]::new);
        int projectIndex;
        int soilIndex;
        int squareMetersOfSoilIndex;
        do {
            System.out.print(MenuService.printMenu("Projects",new String[]{"Begin project","Exit"}));
            MenuService.setAns(keyboard.nextInt(), new ArrayList<Integer>(){{ add(0);}}
            );
            if (MenuService.getAns() == 0) {
                System.out.print(MenuService.printMenu("What type of project do you want to do?", typeOfProjects));
                projectIndex = MenuService.setAns(keyboard.nextInt(), new ArrayList<Integer>() {{
                        for (int i = 0; i < typeOfProjects.length ; i++) {
                            add(i);
                        }
                    }}
                );

                if (MenuService.getAns() != -1) {
                    switch (MenuService.getAns()){
                        case 0:
                            System.out.print(MenuService.printMenu("what type Of Soil will be used?", typeOfSoil));
                            soilIndex = MenuService.setAns(keyboard.nextInt(), new ArrayList<Integer>() {{
                                    for (int i = 0; i < typeOfSoil.length ; i++) {
                                        add(i);
                                    }
                                }}
                            );

                            System.out.print(MenuService.printMenu("how many square meters of soil will be used?"));
                            squareMetersOfSoilIndex = MenuService.setAns(keyboard.nextInt(), new ArrayList<Integer>() {{
                                        for (int i = 0; i < typeOfSoil.length ; i++) {
                                            add(i);
                                        }
                                    }}
                            );
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                }
            }
        }while (MenuService.getAns() != 1);
    }
}
