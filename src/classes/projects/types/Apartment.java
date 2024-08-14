package classes.projects.types;

import enums.ProjectType;

public class Apartment extends Structure {
    int storeys;
    boolean MRP; //multipurpose room

    public Apartment(long squareMeters, int storeys, boolean MRP) {
        super(ProjectType.APARTMENT, squareMeters);
        this.storeys = storeys;
        this.MRP = MRP;
    }

    @Override
    public String showDescription() {
        return "Apartment building containing:" + storeys + " storeys " + ((MRP)?"a multipurpose room":"") + super.generalInfo();
    }
}
