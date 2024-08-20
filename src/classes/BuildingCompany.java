package classes;

import classes.People.*;
import classes.projects.*;
import classes.projects.types.*;
import classes.services.Global;
import classes.services.MenuService;
import enums.*;

import java.util.*;

public final class BuildingCompany {

    Scanner keyboard = new Scanner(System.in);
    Person[] clients = new Client[5];
    Person[] workers = new Worker[5];
    boolean isLoggedIn = false;
    public void createClients(){
        for (int i = 0; i < 5; i++) {
            clients[i] = new Client("clients_name_" + i,"clients_lastName_" + i,"clients_country_" + i,new Date(),false, "1234");
        }
    }
    public void createWorkers(){
        for (int i = 0; i < 5; i++) {
            workers[i] = new Worker("worker_name_" + i,"worker_lastName_" + i,"worker_country_" + i,new Date(), 1500 ,"junior", "1234");
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
            if (isLoggedIn){
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
            }else {
                System.out.print(MenuService.printMenu("Menu", new String[]{"Sign in", "Log in", "admin_client", "admin_worker", "Exit"}) );
                MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>(){{
                            add(0);
                            add(1);
                            add(2);
                        }}
                );
                switch (MenuService.getAns()){
                    case 0:
                        Person.signIn("","");
                        break;
                    case 1:
                        Person.logIn();
                        break;
                    case 2:
                        Global.user = new Client("admin","admin","Argentina",new Date(),false, "admin");
                        break;
                    case 3:
                        Global.user = new Worker("admin","admin","Argentina",new Date(),1500 ,"junior", "admin");
                        break;
                }
            }
        }while (isLoggedIn && MenuService.getAns() != 3 || !isLoggedIn && MenuService.getAns() != 4);
    }
    private void userMenu(){

    }
    private void AMDMenu(){
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
    private void objectMenu(){
        do {
            System.out.print(MenuService.printMenu("Objects",new String[]{"Exit"}));
                    MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>(){{
                                add(0);
                            }}
            );
        }while (MenuService.getAns() != 0);
    }
    private void projectMenu(){
        String[] typeOfProjects = Arrays.stream(TypeOfProject.values()).map(Enum::name).toArray(String[]::new);
        String[] typeOfSoil = Arrays.stream(TypeOfSoil.values()).map(Enum::name).toArray(String[]::new);
        int projectIndex,soilIndex, rooms, bathrooms, storeys;
        float depth, temperature, squareMetersOfSoil;
        long squareMeters;
        boolean MRP;
        Structure structure = null;
        Bill bill = null;
        Project project = null;
        do {
            System.out.print(MenuService.printMenu("Projects",new String[]{"Begin project","Exit"}));
            MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>(){{ add(0);}}
            );
            if (MenuService.getAns() == 0) {
                do {
                    System.out.print(MenuService.printMenu("What type of project do you want to do?", typeOfProjects));
                    projectIndex = MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>() {{
                            for (int i = 0; i < typeOfProjects.length ; i++) {
                                add(i);
                            }
                        }}
                    );
                }while (projectIndex == -1);
                if (MenuService.getAns() != -1) {
                    do {
                        System.out.print("how much square meters will the project have?");
                        squareMeters = MenuService.setLongAns(keyboard.nextLong(), 0, 100);
                    }while (squareMeters == -1);
                    switch (typeOfProjects[projectIndex]){
                        case "HOUSE":
                            do {
                                System.out.print("how many bathrooms will the house have?");
                                bathrooms = MenuService.setIntAns(keyboard.nextInt(), 0, 100);
                            }while (bathrooms == -1);
                            do {
                                System.out.print("how many rooms will the house have?");
                                rooms = MenuService.setIntAns(keyboard.nextInt(), 0, 100);
                            }while (rooms == -1);
                            structure = new House(squareMeters, bathrooms, rooms);
                            break;
                        case "APARTMENT":
                            do {
                                System.out.print("how many storeys will the Apartment Building have?");
                                storeys = MenuService.setIntAns(keyboard.nextInt(), 0, 100);
                            }while (storeys == -1);
                                MenuService.printMenu("will the building have an MRP?",new String[]{"Yes","No"});
                                MRP = MenuService.setIntAns(keyboard.nextInt(),new ArrayList<>(){{
                                    add(0);
                                    add(1);
                                    }}) == 0;
                            structure = new ApartmentBuilding(squareMeters, storeys, MRP);
                            break;
                        case "POOL":
                            do {
                                System.out.print("how deep will the pool be?");
                                depth = MenuService.setFloatAns(keyboard.nextFloat(), 0, 100);
                            }while (depth == -1);
                            do {
                                System.out.print("how is the temperature going to be?");
                                temperature = MenuService.setFloatAns(keyboard.nextFloat(), 15, 30);
                            }while (temperature == -1);
                            structure = new Pool(squareMeters, depth, temperature);
                            break;
                        case "GARDEN":
                            do {
                                System.out.print(MenuService.printMenu("what type of soil will be used?", typeOfSoil));
                                soilIndex = MenuService.setIntAns(keyboard.nextInt(), new ArrayList<Integer>() {{
                                            for (int i = 0; i < typeOfSoil.length ; i++) {
                                                add(i);
                                            }
                                        }}
                                );
                            }while (soilIndex == -1);
                            do {
                                System.out.print("how many square meters of soil will be used?");
                                squareMetersOfSoil = MenuService.setFloatAns(keyboard.nextFloat(), 0, squareMeters);
                            }while (squareMetersOfSoil == -1);
                            structure = new Garden(squareMeters, TypeOfSoil.valueOf(typeOfSoil[soilIndex]) , squareMetersOfSoil);
                            break;
                    }
                    //TODO make the client set an staring Date, a projected ending date, a name for the project, and then make an admin or boss set the workers of the project
//                    project = new Project(new Date(),new Date(), TypeOfProject.valueOf(typeOfProjects[projectIndex]),"project", (Client) Global.user,(Worker[]) workers);
                    //TODO after the client chooses what he wants, make a way of knowing what kind and how many materials will be use in order to set the price of the project
                    //bill = new Bill(project,,,new Date());
                    System.out.println(structure.toString());
                }
            }
        }while (MenuService.getAns() != 1);
    }
}
