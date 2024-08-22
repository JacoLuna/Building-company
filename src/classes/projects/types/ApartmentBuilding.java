package classes.projects.types;

import enums.TypeOfProject;

import java.util.Objects;

public class ApartmentBuilding extends Structure {
    int storeys;
    boolean MRP; //multipurpose room

    public ApartmentBuilding(long squareMeters, int storeys, boolean MRP) {
        super(TypeOfProject.APARTMENT, squareMeters);
        this.storeys = storeys;
        this.MRP = MRP;
    }

    @Override
    public String printInformation() {
        return "Apartment building containing:" + storeys + " storeys " + ((MRP)?"a multipurpose room":"") + super.generalInfo();
    }
}
