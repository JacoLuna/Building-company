package classes.projects.types;

import enums.ProjectType;

public class Apartment extends Building{
    int floors;
    boolean MRP; //multipurpose room

    public Apartment(ProjectType name, long squareMeters, int floors, boolean MRP) {
        super(name, squareMeters);
        this.floors = floors;
        this.MRP = MRP;
    }
}
