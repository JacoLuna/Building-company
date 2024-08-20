package classes.projects.types;

import enums.TypeOfProject;

public class ApartmentBuilding extends Structure {
    int storeys;
    boolean MRP; //multipurpose room

    public ApartmentBuilding(long squareMeters, int storeys, boolean MRP) {
        super(TypeOfProject.APARTMENT, squareMeters);
        this.storeys = storeys;
        this.MRP = MRP;
    }

    @Override
    public String showDescription() {
        return "Apartment building containing:" + storeys + " storeys " + ((MRP)?"a multipurpose room":"") + super.generalInfo();
    }
}
