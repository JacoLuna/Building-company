package classes.projects.types;

import enums.ProjectType;

public class House extends Structure {
    int rooms;
    int bathrooms;

    public House(long squareMeters, int rooms, int bathrooms) {
        super(ProjectType.HOUSE, squareMeters);
        this.rooms = rooms;
        this.bathrooms = bathrooms;
    }
    @Override
    public String showDescription() {
        return "House containing:" + rooms + " rooms " + bathrooms + " bathrooms" + super.generalInfo();
    }
}
