package classes.projects.types;

import enums.ProjectType;

public class Department extends Building{
    int floors;
    boolean MRP; //multi-purpouse room

    public Department(ProjectType name, long squareMeters, int floors, boolean MRP) {
        super(name, squareMeters);
        this.floors = floors;
        this.MRP = MRP;
    }
}
