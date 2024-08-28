package classes.projects.types;

import enums.TypeOfProject;

import java.util.Objects;

public final class House extends Structure {
    int rooms;
    int bathrooms;

    public House(long squareMeters, int rooms, int bathrooms) {
        super(TypeOfProject.HOUSE, squareMeters);
        this.rooms = rooms;
        this.bathrooms = bathrooms;
    }

    @Override
    public String printInformation() {
        return "House containing:" + rooms + " rooms " + bathrooms + " bathrooms" + super.generalInfo();
    }
}
