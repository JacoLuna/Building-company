package classes.projects.types;

import enums.ProjectType;

public class House extends Building{
    int rooms;
    int bathrooms;

    public House(ProjectType name, long squareMeters, int rooms, int bathrooms) {
        super(name, squareMeters);
        this.rooms = rooms;
        this.bathrooms = bathrooms;
    }
}
