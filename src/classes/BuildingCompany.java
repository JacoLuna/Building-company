package classes;

import classes.People.*;
import classes.projects.*;
import classes.projects.types.*;
import classes.services.MenuService;
import enums.*;

import java.awt.*;
import java.util.*;

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
        Structure apartment = new ApartmentBuilding(30, 10, true);
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
                MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>(){{
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
                    MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>(){{
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
                    MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>(){{
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
        float squareMetersOfSoil;
        int rooms;
        int bathrooms;
        int storeys;
        boolean MRP;
        float depth;
        float temperature;
        do {
            System.out.print(MenuService.printMenu("Projects",new String[]{"Begin project","Exit"}));
            MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>(){{ add(0);}}
            );
            if (MenuService.getAns() == 0) {
                System.out.print(MenuService.printMenu("What type of project do you want to do?", typeOfProjects));
                projectIndex = MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>() {{
                        for (int i = 0; i < typeOfProjects.length ; i++) {
                            add(i);
                        }
                    }}
                );

                if (MenuService.getAns() != -1) {
                    switch (MenuService.getAns()){
                        case 0:
                            do {
                                System.out.print("how many bathrooms will the house have?");
                                bathrooms = MenuService.setIntAns(keyboard.nextInt(), 0, 100);
                            }while (bathrooms != -1);
                            do {
                                System.out.print("how many rooms will the house have?");
                                rooms = MenuService.setIntAns(keyboard.nextInt(), 0, 100);
                            }while (rooms != -1);
                            break;
                        case 1:
                            do {
                                System.out.print("how many storeys will the Apartment Building have?");
                                storeys = MenuService.setIntAns(keyboard.nextInt(), 0, 100);
                            }while (storeys != -1);
                                MenuService.printMenu("will the building have an MRP?",new String[]{"Yes","No"});
                                MRP = MenuService.setIntAns(keyboard.nextInt(),new ArrayList<>(){{
                                    add(0);
                                    add(1);
                                    }}) == 0;
                            break;
                        case 2:
                            do {
                                System.out.print("how deep will the pool be?");
                                squareMetersOfSoil = MenuService.setFloatAns(keyboard.nextFloat(), 0, 100);
                            }while (squareMetersOfSoil != -1);
                            do {
                                System.out.print("how is the temperature going to be?");
                                squareMetersOfSoil = MenuService.setFloatAns(keyboard.nextFloat(), 15, 30);
                            }while (squareMetersOfSoil != -1);
                            break;
                        case 3:
                            do {
                                System.out.print(MenuService.printMenu("what type of soil will be used?", typeOfSoil));
                                soilIndex = MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>() {{
                                            for (int i = 0; i < typeOfSoil.length ; i++) {
                                                add(i);
                                            }
                                        }}
                                );
                            }while (soilIndex != -1);
                            do {
                                System.out.print("how many square meters of soil will be used?");
                                squareMetersOfSoil = MenuService.setFloatAns(keyboard.nextFloat(), 0, 100);
                            }while (squareMetersOfSoil != -1);
                            break;
                    }
                }
            }
        }while (MenuService.getAns() != 1);
    }
}
